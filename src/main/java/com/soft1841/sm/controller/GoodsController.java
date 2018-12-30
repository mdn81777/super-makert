package com.soft1841.sm.controller;
/**
 * 商品管理模块
 *
 * @author  蔡一帆
 */

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.ServiceFactory;
//import com.soft1841.sm.utils.ExcelExport;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class GoodsController implements Initializable {
    @FXML
    private TableView<Goods> goodsTable;

    @FXML
    private ComboBox<Type> typeComboBox;

    @FXML
    private TextField keywordsField;

    private ObservableList<Goods> goodsData = FXCollections.observableArrayList();

    private ObservableList<Type> typeData = FXCollections.observableArrayList();

    private GoodsService goodsService = ServiceFactory.getGoodsServiceInstance();

    private TypeService typeService = ServiceFactory.getTypeServiceInstance();

    private List<Goods> goodsList = null;

    private List<Type> typeList = null;

    private TableColumn<Goods, Goods> editCol = new TableColumn<>("操作");

    private TableColumn<Goods, Goods> delCol = new TableColumn<>("操作");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initComBox();
//        System.out.println(goodsList.size());
    }
    //表格初始化方法
    private void initTable() {
        //水平方向不显示滚动条，表格的列宽会均匀分布
        goodsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //1.调用查询所有商品的方法，
        goodsList = goodsService.getAllGoods();
        //将实体集合作为参数，调用显示数据的方法，可以在界面的表格中显示图书模型集合的值
        showGoodsData(goodsList);
        //2.编辑列的相关设置
        editCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        editCol.setCellFactory(param -> new TableCell<Goods, Goods>() {
            //通过ComponentUtil工具类的静态方法，传入按钮文字和样式，获得一个按钮对象
            private final Button editButton = ComponentUtil.getButton("编辑", "blue-theme");

            @Override
            protected void updateItem(Goods goods, boolean empty) {
                super.updateItem(goods, empty);
                if (goods == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(editButton);
                //点击编辑按钮，弹出窗口，输入需要修改的图书价格
                editButton.setOnAction(event -> {
                    TextInputDialog dialog = new TextInputDialog("请输入价格");
                    dialog.setTitle("商品修改界面");
                    dialog.setHeaderText("商品名称：" + goods.getName());
                    dialog.setContentText("请输入新的价格：");
                    Optional<String> result = dialog.showAndWait();
                    //确认输入了内容，避免NPE
                    if (result.isPresent()) {
                       // 获取输入的新价格并转化成Double数据
                        String priceString = result.get();
                        goods.setPrice(Double.parseDouble(priceString));
                        //更新图书信息
                        goodsService.updateGoods(goods);
                    }
                });
            }

        });
        //将编辑列加入商品表格
        goodsTable.getColumns().add(editCol);
        //3.删除列的相关设置
        delCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delCol.setCellFactory(param -> new TableCell<Goods, Goods>() {
            private final Button deleteButton = ComponentUtil.getButton("删除", "warning-theme");

            @Override
            protected void updateItem(Goods goods, boolean empty) {
                super.updateItem(goods, empty);
                if (goods == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(deleteButton);
                deleteButton.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("确认对话框");
                    alert.setHeaderText("请确认");
                    alert.setContentText("确定要删除这行记录吗？");
                    Optional<ButtonType> result = alert.showAndWait();
                    //点击了确认按钮，执行删除操作，同时移除一行模型数据
                    if (result.get() == ButtonType.OK) {
                        long id = goods.getId();
                        goodsData.remove(goods);
                        goodsService.deleteGoods(id);
                    }
                });
            }
        });
        //将除列加入商品表格
        goodsTable.getColumns().add(delCol);
        //4.商品表格双击事件,双击弹出显示图书详情的界面
        goodsTable.setRowFactory(tv -> {
            TableRow<Goods> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                //判断鼠标双击了一行
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    //获得该行的图书ID属性
                    long id = row.getItem().getId();
                    //根据id查询到图书的完整信息
                    Goods goods = goodsService.getGoods(id);
                    //创建一个新的图书详情界面窗口
                    Stage goodsInfoStage = new Stage();
                    goodsInfoStage.setTitle("商品详情界面");
                    //用VBox显示具体图书信息
                    VBox vBox = new VBox();
                    vBox.setSpacing(10);
                    vBox.setAlignment(Pos.CENTER);
                    vBox.setPrefSize(600, 400);
                    vBox.setPadding(new Insets(10, 10, 10, 10));
                    Label nameLabel = new Label("商品名称：" + goods.getName());
                    nameLabel.getStyleClass().add("btn-basic");
                    Label priceLabel = new Label("价格:" + goods.getPrice());
                    Label barcodeLabel = new Label("条形码;" + goods.getBarcode());
                    Label stockLabel = new Label("库存：" + goods.getStock());
                    ImageView goodsImgView = new ImageView(new Image(goods.getCover()));
                    goodsImgView.setFitHeight(150);
                    goodsImgView.setFitWidth(120);
                    Label descriptionLabel = new Label(goods.getDescription());
                    descriptionLabel.setPrefWidth(500);
                    descriptionLabel.setWrapText(true);
                    descriptionLabel.getStyleClass().add("box");
                    vBox.getChildren().addAll(nameLabel, priceLabel, barcodeLabel, stockLabel, goodsImgView, descriptionLabel);
                    Scene scene = new Scene(vBox, 700, 540);
                    //因为是一个新的窗口，需要重新读入一下样式表，这个界面就可以使用style.css样式表中的样式了
                    scene.getStylesheets().add("/css/style.css");
                    goodsInfoStage.setScene(scene);
                    goodsInfoStage.show();
                }
            });
            return row;
        });
    }
    //下拉框初始化方法
    private void initComBox() {
        //1.到数据库查询所有的类别
        typeList = typeService.getAllTypes();
        //2.将typeList集合加入typeData模型数据集合
        typeData.addAll(typeList);
        //3.将数据模型设置给下拉框
        typeComboBox.setItems(typeData);
        //4.下拉框选择事件监听，根据选择不同的类别，图书表格中会过滤出该类别的图书
        typeComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            System.out.println(newValue.getId() + "," + newValue.getTypeName());
            //移除掉之前的数据
            goodsTable.getItems().removeAll(goodsData);
            //根据选中的类别查询该类别所有图书
            goodsList = goodsService.getGoodsByTypeId(newValue.getId());
            //重新显示数据
            showGoodsData(goodsList);
                }
        );
    }

    private void showGoodsData(List<Goods> goodsList) {
        goodsData.addAll(goodsList);
        goodsTable.setItems(goodsData);
    }

    public void newGoodsStage() throws Exception {
        Stage addGoodsStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/add_goods.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        AddGoodsController addGoodsController = fxmlLoader.getController();
        addGoodsController.setGoodsData(goodsData);
        addGoodsStage.setTitle("新增商品界面");
        addGoodsStage.setResizable(false);
        addGoodsStage.setScene(scene);
        addGoodsStage.show();
    }

    public void search() {
        goodsTable.getItems().removeAll(goodsData);
        String keywords = keywordsField.getText().trim();
        goodsList = goodsService.getGoodsLike(keywords);
        showGoodsData(goodsList);
    }
}


package com.soft1841.sm.controller;
/**
 * 商品管理模块
 * @author 蔡一帆
 *
 */

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.DAOFactory;
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

    private GoodsDAO goodsDAO = DAOFactory.getGoodsDAOInstance();

    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();

    private List<Entity> goodsList = null;

    private List<Entity> typeList = null;

    private TableColumn<Goods, Goods> editCol = new TableColumn<>("操作");

    private TableColumn<Goods, Goods> delCol = new TableColumn<>("操作");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        initComBox();
    }

    private void initTable() {
        goodsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        try {
            goodsList = goodsDAO.selectAllGoods();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showGoodsData(goodsList);
        editCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        editCol.setCellFactory(param -> new TableCell<Goods, Goods>() {
            private final Button editButton = ComponentUtil.getButton("编辑", "blue-theme");

            @Override
            protected void updateItem(Goods goods, boolean empty) {
                super.updateItem(goods, empty);
                if (goods == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(editButton);
                editButton.setOnAction(event -> {
                    TextInputDialog dialog = new TextInputDialog("请输入价格");
                    dialog.setTitle("商品修改界面");
                    dialog.setHeaderText("商品名称：" + goods.getName());
                    dialog.setContentText("请输入新的价格：");
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()) {
                        String priceString = result.get();
                        goods.setPrice(Double.parseDouble(priceString));
                        try {
                            goodsDAO.updateGoods(goods);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

        });
        goodsTable.getColumns().add(editCol);
        delCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delCol.setCellFactory(param -> new TableCell<Goods, Goods>() {
            private final Button deleteButton = ComponentUtil.getButton("删除", "blue-theme");

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
                    if (result.get() == ButtonType.OK) {
                        goodsData.remove(goods);
                        try {
                            goodsDAO.deleteGoodsByBarcode(goods.getBarcode());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        goodsTable.getColumns().add(delCol);
        goodsTable.setRowFactory(tv -> {
            TableRow<Goods> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    long id = row.getItem().getId();
                    Goods goods = new Goods();
                    try {
                        Entity entity = goodsDAO.getGoodsByTypeId((int) id);
                        goods.setId(entity.getLong("id"));
                        goods.setTypeId(entity.getLong("type_id"));
                        goods.setName(entity.getStr("name"));
                        goods.setPrice(entity.getDouble("price"));
                        goods.setCover(entity.getStr("cover"));
                        goods.setDescription(entity.getStr("description"));
                        goods.setBarcode(entity.getStr("barcode"));
                        goods.setStock(entity.getInt("stock"));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    Stage goodsInfoStage = new Stage();
                    goodsInfoStage.setTitle("商品详情界面");
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
                    descriptionLabel.setPrefWidth(400);
                    descriptionLabel.setWrapText(true);
                    descriptionLabel.getStyleClass().add("box");
                    vBox.getChildren().addAll(nameLabel, priceLabel, barcodeLabel, stockLabel, goodsImgView, descriptionLabel);
                    Scene scene = new Scene(vBox, 700, 540);
                    scene.getStylesheets().add("/css/style.css");
                    goodsInfoStage.setScene(scene);
                    goodsInfoStage.show();
                }
            });
            return row;
        });
    }

    private void initComBox() {
        try {
            typeList = typeDAO.selectAllTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Entity entity : typeList) {
            Type type = new Type();
            type.setId(entity.getLong("id"));
            type.setTypeName(entity.getStr("type_name"));
            typeData.add(type);
        }
        typeComboBox.setItems(typeData);
        typeComboBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
                    goodsTable.getItems().removeAll(goodsData);
                    try {
                        goodsList = goodsDAO.selectGoodsByTypeId(newValue.getId());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    showGoodsData(goodsList);
                }
        );
    }
    private void showGoodsData(List<Entity> goodsList){
        for (Entity entity:goodsList) {
            Goods goods = new Goods();
            goods.setId(entity.getLong("id"));
            goods.setName(entity.getStr("name"));
            goods.setPrice(entity.getDouble("price"));
            goods.setStock(entity.getInt("stock"));
            goodsData.add(goods);
        }
        goodsTable.setItems(goodsData);
    }
    public void newGoodsStage()throws Exception{
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
    public void search(){
        goodsTable.getItems().removeAll(goodsData);
        String keywords = keywordsField.getText().trim();
        try {
            goodsList = goodsDAO.selectGoodsLike(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showGoodsData(goodsList);
    }
}
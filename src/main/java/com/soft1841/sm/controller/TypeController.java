package com.soft1841.sm.controller;
/**
 * 商品类别控制器
 *
 * @author 孟妮
 */

import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ColorUtil;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TypeController implements Initializable {
    //获得布局文件中的表格对象
    @FXML
    private TableView<Type> typeTable;
    @FXML
    private FlowPane typePane;
    //定义ObservableList数据集合
    private ObservableList<Type> typeData = FXCollections.observableArrayList();
    //通过工厂类获得TypeService的实例
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
    //定义Type类型集合，用来存放数据库查询结果
    private List<Type> typeList;
    private TableColumn<Type, Type> delCol = new TableColumn<>("操作");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //水平方向不显示滚动条
        typeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //在表格最后加入删除按钮
        delCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delCol.setCellFactory(param -> new TableCell<Type, Type>() {
            private final Button deleteButton = ComponentUtil.getButton("删除", "warning-theme");

            @Override
            protected void updateItem(Type type, boolean empty) {
                super.updateItem(type, empty);
                if (type == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(deleteButton);
                //点击删除按钮，需要将这一行从表格移除，同时从底层数据库真正删除
                deleteButton.setOnAction(event -> {
                    //删除操作之前，弹出确认对话框，点击确认按钮才删除
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("确认对话框");
                    alert.setHeaderText("请确认");
                    alert.setContentText("确定要删除这行记录吗?");
                    Optional<ButtonType> result = alert.showAndWait();
                    //点击了确认按钮，执行删除操作，同时移除一行模型数据
                    if (result.get() == ButtonType.OK) {
                        typeData.remove(type);
                        typeService.deleteType(type.getId());
                        //调用typeService的删除类别方法
                        typeService.deleteType(type.getId());
                        showTypePane();
                    }
                });
            }
        });
        //删除列加入表格
        typeTable.getColumns().add(delCol);
        typeList = typeService.getAllTypes();
        //显示类别的表格数据
        showTypeData(typeList);
        //显示类别的卡片展示
        showTypePane();
    }

    public void addType() {
        //创建一个输入对话框
        TextInputDialog dialog = new TextInputDialog("新类别");
        dialog.setTitle("商品类别");
        dialog.setHeaderText("新增商品类别名称");
        dialog.setContentText("请输入商品类别名称");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> System.out.println("你的输入： " + name));
        //确认输入了内容
        if (result.isPresent()) {
            //获得输入的内容
            String typeName = result.get();
            //创建一个Type对象，插入数据库，并返回主键
            Type type = new Type();
            type.setTypeName(typeName);
            long id = 0;
            id = typeService.addType(type);
            type.setId(id);
            //加入ObservableList，刷新模型，不用重新查询数据库也可以立刻看到结果
            typeData.add(type);
            showTypePane();
        }
    }

    private void showTypeData(List<Type> entityList) {
        typeData.addAll(typeList);
        typeTable.setItems(typeData);
    }

    private void showTypePane() {
        typePane.getChildren().clear();
        typeList = typeService.getAllTypes();
        //遍历类别集合数据
        for (Type type : typeList) {
            //给每个类别创建一个面板
            StackPane stackPane = new StackPane();
            //添加外部box样式（边框、圆矩形）
            stackPane.getStyleClass().add("box5");
           //设置合适大小
          stackPane.setPrefSize(50, 50);
           //通过工具类获取一个随机色值
            String colorString = ColorUtil.getColor();
           //给面板设置背景色
            stackPane.setStyle("-fx-background-color: " + colorString);
            //创建一个文本标签，内容为该类别的名称
            Label typeNameLabel = new Label(type.getTypeName());
            //给标签添加外部title样式
            typeNameLabel.getStyleClass().add("title");
            //标签加入面板
            stackPane.getChildren().add(typeNameLabel);
            //面板加入布局文件钟的流式布局
            typePane.getChildren().add(stackPane);
            //鼠标进入和离开，透明度变化效果
            stackPane.setOnMouseEntered(event -> {
                stackPane.setOpacity(0.5);
            });
            stackPane.setOnMouseExited(event -> {
                stackPane.setOpacity(1.0);
            });
        }
    }
}










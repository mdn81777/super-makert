package com.soft1841.sm.controller;

/**
 * 职位的控制器
 * @author 杨俣韬
 * 2018-12-25
 */

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Position;
import com.soft1841.sm.service.PositionService;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class PositionController implements Initializable {
    //获得布局文件中的表格对象
    @FXML
    private TableView<Position> typeTable;

    private ObservableList<Position> positionDate = FXCollections.observableArrayList();

    private PositionService positionService = ServiceFactory.getPositionServiceInstance();

    private TableColumn<Position, Position> delCol = new TableColumn<>("操作");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
    }

    private void initTable(){

        //水平方向不显示滚动条
        typeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //在表格最后加入删除按钮
        delCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delCol.setCellFactory(param -> new TableCell<Position, Position>() {
            private final Button deleteButton = ComponentUtil.getButton("删除", "warning-theme");
            @Override
            protected void updateItem(Position position, boolean empty) {
                super.updateItem(position,empty);
                if (position == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(deleteButton);
                //点击删除按钮，需要将这一行从表格移除，同时从底层数据库真正删除
                deleteButton.setOnAction(event -> {
                    //删除操作之前，弹出确认对话框，点击确认按钮才删除
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("确认");
                    alert.setHeaderText("请确认");
                    alert.setContentText("确定要删除这个职位吗？");
                    Optional<ButtonType> result = alert.showAndWait();
                    //点击了确认按钮，执行删除操作，同时移除一行模型数据
                    if (result.get() == ButtonType.OK){
                        int id =position.getId();
                        positionDate.remove(position);
                        positionService.deletePosition(id);
                    }
                });
            }
        });
        //删除列加入表格
        typeTable.getColumns().add(delCol);
    }

    public void addType() {
        //创建一个输入对话框
        TextInputDialog dialog = new TextInputDialog("新职位");
        dialog.setTitle("职位");
        dialog.setHeaderText("新增职位");
        dialog.setContentText("请输入职位名称:");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            //获得输入的内容
            String positionName = result.get();
            Position position = new Position();
            position.setPosition(positionName);
            long id;
            id = position.getId();
            position.setId((int) id);
            //加入ObservableList，刷新模型视图，不用重新查询数据库也可以立刻看到结果
            positionDate.add(position);
        }
    }
}

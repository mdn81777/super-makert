package com.soft1841.sm.controller;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.PositionDAO;
import com.soft1841.sm.entity.Position;
import com.soft1841.sm.utils.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PositionController {
    //获得布局文件中的表格对象
    @FXML
    private TableView<Position> typeTable;

    private ObservableList<Position> positionDate = FXCollections.observableArrayList();

    private PositionDAO positionDAO = DAOFactory.getPositionDAOInstance();

    private List<Entity> entityList = null;

    private TableColumn<Position, Position> delCol = new TableColumn<>("操作");

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
            //创建一个Type对象，插入数据库，并返回主键
            Position position = new Position();
            position.setPosition(positionName);
            long id = 0;
            try {
                id = positionDAO.insertPosition(position);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            position.setId((int) id);
            //加入ObservableList，刷新模型视图，不用重新查询数据库也可以立刻看到结果
            positionDate.add(position);
        }
    }

    private void showpositionData(List<Entity> entityList) {
        //遍历实体集合
        for (Entity entity : entityList) {
            //取出属性，创建Type的对象
            Position position =new Position();
            position.setId(entity.getInt("id"));
            position.setPosition(entity.getStr("position"));
            //加入ObservableList模型数据集合
            positionDate.add(position);
        }
        typeTable.setItems(positionDate);
    }
}

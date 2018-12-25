package com.soft1841.sm.controller;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.SupplierDAO;

import com.soft1841.sm.entity.Supplier;

import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.DAOFactory;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class SupplierController implements Initializable {

    @FXML
    private  TableView<Supplier> supplierTable;
    private  ObservableList<Supplier>  supplierData = FXCollections.observableArrayList();
    private SupplierDAO supplierDAO = DAOFactory.getSupplierDAOInstance();
    private  List<Entity> entityList = null;
    private TableColumn<Supplier,Supplier> delCol = new TableColumn<>("操作");
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //水平方向不显示滚动条
        supplierTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //在表格最后加入删除按钮
        delCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delCol.setCellFactory(param -> new TableCell<Supplier, Supplier>() {
            private final Button deleteButton = ComponentUtil.getButton("删除", "warning-theme");

            @Override
            protected void updateItem(Supplier supplier, boolean empty) {
                super.updateItem(supplier, empty);
                if (supplier == null) {
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
                        supplierData.remove(supplier);
                        try {
                            supplierDAO.deleteSupplierById(supplier.getId());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        //删除列加入表格
        supplierTable.getColumns().add(delCol);
        try {
            entityList = supplierDAO.selectAllSupplier();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showSupplierData(entityList);
    }
    public void listSupplier() {
        //创建一个输入对话框
        TextInputDialog dialog = new TextInputDialog("新供货商");
        dialog.setTitle("供应商");
        dialog.setHeaderText("新增供应商名称");
        dialog.setContentText("请输入供应商名称");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> System.out.println("你的输入： " + name));
        //确认输入了内容
        if (result.isPresent()) {
            //获得输入的内容
            String supplierName = result.get();
            //创建一个Type对象，插入数据库，并返回主键
            Supplier supplier = new Supplier();
            supplier.setSupplierName(supplierName);
            long id = 0;
            try {
                id = supplierDAO.insertSupplier(supplier);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            supplier.setId(id);
            //加入ObservableList，刷新模型，不用重新查询数据库也可以立刻看到结果
            supplierData.add(supplier);
        }
    }
    private  void  showSupplierData(List<Entity> entityList) {
        //遍历实体集合
        for (Entity entity : entityList) {
            Supplier supplier = new Supplier();
            supplier.setId(entity.getLong("id"));
            supplier.setSupplierName(entity.getStr("supplierName"));
            supplier.setSupplierAddress(entity.getStr("supplierAddress"));
            //加入ObservableList模型数据集合
            supplierData.add(supplier);
        }
        supplierTable.setItems(supplierData);
    }
}

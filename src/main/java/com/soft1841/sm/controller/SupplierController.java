package com.soft1841.sm.controller;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.SupplierDAO;
import com.soft1841.sm.entity.Supplier;
import com.soft1841.sm.utils.DAOFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import sun.plugin2.message.ShowStatusMessage;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class SupplierController implements Initializable {
    @FXML
    private FlowPane supplierPane;
    private SupplierDAO supplierDAO = DAOFactory.getSupplierDAOInstance();
    List<Entity>supplierList = new ArrayList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            supplierList = supplierDAO.selectAllSupplier();
        }catch (SQLException e){
            e.printStackTrace();
        }


        showSupplier(supplierList);
    }
    public void addSupperlier() throws SQLException{
        Supplier supplier = new Supplier();
        Stage stage = new Stage();
        stage.setTitle("新增供货商界面");
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20,10,10,10));
        TextField nameField = new TextField("请输入供货商名称");
        TextField addressField = new TextField("请输入供货商地址");
        TextField phoneField = new TextField("请输入供货商电话");
        javafx.scene.control.Button addBtn = new javafx.scene.control.Button("新增");
        addBtn.getStyleClass().add("blue-theme");

        Scene scene = new Scene(vBox,600,380);
        scene.getStylesheets().add("/css/style.css");
        stage.setScene(scene);
        stage.show();
        addBtn.setOnAction(event ->{
            String nameString = nameField.getText().trim();
            String addressString = addressField.getText().trim();
            String phoneString = phoneField.getText().trim();
            supplier.setSupplierName(nameString);
            supplier.getSupplierAddress();

            System.out.println(supplier.getSupplierName()+supplier.getSupplierAddress()+supplier.getSupplierPhone());
            try {
                supplierDAO.insertSupplier(supplier);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stage.close();
            //重新读取数据显示
            try {
                supplierList = supplierDAO.selectAllSupplier();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            showSupplier(supplierList);
        });
    }
    private void  showSupplier(List<Entity> supplierList){
        ObservableList<Node> observableList=supplierPane.getChildren();
        supplierPane.getChildren().removeAll(observableList);
        for (Entity entity:supplierList) {
            HBox hBox = new HBox();
            hBox.setPrefSize(320,280);
            hBox.setSpacing(10);
            hBox .setPadding(new Insets(10,10,10,10));
            hBox.getStyleClass().add("box");
            //创建左侧垂直布局
            VBox leftBox = new VBox();
            leftBox.setSpacing(10);
            leftBox.setAlignment(Pos.TOP_CENTER);
            Circle circle = new Circle();
            circle.setCenterX(40);
            circle.setCenterY(40);
            circle.setRadius(40);
            hBox.getChildren().add(leftBox);
            supplierPane.getChildren().add(hBox);
            javafx.scene.control.Label roleLabel = new javafx.scene.control.Label(entity.getStr("role"));
            leftBox.getChildren().add(roleLabel);
            VBox rightBox = new VBox();
            rightBox.setSpacing(10);
            rightBox.setAlignment(Pos.TOP_LEFT);
            javafx.scene.control.Label nameLabel = new javafx.scene.control.Label(entity.getStr("supplier_name"));
            javafx.scene.control.Label departmentLabel = new javafx.scene.control.Label(entity.getStr("supplier_address"));
            javafx.scene.control.Label emailLabel = new javafx.scene.control.Label(entity.getStr("supplier_phone"));
            javafx.scene.control.Button delButton = new javafx.scene.control.Button("删除");
            //点击删除按钮做的事件
            delButton.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("确认对话框");
                alert.setHeaderText("请确认");
                alert.setContentText("确认删除这行记录吗");
                Optional<ButtonType> result = alert.showAndWait();
                if(result.get()==ButtonType.OK){


                    //得到这个人的ID
                    try {
                        long id = entity.getLong("id");
                        supplierDAO.deleteSupplierById(id);
                        supplierPane.getChildren().remove(hBox);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }});

            delButton.getStyleClass().add("green-theme");

            rightBox.getChildren().addAll(nameLabel,delButton);
            hBox.getChildren().add(rightBox);

        }
    }
}




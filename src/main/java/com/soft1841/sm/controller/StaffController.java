package com.soft1841.sm.controller;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.StaffDAO;
import com.soft1841.sm.utils.DAOFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class StaffController implements Initializable {
    @FXML
    private FlowPane staffPane;

    private List<Entity> list = new ArrayList<>();

    private StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            list = staffDAO.selectAllStaff();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showStaff(list);
    }

    private void showStaff(List<Entity> list) {
        ObservableList<Node> observableList = staffPane.getChildren();
        staffPane.getChildren().removeAll(observableList);
        for (Entity entity : list) {
            VBox vBox = new VBox();
            vBox.setPrefSize(240, 300);
            vBox.setSpacing(10);
            vBox.setAlignment(Pos.CENTER);
            ImageView imageView = new ImageView(new Image(entity.getStr("cover")));
            imageView.setFitWidth(100);
            imageView.setFitHeight(120);
            Label nameLabel = new Label(entity.getStr("name"));
            Label addressLabel = new Label(entity.getStr("address"));
            Button delBtn = new Button("删除");
            delBtn.getStyleClass().add("warning-theme");
            vBox.getChildren().addAll(imageView, nameLabel, addressLabel, delBtn);
            staffPane.getChildren().add(vBox);
            delBtn.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("确认对话框");
                alert.setContentText("确定要删除吗?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    try {
                        long employeeId = entity.getLong("employee_id");
                        staffDAO.deleteStaffByEmployeeId(employeeId);
                        staffPane.getChildren().remove(vBox);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}

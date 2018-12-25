package com.soft1841.sm.controller;

import com.soft1841.sm.service.StaffService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button closeButton;
    @FXML
    private TextField accountField;
    @FXML
    private PasswordField passwordField;

    private StaffService staffService = ServiceFactory.getStaffServiceInstance();


    //退出按钮的功能实现
    public void closeBtnOnAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void loginBtnOnAction() {
//        System.out.println("come");
        //读取文本框的账号密码
        String accountStr = accountField.getText().trim();
        String password = passwordField.getText().trim();
        Long account = Long.parseLong(accountStr);
        boolean flag;
        int typeId = staffService.getType(account);
        if (staffService.login(account, password)) {
            flag = true;
        } else {
            flag = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText("账号或密码错误，登录失败!");
            alert.showAndWait();
        }
        String position = new String();
        if (typeId == 1) {
            position = "store_manager.fxml";
        } else if (typeId == 2) {
            position = "bookkeeper.fxml";
        } else if (typeId == 3) {
            position = "receipt.fxml";
        } else if (typeId == 4) {
            flag = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText("您的权限不足!");
            alert.showAndWait();
        } else if (typeId == 5) {
            position = "customer_service.fxml";
        }

        if (flag) {
            Stage mainStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + position));
            BorderPane root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mainStage.getIcons().add(new Image("/img/TeamLogo.png"));
            mainStage.setTitle("盐系超市后台系统");
            Scene scene = new Scene(root);
            mainStage.setMaximized(true);
            mainStage.setScene(scene);
            mainStage.show();
            Stage loginStage = (Stage) closeButton.getScene().getWindow();
            loginStage.close();
        }
    }
}


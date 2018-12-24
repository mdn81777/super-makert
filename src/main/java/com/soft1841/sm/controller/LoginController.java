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
import java.sql.SQLException;

/**
 * 这里写登录判断和权限判断
 */

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

    public void loginBtnOnAction() throws IOException {
        //读取文本框的账号密码
        String accountStr = accountField.getText().trim();
        String password = passwordField.getText().trim();
        Long account = Long.parseLong(accountStr);
        boolean flag;

            flag = staffService.login(account,password);

        if (flag) {
            Stage mainStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            BorderPane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            mainStage.getIcons().add(new Image("/img/TeamLogo.png"));
            mainStage.setTitle("盐系收银系统");
            mainStage.setMaximized(true);
            mainStage.setScene(scene);
            mainStage.show();
            Stage loginStage = (Stage) closeButton.getScene().getWindow();
            loginStage.close();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText("账号或密码错误，登录失败!");
            alert.showAndWait();
        }
    }
}

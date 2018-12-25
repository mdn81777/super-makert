package com.soft1841.sm.controller;

import com.soft1841.sm.service.StaffService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FrontDeskController {
    @FXML
    private TextField accountField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ToggleGroup user;

    private StaffService staffService = ServiceFactory.getStaffServiceInstance();
    public void login() throws Exception {
        String accountStr = accountField.getText().trim();
        String password = passwordField.getText().trim();
        Long account = Long.parseLong(accountStr);
        //调用service的登录 功能
        boolean flag = staffService.login(account, password);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        if (flag) {
            alert.setContentText("登录成功!");
            alert.showAndWait();
        } else {
            alert.setContentText("账号或密码错误，登录失败!");
            alert.showAndWait();
        }
        Stage mainStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/frontdesk.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        mainStage.setTitle("盐系FRESHMEN");
        mainStage.setMaximized(true);
        mainStage.setScene(scene);
        mainStage.getIcons().add(new Image("/img/logo.png"));
        mainStage.show();
        Stage loginStage = (Stage) accountField.getScene().getWindow();
        loginStage.close();
    }
}


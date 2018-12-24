package com.soft1841.sm.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 这里写登录判断和权限判断
 */

public class LoginController {
    @FXML
    private Button closeButton;

    //退出按钮的功能实现
    public void closeBtnOnAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void loginBtnOnAction() throws IOException {
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
    }
}

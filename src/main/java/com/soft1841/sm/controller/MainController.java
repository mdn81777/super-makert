package com.soft1841.sm.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 主控制器 按钮切换页面等
 */
public class MainController {
    @FXML
    private Button closeButton;

    @FXML
    private Button outLogin;

    public void outLoginBtnOnAction(){
        Stage stageNow = (Stage) outLogin.getScene().getWindow();
        Stage LoginStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        AnchorPane root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LoginStage.getIcons().add(new Image("/img/TeamLogo.png"));
        LoginStage.setTitle("盐系超市后台系统");
        Scene scene = new Scene(root);
        LoginStage.setScene(scene);
        LoginStage.show();
        stageNow.close();
    }

    public void closeBtnOnAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}

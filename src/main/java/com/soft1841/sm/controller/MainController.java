package com.soft1841.sm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * 主控制器 按钮切换页面等
 */
public class MainController {
    @FXML
    private Button closeButton;

    public void closeBtnOnAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}

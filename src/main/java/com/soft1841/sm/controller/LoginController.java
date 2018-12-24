package com.soft1841.sm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
}

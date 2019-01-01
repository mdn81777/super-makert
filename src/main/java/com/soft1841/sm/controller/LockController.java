package com.soft1841.sm.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LockController {
    @FXML
    private Button Btn;
    @FXML
    private PasswordField passwordField;

    public void right() {
        String password = passwordField.getText().trim();
        if (password.equals("123")) {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/store_manager.fxml"));
            BorderPane root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (root != null) {
                stage.getIcons().add(new Image("/img/TeamLogo.png"));
                stage.setTitle("盐系后台管理系统");
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/css/style.css");
                stage.setScene(scene);
                stage.show();
                stage.setMaximized(true);
                Stage nowStage = (Stage) Btn.getScene().getWindow();
                nowStage.close();
            }
        }
    }
}
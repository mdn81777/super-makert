package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CashRegister extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/cashregister.fxml"));
        primaryStage.setTitle("盐系FRESHMEN");
        primaryStage.setScene(new Scene(root, 1918, 1000));
        primaryStage.getIcons().add(new Image("/img/TeamLogo.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
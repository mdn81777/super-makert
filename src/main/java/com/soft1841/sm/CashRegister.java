package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;


public class CashRegister extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("收银系统");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/cashregister.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(CashRegister.class.getResource("/css/style.css").toExternalForm());
        primaryStage.setMaximized(true);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
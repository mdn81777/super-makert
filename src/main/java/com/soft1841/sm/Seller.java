package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Seller extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/seller.fxml"));
        primaryStage.setTitle("盐系FRESHMEN");
        primaryStage.setScene(new Scene(root, 1100, 740));
        primaryStage.getIcons().add(new Image("/img/TeamLogo.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
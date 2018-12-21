package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Market extends Application {
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Market.fxml"));
        primaryStage.setTitle("盐系freshman");
        primaryStage.setScene(new Scene(root, 1280, 853));
        primaryStage.getIcons().add(new Image("/img/6.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}





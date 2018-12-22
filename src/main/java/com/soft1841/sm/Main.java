package com.soft1841.sm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        primaryStage.setTitle("盐系FRESHMEN");
        primaryStage.setScene(new Scene(root, 680, 500));
        primaryStage.getIcons().add(new Image("/img/1.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}





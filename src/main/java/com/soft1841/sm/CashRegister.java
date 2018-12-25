package com.soft1841.sm;
/**
 * 收银界面主程序
 * @author 孟妮
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;


public class CashRegister extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("盐系supermarket");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/cashregister.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(LoginApp.class.getResource("/css/style.css").toExternalForm());
        primaryStage.getIcons().add(new Image("/img/TeamLogo.png"));
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
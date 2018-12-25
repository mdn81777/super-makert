package com.soft1841.sm;
/**
 * 前台主程序
 * @author 孟妮
 */

import com.soft1841.sm.LoginApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;


public class FrontDesk extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("盐系supermarket");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/frontdesk.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(LoginApp.class.getResource("/css/style.css").toExternalForm());
        primaryStage.getIcons().add(new Image("/img/TeamLogo.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }}
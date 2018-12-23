package com.soft1841.sm;

import cn.hutool.core.date.DateTime;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Date;

public class LoginApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.setTitle("盐系FRESHMEN");
        primaryStage.setScene(new Scene(root, 680, 500));
        primaryStage.getIcons().add(new Image("/img/TeamLogo.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


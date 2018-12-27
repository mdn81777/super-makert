package com.soft1841.sm.controller;

/**
 * 登陆控制器
 *
 * @author 杨俣韬
 * 2018-12-25
 */

import com.soft1841.sm.service.StaffService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button closeButton;
    @FXML
    private TextField accountField;
    @FXML
    private PasswordField passwordField;

    private StaffService staffService = ServiceFactory.getStaffServiceInstance();


    //退出按钮的功能实现
    public void closeBtnOnAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void loginBtnOnAction() {
        //读取文本框的账号密码
        String accountStr = accountField.getText().trim();
        String password = passwordField.getText().trim();
        //将从输入框读取到的账号转为长整型
        Long account = Long.parseLong(accountStr);
        //获取员工的职位ID
        int typeId = staffService.getType(account);
        System.out.println(typeId);
        //根据typeId决定调用哪个界面
        //定义一个空string用于存放对应职位的fxml


        //登陆判断
        if (staffService.login(account, password)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText("登陆成功!");
            alert.showAndWait();
            String position = new String();
            //职位判断
            if (typeId == 1) {
                //店长
                position = "store_manager.fxml";
            } else if (typeId == 2) {
                //会计
                position = "bookkeeper.fxml";
            } else if (typeId == 3) {
                //收货员
                position = "receipt.fxml";
            } else if (typeId == 4) {
                //收银员
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("提示");
                alert1.setContentText("你是收银员，权限不足!");
                alert1.showAndWait();

            } else if (typeId == 5) {
                //客服
                position = "customer_service.fxml";
            }


            //显示主界面
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/"+position));
            BorderPane root = new BorderPane();
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                System.err.println("IO异常");
            }
            stage.getIcons().add(new Image("/img/TeamLogo.png"));
            stage.setTitle("盐系超市后台系统");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);
            Stage loginStage = (Stage) closeButton.getScene().getWindow();
            loginStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText("账号或密码错误，登录失败!");
            alert.showAndWait();
        }
    }
}



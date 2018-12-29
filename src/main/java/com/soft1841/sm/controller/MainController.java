package com.soft1841.sm.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * 主控制器 按钮切换页面等
 */
public class MainController  implements Initializable {
    @FXML
    private StackPane mainContainer;

    @FXML
    private Button closeButton;

    @FXML
    private Button outLogin;

    public void outLoginBtnOnAction() {
        Stage stageNow = (Stage) outLogin.getScene().getWindow();
        Stage LoginStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        AnchorPane root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LoginStage.getIcons().add(new Image("/img/TeamLogo.png"));
        LoginStage.setTitle("盐系超市后台系统");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        LoginStage.setScene(scene);
        LoginStage.show();
        stageNow.close();

    }

    public void closeBtnOnAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/default.fxml")).load();
            mainContainer.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  public  void  shijian(){
        Stage stage = new Stage();
      WebView brower = new WebView();
      WebEngine webEngine = brower.getEngine();
      webEngine.load("https://time.is/zh/China");
      Scene scene = new Scene(brower);
      stage.setScene(scene);
      stage.setWidth(1000);
      stage.setHeight(599);
      stage.show();

  }
    public  void  tianqi() {
        Stage stage = new Stage();
        WebView brower = new WebView();
        WebEngine webEngine = brower.getEngine();
        webEngine.load("http://tianqi.moji.com/forecast15/china/jiangsu/nanjing");
        Scene scene = new Scene(brower);
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(600);
        stage.show();
    }
    public void listDefault() throws Exception {
        switchView("default.fxml");
    }
    public  void  listStatisticalAnalysis() throws  Exception{
        switchView("statisticalanalysis.fxml");
    }

    public void listProductinformation() throws Exception {
        switchView("goods.fxml");
    }

    public void listProductcategory() throws Exception {
        switchView("type.fxml");
    }


    public void listJobCategories() throws Exception {
        switchView("position.fxml");
    }

    public void listEmployeeInformation() throws Exception {
        switchView("staff.fxml");
    }

    public void listMemberInformation()  throws  Exception{
        switchView("member.fxml");
    }

    public void listSupplierInformation() throws Exception {
        switchView("supplier.fxml");
    }

    public void listSystemInitialization() throws  Exception{
        switchView("systeminitialization.fxml");
    }

    public void listDataBackup() throws  Exception{
        switchView("databackup.fxml");
    }

    public void listThemeSettings()throws Exception {
        switchView("themesettings.fxml");
    }

    public void listPreferential()  throws  Exception{
        switchView("preferential.fxml");
    }

    private void switchView(String fileName) throws Exception {
        //清空原有内容
        mainContainer.getChildren().clear();
        AnchorPane anchorPane = new FXMLLoader(getClass().getResource("/fxml/" + fileName)).load();
        mainContainer.getChildren().add(anchorPane);
    }
}



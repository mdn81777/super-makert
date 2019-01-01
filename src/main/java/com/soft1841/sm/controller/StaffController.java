package com.soft1841.sm.controller;
/**
 * 员工控制器
 *
 * @author 杨俣韬
 * 2018-12-25
 */

import com.soft1841.sm.entity.Staff;
import com.soft1841.sm.service.StaffService;

import com.soft1841.sm.utils.ServiceFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.net.URL;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class StaffController implements Initializable {
    @FXML
    private FlowPane staffPane;
    StaffService staffService = ServiceFactory.getStaffServiceInstance();
    private List<Staff> staffList = new ArrayList<>();

    private static final int MAX_THREADS = 8;
    private final Executor exec = Executors.newFixedThreadPool(MAX_THREADS, runnable -> {
        Thread t = new Thread(runnable);
        t.setDaemon(true);
        return t;
    });

    @FXML
    private TextField findStaff;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        staffList = staffService.getAllStaff();
        showStaff(staffList);
    }

    public void addStaff() {
        Staff staff = new Staff();
        Stage stage = new Stage();
        stage.setTitle("新增员工页面");
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        //
        ImageView imageView  = new ImageView();
        exec.execute(new Runnable() {
            @Override
            public void run() {
                imageView.setImage(new Image(staff.getCover()));
            }
        });
        vBox.setPadding(new Insets(10, 10, 10, 10));
        Label infoLabel = new Label("输入员工信息");
        infoLabel.setPrefHeight(50);
        infoLabel.setPrefWidth(580);
        infoLabel.setAlignment(Pos.CENTER);
        TextField nameField = new TextField();
        nameField.setPromptText("请输入姓名");
        nameField.setFocusTraversable(false);
        TextField coverField = new TextField();
        coverField.setPromptText("请输入头像地址");
        coverField.setFocusTraversable(false);
        TextField employeeIdField = new TextField();
        employeeIdField.setPromptText("请输入员工工号");
        employeeIdField.setFocusTraversable(false);
        PasswordField passwordField1 = new PasswordField();
        passwordField1.setPromptText("请输入密码");
        passwordField1.setFocusTraversable(false);
        PasswordField passwordField2 = new PasswordField();
        passwordField2.setPromptText("请确认密码");
        passwordField2.setFocusTraversable(false);
        String[] positions = {"店长", "会计", "收货员", "收银员", "客服"};
        List<String> list = Arrays.asList(positions);
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll(list);
        ComboBox<String> depComboBox = new ComboBox<>();
        depComboBox.setPromptText("请选择职位");
        depComboBox.setItems(observableList);
        depComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int positionId = 0;
                if (newValue.equals("店长")) positionId = 1;
                else if (newValue.equals("会计")) positionId = 2;
                else if (newValue.equals("收货员")) positionId = 3;
                else if (newValue.equals("收银员")) positionId = 4;
                else if (newValue.equals("客服")) positionId = 5;
                if (positionId == 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("提示");
                    alert.setContentText("请选择职位!");
                    alert.showAndWait();
                } else {
                    staff.setTypeId(positionId);
                }
            }
        });
        TextField addressField = new TextField();
        addressField.setPromptText("请输入员工住址");
        addressField.setFocusTraversable(false);
        //新增按钮
        FlowPane flowPane = new FlowPane();
        Button addBtn = new Button("新增");
        addBtn.setPrefWidth(160);
        flowPane.getChildren().add(addBtn);
        flowPane.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(infoLabel, nameField, coverField, employeeIdField, passwordField1, passwordField2,
                depComboBox, addressField, flowPane);
        Scene scene = new Scene(vBox, 900, 700);
        stage.getIcons().add(new Image("/img/TeamLogo.png"));
        stage.setScene(scene);
        stage.show();
        addBtn.setOnAction(event -> {
            String nameString = nameField.getText().trim();
            String coverString = coverField.getText().trim();
            String addressString = addressField.getText().trim();
            String password = null;
            Long employeeId = Long.parseLong(employeeIdField.getText().trim());
            if (passwordField1.getText().equals(passwordField2.getText())) {
                password = passwordField1.getText().trim();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("提示");
                alert.setContentText("两次密码输入不一致!");
                alert.showAndWait();
            }
            staff.setEmployeeId(employeeId);
            staff.setPassWord(password);
            staff.setAddress(addressString);
            staff.setCover(coverString);
            staff.setName(nameString);
            staffService.addStaff(staff);
            stage.close();
            staffList = staffService.getAllStaff();
            showStaff(staffList);
        });
    }
    public void findStaffOnAction() {
        String keywords = findStaff.getText().trim();
        staffList = staffService.getStaffLike(keywords);
        showStaff(staffList);
    }


    private void showStaff(List<Staff> staffList) {
        ObservableList<Node> observableList = staffPane.getChildren();
        staffPane.getChildren().removeAll(observableList);
        for (Staff staff : staffList) {
            VBox vBox = new VBox();
            vBox.setPrefSize(180, 200);
            vBox.setSpacing(10);
            vBox.getStyleClass().add("box3");
            vBox.setAlignment(Pos.CENTER);
            Image image = new Image(staff.getCover());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(140);
            imageView.setFitHeight(140);
            Circle circle = new Circle();
            circle.setCenterY(70.0);
            circle.setCenterX(70.0);
            circle.setRadius(50.0);
            imageView.setClip(circle);
            Label nameLabel = new Label(staff.getName());
            Label addressLabel = new Label(staff.getAddress());
            Button delBtn = new Button("删除");
            delBtn.getStyleClass().add("warning-theme");
            vBox.getChildren().addAll(imageView, nameLabel, addressLabel, delBtn);
            staffPane.getChildren().add(vBox);
            delBtn.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("确认对话框");
                alert.setContentText("确定要删除吗?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    long employeeId = staff.getEmployeeId();
                    staffService.deleteStaff(employeeId);
                    staffPane.getChildren().remove(vBox);
                }
            });
        }
    }}

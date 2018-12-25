package com.soft1841.sm.controller;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.MemberDAO;
import com.soft1841.sm.entity.Member;
import com.soft1841.sm.dao.MemberDAO;
import com.soft1841.sm.entity.Member;
import com.soft1841.sm.utils.DAOFactory;
import com.soft1841.sm.utils.DAOFactory;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

/**
 * 会员管理
 * @author 李启鹏
 * 2018-12-25
 */
public class MemberController implements Initializable {
    @FXML
    private FlowPane memberPane;
    //读取数据
    private MemberDAO memberDAO = DAOFactory.getMemberDAOInstance();
    //接口回调
    List<Entity> memberList = new ArrayList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            memberList = memberDAO.selectAllMember();
            System.out.println(memberList.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showMembers(memberList);

    }
    //通过循环遍历集合，创建HBox来显示每个会员信息
    private void showMembers(List<Entity>memberList){
        ObservableList<Node>observableList = memberPane.getChildren();
        memberPane.getChildren().removeAll(observableList);
        for (Entity entity :memberList) {
            HBox hBox = new HBox();
            hBox.setPrefSize(320,280);
            hBox.setSpacing(10);
            hBox.setPadding(new Insets(10,10,10,10));
            hBox.getStyleClass().add("box");
            //创建左侧垂直布局
            VBox leftBox = new VBox();
            leftBox.setSpacing(10);
            leftBox.setAlignment(Pos.TOP_CENTER);
      //   ImageView avatarImg = new ImageView(new Image(entity.getStr("")));
        //    avatarImg.setFitWidth(80);
         //   avatarImg.setFitHeight(80);
          //  Circle cricle = new Circle();
          //  cricle.setCenterX(40);
          //  cricle.setCenterY(40);
         //   cricle.setRadius(40);
          //  avatarImg.setClip(cricle);
            //头像加入左边
           // leftBox.getChildren().add(avatarImg);
            Label roleLabel =  new Label(entity.getStr("role"));
            leftBox.getChildren().add(roleLabel);
            //左边加入主布局
            hBox.getChildren().add(leftBox);
            memberPane.getChildren().add(hBox);
            //创建右侧垂直布局
            VBox rightBox = new VBox();
            rightBox.setSpacing(20);
            rightBox.setAlignment(Pos.TOP_LEFT);
            Label idLabel = new Label(entity.getStr("id"));
            Label nameLabel = new Label(entity.getStr("name"));
            Label addressLabel = new Label(entity.getStr("address"));
            Label phoneLabel = new Label(entity.getStr("phone"));
            Label integralLabel = new Label(entity.getStr("integral"));
            Button delBtn = new Button("删除");
            //点击删除按钮做的事件
            delBtn.setOnAction(event -> {
                //弹一个确认对话框
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("确认对话框");
                alert.setContentText("确定要删除这行记录吗？");
                Optional<ButtonType> result =alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    //得到这个人的ID
                    long id = entity.getLong("id");
                    memberDAO.deleteMemberid(id);
                    memberPane.getChildren().remove(hBox);
                }
            });
            delBtn.getStyleClass().addAll("warning-theme","btn-radius-larger");
            rightBox.getChildren().addAll(idLabel,nameLabel,addressLabel,phoneLabel,integralLabel,delBtn);
            hBox.getChildren().add(rightBox);

        }
    }
    //新增会员方法
    public void addMember() throws SQLException{
        Member member = new Member();
        Stage stage = new Stage();
        stage.setTitle("新增会员界面");
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20,10,10,10));
        TextField nameField = new TextField("请输入姓名");
        TextField addressField = new TextField("请输入地址");
        HBox roleBox = new HBox();
        roleBox.setSpacing(20);
        ToggleGroup group = new ToggleGroup();
        RadioButton teacherButton = new RadioButton("教师");
        teacherButton.setToggleGroup(group);
        teacherButton.setSelected(true);
        teacherButton.setUserData("教师");
        RadioButton studentButton = new RadioButton("学生");
        studentButton.setToggleGroup(group);
        studentButton.setUserData("学生");
        roleBox.getChildren().addAll(teacherButton,studentButton);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {


                    @Override
                    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                        System.out.println(group.getSelectedToggle().getUserData().toString());
                        member.setId(group.getSelectedToggle().getUserData().toString());
                    }
                });
                String[] names = {"刘伟","李明","林斌涛","李启鹏","王东东","王刚","王超"};
                List<String> list = Arrays.asList(names);
                ObservableList<String> observableList = FXCollections.observableArrayList();
                observableList.addAll(list);
                ComboBox<String> depComboBox = new ComboBox<>();
                depComboBox.setPromptText("请选择姓名");
                depComboBox.setItems(observableList);
                depComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {


        @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                member.setName(newValue);
            }
        });
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
       // TextField addressField = new TextField("请输入地址");
        TextField phoneField = new TextField("请输入电话");
        Button addBtn = new Button("新增");
        addBtn.getStyleClass().add("blue-theme");
        vBox.getChildren().addAll(nameField,roleBox,depComboBox,addressField,phoneField,addBtn);
        Scene scene = new Scene(vBox,600,300);
        scene.getStylesheets().add("/css/style.css");
        stage.setScene(scene);
        stage.show();
        addBtn.setOnAction(event -> {
            String nameString = nameField.getText().trim();
            String addressString = addressField.getText().trim();
            String phoneString = phoneField.getText().trim();

            member.setName(nameString);
            member.setAddress(addressString);
            member.setPhone(phoneString);

            System.out.println(member.getName() + member.getId() + member.getPhone());
            try{
                memberDAO.insertMember(member);
            }catch (SQLException e){
                e.printStackTrace();
            }
            stage.close();
            try{
                memberList = memberDAO.selectAllMember();
            }catch (SQLException e){
                e.printStackTrace();
            }
            showMembers(memberList);
        });
    }
}

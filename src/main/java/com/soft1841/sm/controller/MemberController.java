package com.soft1841.sm.controller;
import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Member;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.MemberService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ComponentUtil;
import com.soft1841.sm.utils.ServiceFactory;
import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.net.URL;
import java.util.*;
import java.util.List;

/**
 * 会员管理
 * @author 李启鹏
 * 2018-12-25
 */
public class    MemberController implements Initializable {
    @FXML
    private TableView<Member> memberTable;

    private ObservableList<Member> membersData = FXCollections.observableArrayList();

    private MemberService memberService = ServiceFactory.getMemberServiceInstance();

    private List<Member> memberList = null;

    private TableColumn<Member, Member> delCol = new TableColumn<>("操作");




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();

    }

    private void initTable() {
        memberTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        memberList = memberService.getAllMember();
        showMembersData(memberList);
        delCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delCol.setCellFactory(param -> new TableCell<Member, Member>() {          private final Button deleteButton = ComponentUtil.getButton("删除", "warning-theme");

            @Override
            protected void updateItem(Member member, boolean empty) {
                if (member == null) {
                    setGraphic(null);
                    return;
                }

                setGraphic(deleteButton);
                deleteButton.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("确认对话框");
                    alert.setHeaderText("请确认");
                    alert.setContentText("确定要删除这行记录吗？");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        long id = member.getId();
                        membersData.remove(member);
                        memberService.deleteMember(id);
                    }
                });
            }
        });
        memberTable.getColumns().add(delCol);
        memberTable.setRowFactory(tv -> {
            TableRow<Member> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    long id = row.getItem().getId();
                    Member member = memberService .getMember(id);
                    Stage memberInfoStage = new Stage();

                    memberInfoStage.setTitle("会员详情界面");
                    VBox vBox = new VBox();
                    vBox.setSpacing(10);
                    vBox.setAlignment(Pos.CENTER);
                    vBox.setPrefSize(600, 400);
                    vBox.setPadding(new Insets(10, 10, 10, 10));
                    Label nameLabel = new Label("姓名：" + member.getName());
                    nameLabel.getStyleClass().add("btn-basic");
                    Label addressLabel = new Label("地址:" + member.getAddress());
                    Label phoneLabel = new Label("电话:" + member.getPhone());
                    Label integralLabel = new Label("积分：" + member.getIntegral());
                    vBox.getChildren().addAll(nameLabel, addressLabel, phoneLabel, integralLabel);
                    Scene scene = new Scene(vBox, 700, 540);
                    scene.getStylesheets().add("/css/style.css");
                    memberInfoStage.setScene(scene);
                    memberInfoStage.show();
                }
            });
            return row;
        });
    }


    private void showMembersData(List<Member> memberList) {
        membersData.addAll(memberList);
        memberTable.setItems(membersData);
    }


    public void newMemberStage() throws Exception {
        Stage addMemberStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/add_member.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/style.css");
        AddMemberController addMemberController = fxmlLoader.getController();
        addMemberController.setMembersData(membersData);
        addMemberStage.setTitle("新增会员界面");
        addMemberStage.setResizable(false);
        addMemberStage.setScene(scene);
        addMemberStage.show();
    }
}

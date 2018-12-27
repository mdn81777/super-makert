//package com.soft1841.sm.controller;
///**
// * 新增会员服务类
// * @author 李启鹏
// * 2018-12-26
// */
//
//import com.soft1841.sm.entity.Member;
//import com.soft1841.sm.entity.Type;
//import com.soft1841.sm.service.MemberService;
//import com.soft1841.sm.service.TypeService;
//import com.soft1841.sm.utils.ServiceFactory;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//import java.net.URL;
//import java.util.List;
//import java.util.ResourceBundle;
//
//public  class AddMemberController implements Initializable {
//    private ObservableList<Member> membersData = FXCollections.observableArrayList();
//
//    public ObservableList<Member> getMembersData() {
//        return membersData;
//    }
//    public void setMembersData(ObservableList<Member> membersData) {
//        this.membersData = membersData;
//    }
//    @FXML
//    private ComboBox<Type> memberType;
//    @FXML
//    private TextField memberId, memberName, memberAddress, memberPhone, memberIntegral;
//
//    private ObservableList<Type> typeData = FXCollections.observableArrayList();
//
//    private TypeService typeService = ServiceFactory.getTypeServiceInstance();
//    private MemberService memberService = ServiceFactory.getMemberServiceInstance();
//    private List<Type> entityList = null;
//
//    private Long typeId;
//
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        entityList = TypeService.getAllTypes();
//        for (Type entity : entityList) {
//            typeData.add(entity);
//        }
//        memberType.setItems(typeData);
//        memberType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
//            typeId = newValue.getId();
//        });
//    }
//
//    public void addMember() throws Exception {
//
//        String name = memberName.getText();
//        String address = memberAddress.getText();
//        String phone = memberPhone.getText();
//        String integral = memberIntegral.getText();
//
//
//        Member member = new Member();
//        member.setTypeId(typeId);
//        member.setName(name);
//        member.setAddress(String.valueOf(Double.parseDouble(address)));
//        member.setPhone(phone);
//        member.setIntegral(Integer.parseInt(integral));
//        long id = memberService.addMember(member);
//        member.setId(id);
//        this.getMembersData().add(member);
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("提示信息");
//        alert.setHeaderText("新增会员成功！");
//        alert.showAndWait();
//        Stage stage = (Stage) memberName.getScene().getWindow();
//        stage.close();
//    }
//}
//
//
//

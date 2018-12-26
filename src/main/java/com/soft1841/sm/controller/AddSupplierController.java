//package com.soft1841.sm.controller;
//
//import cn.hutool.db.Entity;
//
//import com.soft1841.sm.dao.SupplierDAO;
//import com.soft1841.sm.dao.TypeDAO;
//import com.soft1841.sm.entity.Goods;
//import com.soft1841.sm.entity.Supplier;
//import com.soft1841.sm.entity.Type;
//import com.soft1841.sm.utils.DAOFactory;
//import com.sun.org.glassfish.gmbal.Description;
//import com.sun.xml.internal.bind.v2.model.core.ID;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.ResourceBundle;
//
//public class AddSupplierController implements Initializable {
//    private ObservableList<Supplier> suppliersData = FXCollections.observableArrayList();
//
//    public ObservableList<Supplier> getSupplierData(){return suppliersData;}
//
//    public void setSuppliersData(ObservableList<Supplier> suppliersData){this.suppliersData = suppliersData;}
//
//    @FXML
//    private ComboBox<Type> supplierType;
//    @FXML
//    private TextField supplierName,supplierAddress,supplierPhone,supplierLinkMen;
//    @FXML
//    private TextArea supplierDescription;
//
//    private ObservableList<Type> typeData = FXCollections.observableArrayList();
//
//    private SupplierDAO supplierDAO = DAOFactory.getSupplierDAOInstance();
//
//    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();
//
//    private List<Type> entityList = null;
//
//    private Long typeId;
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            entityList = typeDAO.selectAllTypes();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        for (Entity entity : entityList) {
//            Type type = new Type();
//            type.setId(entity.getLong("id"));
//            type.setTypeName(entity.getStr("type_name"));
//            typeData.add(type);
//        }
//        supplierType.setItems(typeData);
//        supplierType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
//            typeId = newValue.getId();
//        });
//    }
//    public void addsupplier() throws Exception{
//        String name = supplierName.getText();
//        String address = supplierAddress.getText();
//        String phone = supplierPhone.getText();
//        String linkmen = supplierLinkMen.getText();
//        System.out.println(stock);
//        Supplier supplier=new Supplier();
//        supplier.setId(id);
//        supplier.setSupplierAddress(address);
//        supplier.setSupplierPhone(phone);
//        supplier.setLinkman(linkmen);
//        supplier.setStock();
//        supplier.setDescription(description);
//        long id = supplierDAO.insertSupplier(supplier);
//        supplier.setId(id);
//        this.getSupplierData().add(supplier);
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("提示信息");
//        alert.setHeaderText("新增供应商成功！");
//        alert.showAndWait();
//        Stage stage = (Stage) supplierName.getScene().getWindow();
//        stage.close();
//    }
//}
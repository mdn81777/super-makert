package com.soft1841.sm.controller;
/**
 * 新增供应商服务类
 *
 * @author 林斌涛
 */


import com.soft1841.sm.entity.Supplier;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.SupplierService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddSupplierController implements Initializable {
    private ObservableList<Supplier> suppliersData = FXCollections.observableArrayList();

    public ObservableList<Supplier> getSupplierData() {
        return suppliersData;
    }

    public void setSuppliersData(ObservableList<Supplier> suppliersData) {
        this.suppliersData = suppliersData;
    }

    @FXML
    private TextField supplierName, supplierAddress, supplierPhone, linkMen;

    private SupplierService supplierService = ServiceFactory.getSupplierServiceInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addSupplier(){
        String name = supplierName.getText();
        String address = supplierAddress.getText();
        String phone = supplierPhone.getText();
        String linkmen = linkMen.getText();
        Supplier supplier = new Supplier();
        supplier.setSupplierName(name);
        supplier.setSupplierAddress(address);
        supplier.setSupplierPhone(phone);
        supplier.setLinkman(linkmen);
        long id = supplierService.addSuppler(supplier);
        supplier.setId(id);
        this.getSupplierData().add(supplier);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示信息");
        alert.setHeaderText("新增供应商成功！");
        alert.showAndWait();
        Stage stage = (Stage) supplierName.getScene().getWindow();
        stage.close();
    }
}
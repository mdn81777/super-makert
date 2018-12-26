package com.soft1841.sm.controller;
/**
 * 新增供应商服务类
 *
 * @author 林斌涛
 */


import com.soft1841.sm.dao.SupplierDAO;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Supplier;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.SupplierService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.DAOFactory;
import com.soft1841.sm.utils.ServiceFactory;
import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.activation.MimeTypeParameterList;
import javax.swing.text.html.Option;
import java.net.URL;
import java.sql.SQLException;
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
    private ComboBox<Type> supplierType;
    @FXML
    private TextField supplierName, supplierAddress, supplierPhone, supplierLinkMen;
    @FXML
    private TextArea supplierDescription;

    private ObservableList<Type> typeData = FXCollections.observableArrayList();
    private TypeService typeService = ServiceFactory.getTypeServiceInstance();

    private SupplierService supplierService = ServiceFactory.getSupplierServiceInstance();
    private List<Type> typeList = null;

    private Long typeId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeList = typeService.getAllTypes();
        typeData.addAll(typeList);
        supplierType.setItems(suppliersData);
        supplierType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            typeId = newValue.getId();
        });
    }

    public void addsupplier() throws Exception {
        String name = supplierName.getText();
        String address = supplierAddress.getText();
        String phone = supplierPhone.getText();
        String linkmen = supplierLinkMen.getText();
        Supplier supplier = new Supplier();
        supplier.setId(typeId);
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
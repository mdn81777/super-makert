package com.soft1841.sm.entity;


import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 * 供应商实体类
 * @author 孟妮
 */
public class Supplier {
    public final SimpleLongProperty id = new SimpleLongProperty();
    public final SimpleStringProperty supplierName = new SimpleStringProperty("");
    public final SimpleStringProperty supplierAddress = new SimpleStringProperty("");
    public final SimpleStringProperty supplierPhone = new SimpleStringProperty("");
    public final SimpleStringProperty linkman = new SimpleStringProperty("");


    public Supplier() {
    }

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getSupplierName() {
        return supplierName.get();
    }

    public SimpleStringProperty supplierNameProperty() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName.set(supplierName);
    }

    public String getSupplierAddress() {
        return supplierAddress.get();
    }

    public SimpleStringProperty supplierAddressProperty() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress.set(supplierAddress);
    }

    public String getSupplierPhone() {
        return supplierPhone.get();
    }

    public SimpleStringProperty supplierPhoneProperty() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone.set(supplierPhone);
    }

    public String getLinkman() {
        return linkman.get();
    }

    public SimpleStringProperty linkmanProperty() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman.set(linkman);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", supplierName=" + supplierName +
                ", supplierAddress=" + supplierAddress +
                ", supplierPhone=" + supplierPhone +
                ", linkman=" + linkman +
                '}';
    }
}


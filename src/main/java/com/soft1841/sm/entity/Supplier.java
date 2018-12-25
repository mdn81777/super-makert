package com.soft1841.sm.entity;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

/**
 * 供应商实体类
 * @author 孟妮
 */
public class Supplier{
    private  Long id;
    private  String supplierName;
    private  String supplierAddress;
    private  String supplierPhone;
    private  String linkman;

    public Supplier(Long id, String supplierName, String supplierAddress, String supplierPhone, String linkman) {
        this.id = id;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierPhone = supplierPhone;
        this.linkman = linkman;
    }

    public Supplier() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", supplierName='" + supplierName + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", supplierPhone='" + supplierPhone + '\'' +
                ", linkman='" + linkman + '\'' +
                '}';
    }
}





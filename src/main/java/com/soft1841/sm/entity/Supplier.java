package com.soft1841.sm.entity;

/**
 * 供应商实体类
 */
public class Supplier{
    private Long id;
    private  String suppliername;
    private  String supplieraddress;
    private  String supplierphone;
    private  String linkman;

    public Supplier() {
        this.id = id;
        this.suppliername = suppliername;
        this.supplieraddress = supplieraddress;
        this.supplierphone = supplierphone;
        this.linkman = linkman;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getSupplieraddress() {
        return supplieraddress;
    }

    public void setSupplieraddress(String supplieraddress) {
        this.supplieraddress = supplieraddress;
    }

    public String getSupplierphone() {
        return supplierphone;
    }

    public void setSupplierphone(String supplierphone) {
        this.supplierphone = supplierphone;
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
                ", suppliername='" + suppliername + '\'' +
                ", supplieraddress='" + supplieraddress + '\'' +
                ", supplierphone='" + supplierphone + '\'' +
                ", linkman='" + linkman + '\'' +
                '}';
    }
}





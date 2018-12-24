package com.soft1841.sm.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;


public class Staff {
    private Integer id;
    private Long typeId;
    private Long employeeId;
    private String passWord;
    private String name;
    private String cover;
    private String address;

    public Staff(Integer id, Long typeId, Long employeeId, String passWord, String name, String cover, String address) {
        this.id = id;
        this.typeId = typeId;
        this.employeeId = employeeId;
        this.passWord = passWord;
        this.name = name;
        this.cover = cover;
        this.address = address;
    }

    public Staff() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", employeeId=" + employeeId +
                ", passWord='" + passWord + '\'' +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

package com.soft1841.sm.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;


public class Staff {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleLongProperty typeId = new SimpleLongProperty();
    private final SimpleLongProperty employeeId = new SimpleLongProperty();
    private final SimpleStringProperty passWord = new SimpleStringProperty();
    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleStringProperty cover = new SimpleStringProperty("");
    private final SimpleStringProperty address = new SimpleStringProperty("");

    public Staff(Long typeId,Long employeeId,String password,String name,String cover,String address) {
        setTypeId(typeId);
        setEmployeeId(employeeId);
        setPassWord(password);
        setName(name);
        setCover(cover);
        setAddress(address);
    }

    public Staff() {
    }


    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public long getTypeId() {
        return typeId.get();
    }

    public SimpleLongProperty typeIdProperty() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId.set(typeId);
    }

    public long getEmployeeId() {
        return employeeId.get();
    }

    public SimpleLongProperty employeeIdProperty() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId.set(employeeId);
    }

    public String getPassWord() {
        return passWord.get();
    }

    public SimpleStringProperty passWordProperty() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord.set(passWord);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCover() {
        return cover.get();
    }

    public SimpleStringProperty coverProperty() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover.set(cover);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", employeeId=" + employeeId +
                ", passWord=" + passWord +
                ", name=" + name +
                ", cover=" + cover +
                ", address=" + address +
                '}';
    }
}

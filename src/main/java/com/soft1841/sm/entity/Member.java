package com.soft1841.sm.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Member {
    private final SimpleLongProperty id = new SimpleLongProperty();
    private final SimpleStringProperty memberId = new SimpleStringProperty();
    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleStringProperty address = new SimpleStringProperty("");
    private final SimpleStringProperty phone = new SimpleStringProperty("");
    private final SimpleIntegerProperty integral = new SimpleIntegerProperty();

    public Member(String memberId,String name,String address,String phone,Integer integer) {
        setMemberId(memberId);
        setName(name);
        setAddress(address);
        setPhone(phone);
        setIntegral(integer);
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

    public String getMemberId() {
        return memberId.get();
    }

    public SimpleStringProperty memberIdProperty() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId.set(memberId);
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

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public int getIntegral() {
        return integral.get();
    }

    public SimpleIntegerProperty integralProperty() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral.set(integral);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", name=" + name +
                ", address=" + address +
                ", phone=" + phone +
                ", integral=" + integral +
                '}';
    }
}

package com.soft1841.sm.entity;

import cn.hutool.db.ds.simple.SimpleDataSource;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;

import java.util.Date;

public class Receipt {
    private final SimpleLongProperty id = new SimpleLongProperty();
    private final SimpleLongProperty employeeId = new SimpleLongProperty();
    private final SimpleLongProperty memberId = new SimpleLongProperty();
    private Date time;
    private final SimpleDoubleProperty total = new SimpleDoubleProperty();

    public Receipt() {
    }

    public Receipt(Long employeeId, Long memberId, Date time, Double total) {
        setEmployeeId(employeeId);
        setMemberId(memberId);
        setTime(time);
        setTotal(total);
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

    public long getEmployeeId() {
        return employeeId.get();
    }

    public SimpleLongProperty employeeIdProperty() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId.set(employeeId);
    }


    public SimpleLongProperty mumberIdProperty() {
        return memberId;
    }

    public long getMemberId() {
        return memberId.get();
    }

    public SimpleLongProperty memberIdProperty() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId.set(memberId);
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }

    public void setTotal(double total) {
        this.total.set(total);
    }
}

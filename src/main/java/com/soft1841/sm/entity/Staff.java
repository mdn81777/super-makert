package com.soft1841.sm.entity;


public class Staff {
    private Integer id;
    private Integer typeId;
    private Long employeeId;
    private String passWord;
    private String name;
    private String cover;
    private String address;

    public Staff(Integer id, Integer typeId, Long employeeId, String passWord, String name, String cover, String address) {
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
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
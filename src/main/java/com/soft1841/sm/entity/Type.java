package com.soft1841.sm.entity;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * 实体类
 */
public class Type {
    //以JavaFx属性绑定的形式，定义和数据表字段id和type_name对应的属性，注意命名规范
    private final SimpleLongProperty id = new SimpleLongProperty();
    private final SimpleStringProperty typename = new SimpleStringProperty("");
    private final SimpleStringProperty typecover = new SimpleStringProperty("");
    public  Type(long id , String typeNmae,String typecover) {
        setId(id);
        setTypename(typeNmae);
        setTypecover(typecover);
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

    public String getTypename() {
        return typename.get();
    }

    public SimpleStringProperty typenameProperty() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename.set(typename);
    }

    public String getTypecover() {
        return typecover.get();
    }

    public SimpleStringProperty typecoverProperty() {
        return typecover;
    }

    public void setTypecover(String typecover) {
        this.typecover.set(typecover);
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", typename=" + typename +
                ", typecover=" + typecover +
                '}';
    }
}

package com.soft1841.sm.entity;
/**
 * 类别实体类
 * @author 孟妮
 */

import cn.hutool.db.Entity;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;


public class Type extends Entity {
    //以JavaFx属性绑定的形式，定义和数据表字段id和type_name,type_cover对应的属性，注意命名规范
    private final SimpleLongProperty id = new SimpleLongProperty();
    private final SimpleStringProperty typeName = new SimpleStringProperty("");
    private final SimpleStringProperty typeCover = new SimpleStringProperty("");

    public Type() {
    }
    public Type(long id, String typeName) {
        setId(id);
        setTypeName(typeName);

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

    public String getTypeName() {
        return typeName.get();
    }

    public SimpleStringProperty typeNameProperty() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName.set(typeName);
    }

    public String getTypeCover() {
        return typeCover.get();
    }

    public SimpleStringProperty typeCoverProperty() {
        return typeCover;
    }

    public void setTypeCover(String typeCover) {
        this.typeCover.set(String.valueOf(typeCover));
    }

    @Override
    public String toString() {
        return typeName.get();
    }
}

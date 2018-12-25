package com.soft1841.sm.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Position {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty position = new SimpleStringProperty("");

    public Position() {
    }

    public Position(String position) {
        setPosition(position);
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

    public String getPosition() {
        return position.get();
    }

    public SimpleStringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", PositionController=" + position +
                '}';
    }
}

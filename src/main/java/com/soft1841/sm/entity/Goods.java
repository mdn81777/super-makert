package com.soft1841.sm.entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class Goods {
    private final SimpleLongProperty id = new SimpleLongProperty();
    private final SimpleLongProperty typeId = new SimpleLongProperty();
    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleDoubleProperty price = new SimpleDoubleProperty();
    private final SimpleStringProperty cover = new SimpleStringProperty("");
    private final SimpleStringProperty description = new SimpleStringProperty("");
    private final SimpleLongProperty barcode = new SimpleLongProperty();
    private final SimpleIntegerProperty stock = new SimpleIntegerProperty();

    public Goods() {
    }

    public Goods(Long typeId, String name, Double price, String cover, String description, Long barcode, Integer stock) {
        setTypeId(typeId);
        setName(name);
        setPrice(price);
        setCover(cover);
        setDescription(description);
        setBarcode(barcode);
        setStock(stock);
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

    public long getTypeId() {
        return typeId.get();
    }

    public SimpleLongProperty typeIdProperty() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId.set(typeId);
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

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
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

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public long getBarcode() {
        return barcode.get();
    }

    public SimpleLongProperty barcodeProperty() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode.set(barcode);
    }

    public int getStock() {
        return stock.get();
    }

    public SimpleIntegerProperty stockProperty() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", name=" + name +
                ", price=" + price +
                ", cover=" + cover +
                ", description=" + description +
                ", barcode=" + barcode +
                ", stock=" + stock +
                '}';
    }


}

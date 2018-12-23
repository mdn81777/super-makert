package com.soft1841.sm.entity;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;

public class Detail {
    private final SimpleLongProperty id = new SimpleLongProperty();
    private final SimpleLongProperty receiptId= new SimpleLongProperty();
    private final SimpleLongProperty barcode = new SimpleLongProperty();
    private final SimpleDoubleProperty amount = new SimpleDoubleProperty();

    public Detail(Long receiptId,Long barcode,Double amount) {
        setReceiptId(receiptId);
        setBarcode(barcode);
        setAmount(amount);
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

    public long getReceiptId() {
        return receiptId.get();
    }

    public SimpleLongProperty receiptIdProperty() {
        return receiptId;
    }

    public void setReceiptId(long receiptId) {
        this.receiptId.set(receiptId);
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

    public double getAmount() {
        return amount.get();
    }

    public SimpleDoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", receiptId=" + receiptId +
                ", barcode=" + barcode +
                ", amount=" + amount +
                '}';
    }
}

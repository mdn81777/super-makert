package com.soft1841.sm.entity;

public class Detail {
    private Long id;
    private Long receiptId;
    private Long barcode;
    private Double amount;

    public Detail(Long receiptId, Long barcode, Double amount) {
        this.receiptId = receiptId;
        this.barcode = barcode;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

package com.stackextend.generatepdfdocument.model;

public class OrderEntryModel {

    private String productName;
    private Integer quantity;
    private Double price;

    public OrderEntryModel(String productName, Integer quantity, Double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double getPriceTotal() {
        return quantity * price;
    }
}

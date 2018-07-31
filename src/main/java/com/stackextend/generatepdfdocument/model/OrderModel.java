package com.stackextend.generatepdfdocument.model;

import java.util.List;

public class OrderModel {

    private String code;
    private AddressModel address;
    private List<OrderEntryModel> entries;

    public OrderModel(String code, AddressModel address, List<OrderEntryModel> entries) {
        this.code = code;
        this.address = address;
        this.entries = entries;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getTotalPrice() {
        return getEntries().stream().mapToDouble(entry -> entry.getPrice()).sum();
    }

    public Integer getTotalQuantity() {
        return getEntries().stream().mapToInt(entry -> entry.getQuantity()).sum();
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public List<OrderEntryModel> getEntries() {
        return entries;
    }

    public void setEntries(List<OrderEntryModel> entries) {
        this.entries = entries;
    }
}

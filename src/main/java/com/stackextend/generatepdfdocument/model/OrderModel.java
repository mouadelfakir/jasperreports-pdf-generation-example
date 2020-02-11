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

    public Double getTotalPrice() {
        return getEntries().stream().mapToDouble(OrderEntryModel::getPriceTotal).sum();
    }

    public Integer getTotalQuantity() {
        return getEntries().stream().mapToInt(OrderEntryModel::getQuantity).sum();
    }

    public AddressModel getAddress() {
        return address;
    }

    public List<OrderEntryModel> getEntries() {
        return entries;
    }
}

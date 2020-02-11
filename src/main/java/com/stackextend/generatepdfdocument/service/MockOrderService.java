package com.stackextend.generatepdfdocument.service;

import com.stackextend.generatepdfdocument.model.AddressModel;
import com.stackextend.generatepdfdocument.model.OrderEntryModel;
import com.stackextend.generatepdfdocument.model.OrderModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockOrderService {

    public OrderModel getOrderByCode(final String code) {

        return order(code);

    }

    private OrderModel order(String code) {
        return new OrderModel(code, address(), entries());
    }

    private AddressModel address() {
        return new AddressModel("Mouad",
                "EL Fakir",
                "Gabriel Peri",
                "75000",
                "Paris",
                "France");
    }

    private List<OrderEntryModel> entries() {
        return new ArrayList<OrderEntryModel>() {
            {
                add(new OrderEntryModel("Apple IPhone X", 1, 500d));
                add(new OrderEntryModel("Samsung Galaxy s8", 2, 400d));
            }
        };
    }
}

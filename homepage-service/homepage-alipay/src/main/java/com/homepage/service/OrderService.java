package com.homepage.service;

import com.homepage.entity.Order;

public interface OrderService {
    void saveOrder(Order order);

    void updateOrderStatus(String orderId, String alpayFlowNum, String paidAmount);

    Order getOrderById(String orderId);
}

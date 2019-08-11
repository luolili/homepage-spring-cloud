package com.homepage.service.impl;

import com.homepage.entity.Flow;
import com.homepage.entity.Order;
import com.homepage.repo.FlowRepo;
import com.homepage.repo.OrderRepo;
import com.homepage.service.OrderService;
import com.homepage.util.OrderStatusEnum;
import com.sid.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private FlowRepo flowRepo;

    private Sid sid = new Sid();

    @Override
    public void saveOrder(Order order) {
        orderRepo.save(order);
    }

    @Override
    public void updateOrderStatus(String orderId, String alpayFlowNum, String paidAmount) {
        Order order = getOrderById(orderId);
        if (order.getOrderStatus().equals(OrderStatusEnum.WAIT_PAY.key)) {
            order = new Order();
            order.setId(orderId);
            order.setOrderStatus(OrderStatusEnum.PAID.key);
            order.setPaidTime(new Date());
            order.setPaidAmount(paidAmount);
            orderRepo.save(order);
            order = getOrderById(orderId);

            String flowId = sid.nextShort();

            Flow flow = new Flow();
            flow.setId(flowId);
            flow.setFlowNum(alpayFlowNum);
            flow.setBuyCounts(order.getBuyCounts());
            flow.setCreateTime(new Date());
            flow.setOrderNum(orderId);
            flow.setPaidAmount(paidAmount);
            flow.setPaidMethod(1);
            flow.setProductId(order.getProductId());
            flowRepo.save(flow);


        }


    }

    @Override
    public Order getOrderById(String orderId) {
        return orderRepo.getOne(orderId);
    }
}

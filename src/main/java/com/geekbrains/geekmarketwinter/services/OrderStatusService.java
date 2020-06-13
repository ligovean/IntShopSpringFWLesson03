package com.geekbrains.geekmarketwinter.services;

import com.geekbrains.geekmarketwinter.entites.OrderStatus;
import com.geekbrains.geekmarketwinter.repositories.OrderStatusRepositorySqlO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusService {

    private OrderStatusRepositorySqlO2 orderStatusRepositorySqlO2;

    @Autowired
    public void setOrderStatusRepositorySqlO2(OrderStatusRepositorySqlO2 orderStatusRepositorySqlO2) {
        this.orderStatusRepositorySqlO2 = orderStatusRepositorySqlO2;
    }


    public OrderStatus getStatusById(long id) {
        return orderStatusRepositorySqlO2.findById(id).orElse(null);
    }
}

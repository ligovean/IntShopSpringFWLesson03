package com.geekbrains.geekmarketwinter.repositories;

import com.geekbrains.geekmarketwinter.entites.OrderStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface OrderStatusRepositorySqlO2 {
    Optional<OrderStatus> findById(long id);
}

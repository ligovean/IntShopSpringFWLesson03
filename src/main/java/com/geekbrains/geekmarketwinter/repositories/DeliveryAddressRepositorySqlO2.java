package com.geekbrains.geekmarketwinter.repositories;

import com.geekbrains.geekmarketwinter.entites.DeliveryAddress;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeliveryAddressRepositorySqlO2 {
    List<DeliveryAddress> findAllByUserId(Long userId);
}

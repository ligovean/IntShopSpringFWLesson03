package com.geekbrains.geekmarketwinter.services;

import com.geekbrains.geekmarketwinter.entites.DeliveryAddress;

import com.geekbrains.geekmarketwinter.repositories.DeliveryAddressRepositorySqlO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressService {
    private DeliveryAddressRepositorySqlO2 deliveryAddressRepositorySqlO2;
    private UserService userService;

    @Autowired
    public void setDeliveryAddressRepositorySqlO2(DeliveryAddressRepositorySqlO2 deliveryAddressRepositorySqlO2) {
        this.deliveryAddressRepositorySqlO2 = deliveryAddressRepositorySqlO2;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<DeliveryAddress> getUserAddresses(Long userId) {
        List<DeliveryAddress> deliveryAddressList = deliveryAddressRepositorySqlO2.findAllByUserId(userId);
        for (DeliveryAddress da:deliveryAddressList) {
            da.setUser(userService.findByUserId(userId));
        }

        return deliveryAddressList;
    }
    
}

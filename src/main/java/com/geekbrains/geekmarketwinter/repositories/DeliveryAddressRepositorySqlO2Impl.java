package com.geekbrains.geekmarketwinter.repositories;

import com.geekbrains.geekmarketwinter.entites.DeliveryAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeliveryAddressRepositorySqlO2Impl implements DeliveryAddressRepositorySqlO2 {
    private final Sql2o sql2o;

    public DeliveryAddressRepositorySqlO2Impl(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    private static final String SELECT_DEL_ADDR_QUERY = "select id,user_id,address from delivery_addresses where user_id = :id;";

    @Override
    public List<DeliveryAddress> findAllByUserId(Long userId) {

        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_DEL_ADDR_QUERY, false)
                    .addParameter("id", userId)
                    .setColumnMappings(DeliveryAddress.COLUMN_MAPPINGS)
                    .executeAndFetch(DeliveryAddress.class)
                    .stream()
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }
}

package com.geekbrains.geekmarketwinter.repositories;

import com.geekbrains.geekmarketwinter.entites.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Optional;

@Component
public class OrderStatusRepositorySqlO2Impl implements OrderStatusRepositorySqlO2 {
    private final Sql2o sql2o;

        public OrderStatusRepositorySqlO2Impl(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    private static final String SELECT_STATUS_QUERY = "select id, title from orders_statuses where id = :id;";

    @Override
    public Optional<OrderStatus> findById(long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_STATUS_QUERY, false)
                    .addParameter("id", id)
                    .setColumnMappings(OrderStatus.COLUMN_MAPPINGS)
                    .executeAndFetch(OrderStatus.class)
                    .stream().findFirst();
        }
    }
}

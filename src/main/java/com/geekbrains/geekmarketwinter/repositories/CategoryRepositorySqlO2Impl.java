package com.geekbrains.geekmarketwinter.repositories;

import com.geekbrains.geekmarketwinter.entites.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryRepositorySqlO2Impl implements CategoryRepositorySqlO2 {
    private final Sql2o sql2o;

    public CategoryRepositorySqlO2Impl(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    private static final String SELECT_CATEGORY_QUERY = "select id, title, description from categories;";

    @Override
    public List<Category> findAll() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_CATEGORY_QUERY, false)
                    .setColumnMappings(Category.COLUMN_MAPPINGS)
                    .executeAndFetch(Category.class)
                    .stream()
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }
}

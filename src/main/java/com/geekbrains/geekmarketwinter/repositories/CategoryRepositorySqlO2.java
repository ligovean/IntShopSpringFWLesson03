package com.geekbrains.geekmarketwinter.repositories;

import com.geekbrains.geekmarketwinter.entites.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryRepositorySqlO2 {
    List<Category> findAll();
}

package com.geekbrains.geekmarketwinter.services;

import com.geekbrains.geekmarketwinter.entites.Category;
import com.geekbrains.geekmarketwinter.repositories.CategoryRepositorySqlO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepositorySqlO2 categoryRepositorySqlO2;

    @Autowired
    public void setCategoryRepositorySqlO2(CategoryRepositorySqlO2 categoryRepositorySqlO2) {
        this.categoryRepositorySqlO2 = categoryRepositorySqlO2;
    }

    public List<Category> getAllCategories() {
        return (List<Category>)categoryRepositorySqlO2.findAll();
    }
}

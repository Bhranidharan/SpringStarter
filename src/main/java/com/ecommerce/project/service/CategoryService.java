package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> categories();
    void addCategory(Category category);
    String deleteCategory(Long categoryId);
    Category updateCategory(Category category, Long categoryId);
}

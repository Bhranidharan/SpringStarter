package com.ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CategoryId;
    private String CategoryName;

    public Category(Long categoryId, String categoryName) {
        CategoryId = categoryId;
        CategoryName = categoryName;
    }

    public Category(){}

    public Long getCategoryId() {
        return CategoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}

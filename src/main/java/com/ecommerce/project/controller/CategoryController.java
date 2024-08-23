package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> allCategoryService = categoryService.categories();
        return new ResponseEntity<>(allCategoryService, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<String> addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return new ResponseEntity<>("category add successfully", HttpStatus.CREATED);
    }

    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable long categoryId) {
        try {
            Category s = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Category with id: "+s.getCategoryId() +" Updated: "+ s.getCategoryName(), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<String>(e.getReason(), e.getStatusCode());
        }
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable long categoryId) {
        try {
            String s = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(s, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<String>(e.getReason(), e.getStatusCode());
        }
    }
}

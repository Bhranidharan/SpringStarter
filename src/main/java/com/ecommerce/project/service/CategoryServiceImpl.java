package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

  //  private List<Category> categories = new ArrayList<>();
    @Autowired
    private CategoryRepository categoryRepository;
    private long catId = 1L;
    @Override
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        category.setCategoryId(catId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        List<Category> categories = categoryRepository.findAll();
        Category category = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not Found"));

            categoryRepository.delete(category);
            return "Category "+categoryId+" "+category.getCategoryName()+" deleted successfully";

    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        List<Category> categories = categoryRepository.findAll();
        Category getCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not Found"));

        getCategory.setCategoryName(category.getCategoryName());
        categoryRepository.save(getCategory);

        return getCategory;

    }
}

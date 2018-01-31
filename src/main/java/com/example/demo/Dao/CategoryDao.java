package com.example.demo.Dao;

import com.example.demo.entities.Category;
import com.example.demo.entities.Category;

import java.util.List;

/**
 * Created by ahmed on 1/31/2018.
 */
public interface CategoryDao {
    public Category saveCategory(Category category);

    public Category updateCategory(int id, Category category);

    public int deleteCategoryById(int id);

    public Category getCategoryById(int id);
    public List<Category> getAll();
}

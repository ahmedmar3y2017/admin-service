package com.example.demo.ServiceImpl;

import com.example.demo.DaoImpl.CategoryDaoImpl;
import com.example.demo.Service.CategoryService;
import com.example.demo.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ahmed on 1/31/2018.
 */

@Service

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDaoImpl category1;

    @Override
    public Category saveCategory(Category category) {
        return category1.saveCategory(category);
    }

    @CachePut(value = "categoryCache", key = "#id")
    @Override
    public Category updateCategory(int id, Category category) {
        return category1.updateCategory(id, category);
    }

    @CacheEvict(value = "categoryCache", key = "#id")
    @Override
    public int deleteCategoryById(int id) {
        return category1.deleteCategoryById(id);
    }


    @Cacheable(value = "categoryCache", key = "#id", unless = "#result==null")
    @Override
    public Category getCategoryById(int id) {
        return category1.getCategoryById(id);
    }

    @Cacheable(value = "categoryCache", unless = "#result==null")
    @Override
    public List<Category> getAll() {
        return category1.getAll();
    }
}

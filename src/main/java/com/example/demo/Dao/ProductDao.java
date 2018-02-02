package com.example.demo.Dao;


import com.example.demo.entities.Product;

import java.util.List;

/**
 * Created by ahmed on 1/31/2018.
 */
public interface ProductDao {
    public Product saveProduct(Product product);

    public Product updateProduct(int id, Product product);

    public int deleteProductById(int id);

    public Product getProductById(int id);

    public List<Product> getAll();

}

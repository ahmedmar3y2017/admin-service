package com.example.demo.Service;

import com.example.demo.entities.Product;

/**
 * Created by ahmed on 1/31/2018.
 */
public interface ProductService {
    public Product saveProduct(Product product);

    public Product updateProduct(int id, Product product);

    public int deleteProductById(int id);

    public Product getProductById(int id);
}

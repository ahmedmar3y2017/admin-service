package com.example.demo.Service;

import com.example.demo.entities.Product;

import java.util.List;

/**
 * Created by ahmed on 1/31/2018.
 */
public interface ProductService {
    public Product saveProduct(Product product);

    public Product updateProduct(Product product);

    public int deleteProductById(int id);

    public Product getProductById(int id);

    public List<Product> getAll();

    public int deleteProductByBusinessId(int businessid);

    public int deleteProductByCategoryId(int categoryid);

    public int deleteProductByBrandId(int brandid);

    int deleteProductByAvailable(int id);
}

package com.example.demo.ServiceImpl;

import com.example.demo.DaoImpl.ProductDaoImpl;
import com.example.demo.Service.ProductService;
import com.example.demo.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ahmed on 1/31/2018.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDaoImpl productDao;
    @Override
    public Product saveProduct(Product product) {
        return productDao.saveProduct(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return productDao.updateProduct(id , product);
    }

    @Override
    public int deleteProductById(int id) {
        return productDao.deleteProductById(id);
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }
}

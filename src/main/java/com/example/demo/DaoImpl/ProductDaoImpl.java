package com.example.demo.DaoImpl;

import com.example.demo.Dao.ProductDao;
import com.example.demo.entities.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ahmed on 1/31/2018.
 */
@Transactional
@Component
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return null;
    }

    @Override
    public int deleteProductById(int id) {
        return 0;
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }
}

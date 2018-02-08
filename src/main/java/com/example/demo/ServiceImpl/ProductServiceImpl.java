package com.example.demo.ServiceImpl;

import com.example.demo.DaoImpl.ProductDaoImpl;
import com.example.demo.Service.ProductService;
import com.example.demo.entities.Product;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDaoImpl productDao;

    @Override
    public Product saveProduct(Product product) {
        return productDao.saveProduct(product);
    }

    @CachePut(value = "productCache", key = "#id")
    @Override
    public Product updateProduct(int id, Product product) {
        return productDao.updateProduct(id, product);
    }

    @CacheEvict(value = "productCache", key = "#id")
    @Override
    public int deleteProductById(int id) {
        return productDao.deleteProductById(id);
    }

    @Cacheable(value = "productCache", key = "#id", unless = "#result==null")
    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    //    @Cacheable(value = "productCache", unless = "#result==null")
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }


    @Cacheable(value = "productCache", key = "#businessid", unless = "#result==null")
    @Override
    public int deleteProductByBusinessId(int businessid) {
        return productDao.deleteProductByBusinessId(businessid);
    }


    @Cacheable(value = "productCache", key = "#categoryid", unless = "#result==null")
    @Override
    public int deleteProductByCategoryId(int categoryid) {
        return productDao.deleteProductByCategoryId(categoryid);
    }

    @Override
    public int deleteProductByBrandId(int brandid) {
        return productDao.deleteProductByBrandId(brandid);
    }
}

package com.example.demo.DaoImpl;

import com.example.demo.Dao.ProductDao;
import com.example.demo.entities.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(product);

        session.getTransaction().commit();
        return product;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Session session = sessionFactory.openSession();

        Product product1 = session.get(Product.class, id);

        if (product1 == null) {
            return null;
        } else {

            product1.setDiscount(product.getDiscount());
            product1.setDiscountAvailable(product.getDiscountAvailable());
            product1.setNote(product.getNote());
            product1.setPic(product.getPic());
            product1.setProductAvailable(product.getProductAvailable());
            product1.setPrice(product.getPrice());
            product1.setProductDescription(product.getProductDescription());
            product1.setProductName(product.getProductName());
            product1.setUnitWeight(product.getUnitWeight());
            product1.setUnitStock(product.getUnitStock());
            product1.setQuantity(product.getQuantity());


            session.beginTransaction();

            session.update(product1);

            session.getTransaction().commit();

        }

        return product1;


    }

    @Override
    public int deleteProductById(int id) {

        Session session = sessionFactory.openSession();

        Product product = session.get(Product.class, id);

        if (product == null) {
            return 0;

        } else {

            session.beginTransaction();

            session.delete(product);

            session.getTransaction().commit();

            return 1;
        }


    }

    @Override
    public Product getProductById(int id) {

        Session session = sessionFactory.openSession();

        Product product = session.get(Product.class, id);
        return product;


    }

    @Override
    public List<Product> getAll() {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Product.class);
        List<Product> list =criteria.list();
        return list;
    }
}

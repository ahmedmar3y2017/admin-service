package com.example.demo.DaoImpl;

import com.example.demo.Dao.ProductDao;
import com.example.demo.entities.Category;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
    public Product updateProduct(Product product) {
        Session session = sessionFactory.openSession();


        session.beginTransaction();

        session.update(product);

        session.getTransaction().commit();


        return product;


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
        List<Product> list = criteria.list();
        return list;
    }

    @Override
    public int deleteProductByBusinessId(int businessid) {
        Session session = sessionFactory.openSession();

        Category business = session.get(Category.class, businessid);
        if (business == null) {
            return 0;
        } else {
            session.beginTransaction();

            Query query = session.createQuery("delete  com.example.demo.entities.Product p where p.business.id=:id ");
            query.setParameter("id", businessid);

            query.executeUpdate();
            session.getTransaction().commit();
            return 1;

        }


    }

    @Override
    public int deleteProductByCategoryId(int categoryid) {
        Session session = sessionFactory.openSession();

        Category category = session.get(Category.class, categoryid);
        if (category == null) {
            return 0;
        } else {
            session.beginTransaction();

            Query query = session.createQuery("delete  com.example.demo.entities.Product p where p.category.id=:id ");
            query.setParameter("id", categoryid);
            query.executeUpdate();
            session.getTransaction().commit();
            return 1;

        }
    }

    @Override
    public int deleteProductByBrandId(int brandid) {
        Session session = sessionFactory.openSession();

        Category category = session.get(Category.class, brandid);
        if (category == null) {
            return 0;
        } else {
            session.beginTransaction();

            Query query = session.createQuery("delete  com.example.demo.entities.Product p where p.brands.id=:id ");
            query.setParameter("id", brandid);
            query.executeUpdate();
            session.getTransaction().commit();
            return 1;

        }
    }

    @Override
    public int deleteProductByAvailable(int id) {
        Session session = sessionFactory.openSession();

        Product business = session.get(Product.class, id);

        if (business == null) {
            return 0;

        } else {

            session.beginTransaction();
            // update flag
            business.setProductAvailable(false);
            session.update(business);

            session.getTransaction().commit();

            return 1;
        }
    }
}

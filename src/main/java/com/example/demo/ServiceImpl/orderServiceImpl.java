package com.example.demo.ServiceImpl;

import com.example.demo.DaoImpl.orderDaoImpl;
import com.example.demo.Service.orderService;
import com.example.demo.entities.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderServiceImpl implements orderService {

    @Autowired
    orderDaoImpl orderDao;

    @Override
    public int deleteOrdersByAvailable(int id) {
        return orderDao.deleteOrdersByAvailable(id);
    }

    @Override
    public Orders getOrdersById(int id) {
        return orderDao.getOrdersById(id);
    }

    @Override
    public List<Orders> getAll() {
        return orderDao.getAll();
    }

    @Override
    public List<Orders> getAllInWeek() {
        return orderDao.getAllInWeek();
    }

    @Override
    public List<Orders> getAllInMonth() {
        return orderDao.getAllInMonth();
    }

    @Override
    public Orders saveOrders(Orders orders) {
        return orderDao.saveOrders(orders);
    }
}

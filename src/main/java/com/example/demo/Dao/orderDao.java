package com.example.demo.Dao;

import com.example.demo.entities.Orders;

import java.util.List;

public interface orderDao {

    public Orders saveOrders(Orders orders);


    public int deleteOrdersByAvailable(int id);

    public Orders getOrdersById(int id);

    public List<Orders> getAll();

    List<Orders> getAllInWeek();

    List<Orders> getAllInMonth();


}

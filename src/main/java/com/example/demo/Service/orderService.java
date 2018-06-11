package com.example.demo.Service;

import com.example.demo.entities.Orders;

import java.util.List;

public interface orderService {
    public int deleteOrdersByAvailable(int id);

    public Orders getOrdersById(int id);

    public List<Orders> getAll();

    List<Orders> getAllInWeek();

    List<Orders> getAllInMonth();
    public Orders saveOrders(Orders orders);

}

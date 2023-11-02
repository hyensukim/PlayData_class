package com.example.test.repository;

import com.example.test.entitiy.Order;

import java.util.List;

public interface OrderRepository {

    public List<Order> getOrderByUserId(int userId);
}

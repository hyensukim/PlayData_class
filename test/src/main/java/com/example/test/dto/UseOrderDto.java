package com.example.test.dto;

import com.example.test.entitiy.Order;

import java.util.List;

public class UseOrderDto {

    private int userId;

    private String name;

    private int age;

    private List<Order> orderList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "UseOrderDto{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", orderList=" + orderList +
                '}';
    }
}

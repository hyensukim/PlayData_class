package com.test.jstest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class Data {
    private String name;
    private int price;
    private String producer;

    public Data(String name, int price, String producer) {
        this.name = name;
        this.price = price;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", producer='" + producer + '\'' +
                '}';
    }
}

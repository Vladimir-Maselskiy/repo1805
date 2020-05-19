package com.example.MVCProj_1605.entity;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String name;
//    @Column(name = "orders_count")
    private Integer ordersCount;

    public User() {
    }

    public User(Long id, String name, Integer ordersCount) {
        this.id = id;
        this.name = name;
        this.ordersCount = ordersCount;
    }

    public User(String name, Integer ordersCount) {
        this.name = name;
        this.ordersCount = ordersCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(Integer ordersCount) {
        this.ordersCount = ordersCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ordersCount=" + ordersCount +
                '}';
    }
}

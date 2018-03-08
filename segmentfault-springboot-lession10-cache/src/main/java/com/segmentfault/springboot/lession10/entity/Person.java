package com.segmentfault.springboot.lession10.entity;

import java.io.Serializable;

/**
 * Created by lizhuquan on 2018/3/7.
 */
public class Person implements Serializable {

    private Long id;

    private String name;

    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
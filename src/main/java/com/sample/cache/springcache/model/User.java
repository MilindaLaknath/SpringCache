package com.sample.cache.springcache.model;

import java.io.Serializable;

public class User implements Serializable {

    private String id;
    private String name;
    private int age;

    User(String id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

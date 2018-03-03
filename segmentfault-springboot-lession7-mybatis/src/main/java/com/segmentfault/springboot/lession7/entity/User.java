package com.segmentfault.springboot.lession7.entity;

import sun.security.krb5.internal.crypto.Des;

public class User {

    private int id;
    private String name;
    private int age;
    private UserDescription desc;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", desc=" + desc +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public UserDescription getDesc() {
        return desc;
    }

    public void setDesc(UserDescription desc) {
        this.desc = desc;
    }

    public static class UserDescription {
        private String job;

        public String getJob() {
            return job;
        }
        public void setJob(String job) {
            this.job = job;
        }
        @Override
        public String toString() {
            return "UserDescription{" +
                    "job='" + job + '\'' +
                    '}';
        }
    }
}

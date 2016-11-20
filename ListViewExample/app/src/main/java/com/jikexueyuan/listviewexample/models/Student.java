package com.jikexueyuan.listviewexample.models;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class Student {

    private String name;
    private int age;

    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

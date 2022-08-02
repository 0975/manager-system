package com.itheima.edu.manager.domain;

public class Student {
    private String name;
    private String id;
    private int age;
    private String birthday;
    public Student() {
    }

    public Student(String name, String id, int age, String birthday) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

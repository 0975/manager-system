package com.itheima.edu.manager.domain;

public class Teacher {
    private String name;
    private String id;
    private String age;
    private String birthday;
    public Teacher() {
    }

    public Teacher(String name, String id, String age, String birthday) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

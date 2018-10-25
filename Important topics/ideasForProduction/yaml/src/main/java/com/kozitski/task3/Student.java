package com.kozitski.task3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private int age;
    private Map<String, String> address;
    private List<String> list;
    private String[] roles;

    public Student() {

    }

    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
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
    public Map<String, String> getAddress() {
        return address;
    }
    public void setAddress(Map<String, String> address) {
        this.address = address;
    }
    public String[] getRoles() {
        return roles;
    }
    public void setRoles(String[] roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", list=" + list +
                ", roles=" + Arrays.toString(roles) +
                '}';
    }

}
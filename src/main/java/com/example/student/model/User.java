package com.example.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //used to tell jvm please create table in database with same name
public class User {

    public User() {
    }

    public User(String email, String password, String sname, int age, String phone) {
        this.email = email;
        this.password = password;
        this.sname = sname;
        this.age = age;
        this.phone = phone;
    }

    @Id // used to create field with the same name with primary key
    @GeneratedValue
    public int uid;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "sname")
    public String sname;

    @Column(name = "age")
    public int age;

    @Column(name = "phone")
    public String phone;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

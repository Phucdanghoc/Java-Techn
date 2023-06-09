package com.example.lab7_ex5.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "Age")
    private int age;
    @Column(name = "Ielts")
    private double ielts;
    public Student(int id, String name, String email, int age, double ieltsScore) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.ielts = ieltsScore;
    }
    public Student() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getIelts() {
        return ielts;
    }

    public void setIelts(double ieltsScore) {
        this.ielts = ieltsScore;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", ieltsScore=" + ielts +
                '}';
    }
}
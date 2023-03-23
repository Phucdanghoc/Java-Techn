package com.example.lab7_ex2.Service;

import com.example.lab7_ex2.Model.Student;

import java.util.List;

public interface StudentService {
    void add(Student student);
    List<Student> getAll();

    void  delete(long id);
}

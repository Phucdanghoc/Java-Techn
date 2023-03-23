package com.example.lab7_ex3.Service;

import com.example.lab7_ex3.Model.Student;

import java.util.List;

public interface StudentService {
    void add(Student student);
    List<Student> getAll();

    void  delete(long id);
}

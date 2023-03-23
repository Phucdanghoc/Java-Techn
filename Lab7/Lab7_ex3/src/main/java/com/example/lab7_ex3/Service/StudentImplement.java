package com.example.lab7_ex3.Service;

import com.example.lab7_ex3.Model.Student;
import com.example.lab7_ex3.Respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentImplement implements StudentService{
    @Autowired
    private  StudentRepository studentRepository;


    @Override
    public void add(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(p->students.add(p));
        return  students;
    }
    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);
    }


}

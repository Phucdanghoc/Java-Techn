package com.example.lab7_ex3.Respository;

import com.example.lab7_ex3.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
}

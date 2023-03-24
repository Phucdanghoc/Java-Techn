package com.example.lab7_ex4.Repository;

import com.example.lab7_ex4.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByAgeGreaterThanEqual(int x);

    int countByIelts(int x);

    List<Student> findByNameContainingIgnoreCase(String name);
}

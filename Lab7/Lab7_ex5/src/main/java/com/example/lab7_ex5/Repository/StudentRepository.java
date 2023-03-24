package com.example.lab7_ex5.Repository;

import com.example.lab7_ex5.Model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
    @Query("SELECT u FROM Student u WHERE u.name = ?1")
    List<Student> findByName(String name);

    @Query("SELECT u FROM Student u WHERE u.age >= ?1")
    List<Student> findByAgeGreaterThanEqual(int age);

    @Query("SELECT u FROM Student u WHERE u.email LIKE %?1%")
    List<Student> findByEmailContaining(String email);
}

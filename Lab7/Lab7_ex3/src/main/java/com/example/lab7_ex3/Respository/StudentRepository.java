package com.example.lab7_ex3.Respository;

import com.example.lab7_ex3.Model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student,String> {
}

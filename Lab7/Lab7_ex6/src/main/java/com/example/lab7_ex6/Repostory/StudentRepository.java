package com.example.lab7_ex6.Repostory;

import com.example.lab7_ex6.Model.Student;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface StudentRepository extends ListPagingAndSortingRepository<Student,Integer> {

}

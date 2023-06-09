package com.spring.boot.spring3.Service;

import com.spring.boot.spring3.Model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findByEmail(String email);

    Student save(Student student);

    Student update(Student student, Integer id);

    String delete(Integer id);


}

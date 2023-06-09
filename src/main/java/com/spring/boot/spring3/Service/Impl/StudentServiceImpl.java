package com.spring.boot.spring3.Service.Impl;

import com.spring.boot.spring3.Model.Student;
import com.spring.boot.spring3.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {


    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findByEmail(String email) {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student update(Student student, Integer id) {
        return null;
    }

    @Override
    public String delete(Integer id) {
        return null;
    }
}

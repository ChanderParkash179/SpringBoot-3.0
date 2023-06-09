package com.spring.boot.spring3.Service.Impl;

import com.spring.boot.spring3.Model.Student;
import com.spring.boot.spring3.Repository.StudentRepository;
import com.spring.boot.spring3.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        List<Student> students = null;
        try {
            students = this.studentRepository.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }

    @Override
    public Student findByEmail(String email) {
        Student student = null;
        try {
            student = this.studentRepository.findByEmail(email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return student;
    }

    @Override
    public Student save(Student student) {
        try {
            this.studentRepository.save(student);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return student;
    }

    @Override
    public Student update(Student student, Integer id) {
        Student oldStudent = this.studentRepository.findById(id).get();
        try {
            oldStudent.setFirstName(student.getFirstName());
            oldStudent.setLastName(student.getLastName());
            oldStudent.setEmail(student.getEmail());
            oldStudent.setDateOfBirth(student.getDateOfBirth());
            oldStudent.setAge(student.getAge());

            this.studentRepository.save(oldStudent);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return oldStudent;
    }

    @Override
    public String delete(Integer id) {
        Student oldStudent = this.studentRepository.findById(id).get();
        try {
            this.studentRepository.delete(oldStudent);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "Account Deleted containing ID: " + id;
    }
}

package com.spring.boot.spring3.Controller;

import com.spring.boot.spring3.Model.Student;
import com.spring.boot.spring3.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student/v1/")
@RequiredArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("get/all/")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(this.studentService.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("get/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable("email") String email) {
        try {
            return new ResponseEntity<>(this.studentService.findByEmail(email), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("save/")
    public ResponseEntity<?> save(@RequestBody Student student) {
        try {
            return new ResponseEntity<>(this.studentService.save(student), HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody Student student, @PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(this.studentService.update(student, id), HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(this.studentService.delete(id), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

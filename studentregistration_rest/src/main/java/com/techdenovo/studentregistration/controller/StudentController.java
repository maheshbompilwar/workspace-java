package com.techdenovo.studentregistration.controller;

import com.techdenovo.studentregistration.model.Message;
import com.techdenovo.studentregistration.model.Student;
import com.techdenovo.studentregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class StudentController {
    @Autowired
    StudentService studentService;


    @GetMapping("get-students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("add-student")
    public Message addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("get-student/{id}")
    public Student getStudent(@PathVariable ( value = "id") long id){
       return studentService.getStudent(id);
    }

    @PutMapping("update-student")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("delete-student/{id}")
    public Message deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }
}

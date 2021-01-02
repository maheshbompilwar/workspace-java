package com.techdenovo.studentregistration.service;

import com.techdenovo.studentregistration.model.Message;
import com.techdenovo.studentregistration.model.Student;
import com.techdenovo.studentregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Message addStudent(Student student){
         studentRepository.save(student);
        return new Message("Student added Successfully...", true);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public Message deleteStudent(long id){
        Student student = studentRepository.findById(id).orElse(null);
        if(student!=null){
            studentRepository.deleteById(id);
            return new Message("Student Deleted Successfully....", true);
        }
        else {
            return new Message("Student does not exist",false);
        }
    }
}

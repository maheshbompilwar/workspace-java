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
        return new Message("Student added successfully", true);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public Student isAuthenticated(String mobileNo, String password){
        Student student =null;
        Student existingStudent = studentRepository.findByMobileNo(mobileNo);
        if(existingStudent != null){
            if(existingStudent.getPassword().equals(password)){
                student= existingStudent;
            } else {
                student=null;
            }
        }
        return student;

    }

    public String deleteStudent(long id){
        Student student = studentRepository.findById(id).orElse(null);
        if(student!=null){
            studentRepository.deleteById(id);
            return "Student Deleted Successfully....";
        }
        else {
            return "Student does not exist";
        }
    }

    public Message isUserAvailable(Student student){

        System.out.println("IN isUserAvailable.............");

        Student existingStudent = studentRepository.findByMobileNo(student.getMobileNo());
        Message message =new Message();
        if(existingStudent!=null){
            message.setMessage("Mobile Number Already Exist");
            message.setFlag(false);
        }
        else {
            message=addStudent(student);
        }
        return message;
    }
}

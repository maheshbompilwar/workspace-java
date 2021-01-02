package com.techdenovo.studentregistration.controller;

import com.techdenovo.studentregistration.model.Student;
import com.techdenovo.studentregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", studentService.getStudents());
        return "index";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/getStudent/{id}")
    public String getStudent(@PathVariable ( value = "id") long id, Model model){
        model.addAttribute("student", studentService.getStudent(id));
        return "showStudent";
    }

    @GetMapping("/showUpdateStudentForm/{id}")
    public String showUpdateStudentForm(@PathVariable ( value = "id") long id, Model model) {

        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "update-student";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("update_student") Student student) {
        /*Student updatedStudent = studentService.updateStudent(student);
        long id = updatedStudent.getId();
        return "getStudent/{" + id + "}";*/
        studentService.updateStudent(student);
        return "redirect:/";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return "redirect:/";
    }

    /*

    @GetMapping("getStudents")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("addStudent")
    public Message addStudent(@RequestBody Student student){
        System.out.println("FIRSTNAME: "+student.getFirstName());
        return studentService.addStudent(student);
    }

    @PostMapping("register")
    public Message register(@RequestBody Student student){
        System.out.println("IN Register Mapping.............");

        Message message=  studentService.isUserAvailable(student);

        return message;
    }

    @PostMapping("/api/login/{mobil_no, password}")
    public Student login(@PathVariable String mobil_no, @PathVariable String password){
        return studentService.login(mobil_no, password);
    }
      @PostMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student){
        System.out.println("FIRSTNAME: "+student.getFirstName());
        return studentService.updateStudent(student);
    }

    @GetMapping("getStudent/{id}")
    public Student getStudent(@PathVariable long id){
        return studentService.getStudent(id);
    }
    */



    /*

    @PostMapping(value = "authenticate")
    public Student authenticateStudentCustom(@RequestParam String mobileNo, @RequestParam String password) {
        System.out.println("In Controller...."+mobileNo+" "+password);
        return studentService.isAuthenticated(mobileNo, password);
    }

    */
}

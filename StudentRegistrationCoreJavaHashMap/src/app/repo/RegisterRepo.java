package app.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.Student;

import app.model.Student;

public class RegisterRepo {

	//List<Student> students = new ArrayList<>();
	Map<Integer, Student> students = new HashMap<>();
	
	public String saveStudent(Student student) {
		students.put(student.getRollNo(),student);
		return "Student Addedd Successfully...";
	}
	
	public String updateStudent(Student student) {
		int rollNo = student.getRollNo();
		if(students.containsKey(rollNo)) {
			students.put(student.getRollNo(),student);
			return "Student Updated Successfully...";	
		}else {
			return "Student not available with this roll No.";
		}
		
	}
	
	public Map<Integer,Student> getStudents(){
		return students;
	}
	
	public String deleteStudentByRollNo(int rollNo) {
		students.remove(rollNo);
		return "Student Removed Successfully";
	}
	
}

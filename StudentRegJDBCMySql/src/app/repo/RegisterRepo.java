package app.repo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;

import app.database.DBConnection;
import app.model.Student;

import app.model.Student;

public class RegisterRepo {

	// List<Student> students = new ArrayList<>();
	Map<Integer, Student> students = new HashMap<>();

	public String saveStudent(Student student) {
		// students.put(student.getRollNo(),student);
		Connection connection = (Connection) DBConnection.getDBConnection();
		try {
			PreparedStatement pStatement = connection
					.prepareStatement("insert into students (roll_no, name, city) values(?,?,?)");

			pStatement.setInt(1, student.getRollNo());// 1 specifies the first parameter in the query
			pStatement.setString(2, student.getName());
			pStatement.setString(3, student.getCity());

			int i = pStatement.executeUpdate();
			System.out.println(i + " records inserted");

			connection.close();
			return "Student Addedd Successfully...";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to insert record...";
		}
	}

	public String updateStudent(Student student) {

		Connection connection = (Connection) DBConnection.getDBConnection();
		try {

			PreparedStatement pStatement = connection
					.prepareStatement("UPDATE students SET name = ?, city = ? WHERE id = ?");

			pStatement.setString(1, student.getName());
			pStatement.setString(2, student.getCity());
			pStatement.setInt(3, student.getRollNo());

			// call executeUpdate to execute our sql update statement
			pStatement.executeUpdate();
			pStatement.close();

			return "Student Updated Successfully...";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to update record...";
		}
	}

	public void getStudents() {

		try {
			Connection connection = (Connection) DBConnection.getDBConnection();
			String myQuery = "select * from students";
			PreparedStatement pStatement = connection.prepareStatement(myQuery);
			ResultSet resultSet = pStatement.executeQuery();

			System.out.println("Roll No\t\tName\t\tCity\n");

			while (resultSet.next()) {
				System.out.print(resultSet.getInt(2));
				System.out.print("\t\t" + resultSet.getString(3));
				System.out.print("\t\t" + resultSet.getString(4));
				System.out.println();
			}
		} catch (Exception exec) {
			exec.printStackTrace();
		}
	}

	public String deleteStudentByRollNo(int rollNo) {

		String deleteSQL = "DELETE FROM students WHERE roll_no = ?";

		try {

			Connection connection = (Connection) DBConnection.getDBConnection();

			PreparedStatement pStatement = connection.prepareStatement(deleteSQL);

			pStatement.setInt(1, rollNo);

			int rowCount = pStatement.executeUpdate();

			System.out.println("Record Deleted successfully....");

			return "Student Removed Successfully...";

		} catch (SQLException e) {
			System.out.println("Exception is :: " + e);
			return "Exception occur while deleting....";
		}
	}
}

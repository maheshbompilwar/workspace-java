package app.database;

import java.sql.*;

public class DBConnection {

	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/student_reg_1", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}

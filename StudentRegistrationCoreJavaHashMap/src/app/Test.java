package app;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import app.model.Student;
import app.repo.RegisterRepo;

public class Test {

	public static void main(String[] args) {

		RegisterRepo registerRepo = new RegisterRepo();

		Scanner scanner = new Scanner(System.in);

		String answer = "n";

		System.out.println("Student Registration...");
		do {
			System.out.println("Select operation \n1. Display Student List\n"
					+ "2. Add Student\n3. Update Student\n4. Delete Student");

			int option = scanner.nextInt();

			switch (option) {

			case 1:
				//List<Student> students = registerRepo.getStudents();
				Map<Integer,Student> students = registerRepo.getStudents();
				for (Map.Entry<Integer, Student> hm : students.entrySet()) {
					System.out.println("Student: " + hm.getValue());
				}
				break;
			case 2:

				System.out.println("Enter Roll No. :");
				int rollNo = scanner.nextInt();
				
				System.out.println("Enter Name: ");
				String name =scanner.next();
				
				Student student = new Student(rollNo, name);

				String msg = registerRepo.saveStudent(student);

				System.out.println(msg);

				break;
			case 3:
				System.out.println("Enter Roll No. to Update :");
				rollNo = scanner.nextInt();
				
				System.out.println("Enter Name to Update : ");
				name =scanner.next();
				
				student = new Student(rollNo, name);

				msg = registerRepo.updateStudent(student);

				System.out.println(msg);

				break;
			case 4:
				System.out.println("Enter Roll No. to Delete Student :");
				rollNo = scanner.nextInt();
				msg = registerRepo.deleteStudentByRollNo(rollNo);
				System.out.println(msg);
				break;
			default:
			}
			System.out.println("Do you want to continue..(y/n)");
			answer = scanner.next();
			System.out.println("ANSWER: "+answer);
		} while (answer.equals("y"));
	}
}

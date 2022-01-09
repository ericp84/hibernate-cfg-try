package hibernate;

import java.util.List;

import hibernate.model.Student;
import hibernate.dao.IStudentDao;
import hibernate.dao.StudentDao;

public class App {
	public static void main(String[] args) {
		
		IStudentDao studentDao = new StudentDao();
		
		//test saveStudent
		Student student = new Student(1,"eric", "paoli", "e@e.fr");
		studentDao.saveStudent(student);
		
		student.setFirstName("ericP");
		studentDao.updateStudent(student);
		
		//test getStudentById
		Student student2 = studentDao.getStudentById(student.getId());
		
		//test getAllStudents
		List<Student> students = studentDao.getAllStudents();
		students.forEach(student1 -> System.out.println(student1.getId()));
		
		//test deleteStudent
		studentDao.deleteStudent(student.getId());
	}

}

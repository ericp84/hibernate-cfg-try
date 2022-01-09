package hibernate.dao;





import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.model.Student;
import hibernate.util.HibernateUtil;

public class StudentDao implements IStudentDao {
	
	//saveStudent
	//get all students
	//get student by id
	//update student
	//delete student
	
	@Override
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//start the transaction
			transaction = session.beginTransaction();
			
			//save student object
			session.save(student);
			
			//commit the transaction
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	//
	@Override
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//start the transaction
			transaction = session.beginTransaction();
			
			//save student object
			session.saveOrUpdate(student);
			
			//commit the transaction
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	//
	@Override
	public Student getStudentById(long id) {
		Transaction transaction = null;
		Student student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//start the transaction
			transaction = session.beginTransaction();
			
			//get student object
			student = session.get(Student.class, id);
					
			//commit the transaction
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return student;
	}
	//
	@Override
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		Transaction transaction = null;
		List<Student> students = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//start the transaction
			transaction = session.beginTransaction();
			
			//get student object
			students = session.createQuery("from Student").list();
			
			//commit the transaction
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return students;
	}
	//
	@Override
	public Student deleteStudent(long id) {
		Transaction transaction = null;
		Student student = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//start the transaction
			transaction = session.beginTransaction();
			student = session.get(Student.class, id);
			//delete student object
			session.delete(student);
			
			//commit the transaction
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return student;
	}

}

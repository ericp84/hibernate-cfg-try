package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.model.Personne;
import hibernate.util.HibernateUtil;

public class PersonneDao implements IpersonneDao {
	
	//savePersonne
	//get all Personne
	//get personne by id
	//update Personne
	//delete Personne
	
	
	@Override
	public void savePersonne(Personne personne) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//start the transaction
			transaction = session.beginTransaction();
			
			//save student object
			session.save(personne);
			
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
	public void updatePersonne(Personne personne) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//start the transaction
			transaction = session.beginTransaction();
			
			//save student object
			session.saveOrUpdate(personne);
			
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
	public Personne getPersonneById(long id) {
		Transaction transaction = null;
		Personne personne = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//start the transaction
			transaction = session.beginTransaction();
			
			//get student object
			personne = session.get(Personne.class, id);
					
			//commit the transaction
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return personne;
	}
	//
	@Override
	@SuppressWarnings("unchecked")
	public List<Personne> getAllpersonnes() {
		Transaction transaction = null;
		List<Personne> students = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//start the transaction
			transaction = session.beginTransaction();
			
			//get personne object
			students = session.createQuery("from Personne").list();
			
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
	public Personne deletePersonne(long id) {
		Transaction transaction = null;
		Personne personne = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//start the transaction
			transaction = session.beginTransaction();
			personne = session.get(Personne.class, id);
			//delete personne object
			session.delete(personne);
			
			//commit the transaction
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return personne;
	}

}
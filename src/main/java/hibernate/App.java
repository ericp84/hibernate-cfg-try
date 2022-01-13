package hibernate;

import java.util.List;

import hibernate.model.Personne;
import hibernate.dao.IpersonneDao;
import hibernate.dao.PersonneDao;

public class App {
	public static void main(String[] args) {
		
		IpersonneDao personneDao = new PersonneDao();
		
		//test savePersonne
		Personne personne = new Personne();
		personneDao.savePersonne(personne);
		
		personne.setFirstName("ericP");
		personneDao.updatePersonne(personne);
		
		//test getPersonneById
		Personne personne2 = personneDao.getPersonneById(personne.getId());
		
		//test getAllPersonnes
		List<Personne> personnes = personneDao.getAllpersonnes();
		personnes.forEach(personne1 -> System.out.println(personne1.getId()));
		
		//test deletePersonne
		personneDao.deletePersonne(personne.getId());
	}

}

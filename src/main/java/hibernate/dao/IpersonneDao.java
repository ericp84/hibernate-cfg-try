package hibernate.dao;

import java.util.List;

import hibernate.model.Personne;

public interface IpersonneDao {

	void savePersonne(Personne personne);

	//
	void updatePersonne(Personne personne);

	//
	Personne getPersonneById(long id);

	//
	List<Personne> getAllpersonnes();

	//
	Personne deletePersonne(long id);

}
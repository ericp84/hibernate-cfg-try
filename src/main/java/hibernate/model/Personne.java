package hibernate.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="personne")
public class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "id")
	private long id;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "birthdate")
	private LocalDate birthdate;
	
	
	public Personne() {
		super();
	}
	
	public Personne(long id, String prenom, String nom, LocalDate birthdate) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.birthdate = birthdate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return prenom;
	}
	public void setFirstName(String prenom) {
		this.prenom = prenom;
	}
	public String getLastName() {
		return nom;
	}
	public void setLastName(String nom) {
		this.nom = nom;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
}

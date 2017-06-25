package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="firme")
public class Firma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique=true, nullable=false, length=255)
	private String naziv_firme;
	@Column(unique=true, nullable=false, length=255)
	private String adresa_firme;
	@Column(unique=true, nullable=false, length=11)
	private String pib_firme;
	@Column
	private String password;
	@Column
	private String email;
	
	public Firma() {
		// TODO Auto-generated constructor stub
	}

	public Firma(int id, String naziv_firme, String adresa_firme, String pib_firme, String password, String email) {
		super();
		this.id = id;
		this.naziv_firme = naziv_firme;
		this.adresa_firme = adresa_firme;
		this.pib_firme = pib_firme;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv_firme() {
		return naziv_firme;
	}

	public void setNaziv_firme(String naziv_firme) {
		this.naziv_firme = naziv_firme;
	}

	public String getAdresa_firme() {
		return adresa_firme;
	}

	public void setAdresa_firme(String adresa_firme) {
		this.adresa_firme = adresa_firme;
	}

	public String getPib_firme() {
		return pib_firme;
	}

	public void setPib_firme(String pib_firme) {
		this.pib_firme = pib_firme;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
}

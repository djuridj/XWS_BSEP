package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="firme")
public class Firma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique=true, nullable=false)
	private String naziv_firme;
	@Column(unique=true, nullable=false)
	private String adresa_firme;
	@Column(unique=true, nullable=false)
	private String pib_firme;
	
	@ManyToOne
	@JoinColumn(name="maticni_prenos_id", referencedColumnName = "id")
	@JsonBackReference
	private FirmePrenos matFP1;
	
	@ManyToOne
	@JoinColumn(name="maticni_prenos_id2", referencedColumnName = "id")
	@JsonBackReference
	private FirmePrenos matFP2;
	
	public Firma() {
		// TODO Auto-generated constructor stub
	}

	public Firma(int id, String naziv_firme, String adresa_firme, String pib_firme) {
		super();
		this.id = id;
		this.naziv_firme = naziv_firme;
		this.adresa_firme = adresa_firme;
		this.pib_firme = pib_firme;
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

	public FirmePrenos getMatFP1() {
		return matFP1;
	}

	public void setMatFP1(FirmePrenos matFP1) {
		this.matFP1 = matFP1;
	}

	public FirmePrenos getMatFP2() {
		return matFP2;
	}

	public void setMatFP2(FirmePrenos matFP2) {
		this.matFP2 = matFP2;
	}


	
}

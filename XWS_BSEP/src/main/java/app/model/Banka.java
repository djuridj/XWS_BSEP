package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banke")
public class Banka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int id;
	@Column
	int pib;
	@Column
	String imeBanke;
	@Column
	String drzava;
	@Column
	String adresa;
	@Column
	String email;
	@Column
	String password;
	@Column
	String swift;
	@Column
	String telefon;
	@Column
	String racun;
	@Enumerated(EnumType.STRING)
	BankaRole uloga;

	
	
	public Banka() {
		// TODO Auto-generated constructor stub
	}

	public Banka(int pib, String imeBanke, String drzava, String adresa, String email, String swift, String telefon,
			String racun, String password, BankaRole uloga) {
		super();
		this.pib = pib;
		this.imeBanke = imeBanke;
		this.drzava = drzava;
		this.adresa = adresa;
		this.email = email;
		this.swift = swift;
		this.telefon = telefon;
		this.racun = racun;
		this.password = password;
		this.uloga = uloga;
	}

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public String getImeBanke() {
		return imeBanke;
	}

	public void setImeBanke(String imeBanke) {
		this.imeBanke = imeBanke;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getRacun() {
		return racun;
	}

	public void setRacun(String racun) {
		this.racun = racun;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BankaRole getUloga() {
		return uloga;
	}

	public void setUloga(BankaRole uloga) {
		this.uloga = uloga;
	}

	
	
}

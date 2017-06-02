package app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="fakture")
public class Faktura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(unique=false, nullable=false)
	private String naziv_dobavljaca;
	@Column(unique=false, nullable=false)
	private String adresa_dobavljaca;
	@Column(unique=false, nullable=false)
	private String pib_dobavljaca;
	@Column(unique=false, nullable=false)
	private String naziv_kupca;
	@Column(unique=false, nullable=false)
	private String adresa_kupca;
	@Column(unique=false, nullable=false)
	private String pib_kupca;
	@Column(unique=false, nullable=false)
	private int broj_racuna;
	@Column(unique=false, nullable=false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datum_racuna;
	@Column(unique=false, nullable=false)
	private double vrednost_robe;
	@Column(unique=false, nullable=false)
	private double vrednost_usluga;
	@Column(unique=false, nullable=false)
	private double ukupno_roba_i_usluge;
	@Column(unique=false, nullable=false)
	private double ukupan_rabat;
	@Column(unique=false, nullable=false)
	private double ukupan_porez;
	@Column(unique=false, nullable=false)
	private String oznaka_valute;
	@Column(unique=false, nullable=false)
	private double iznos_za_uplatu;
	@Column(unique=false, nullable=false)
	private String uplata_na_racun;
	@Column(unique=false, nullable=false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datum_valute;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "maticnaFaktura")
	@JsonManagedReference
	private Set<FakturaStavke> stavke = new HashSet<FakturaStavke>();
	
	public Faktura() {
		// TODO Auto-generated constructor stub
	}

	public Faktura(int id, String naziv_dobavljaca, String adresa_dobavljaca, String pib_dobavljaca,
			String naziv_kupca, String adresa_kupca, String pib_kupca, int broj_racuna, Date datum_racuna,
			double vrednost_robe, double vrednost_usluga, double ukupno_roba_i_usluge, double ukupan_rabat,
			double ukupan_porez, String oznaka_valute, double iznos_za_uplatu, String uplata_na_racun,
			Date datum_valute, HashSet<FakturaStavke> stavke) {
		super();
		this.id = id;
		this.naziv_dobavljaca = naziv_dobavljaca;
		this.adresa_dobavljaca = adresa_dobavljaca;
		this.pib_dobavljaca = pib_dobavljaca;
		this.naziv_kupca = naziv_kupca;
		this.adresa_kupca = adresa_kupca;
		this.pib_kupca = pib_kupca;
		this.broj_racuna = broj_racuna;
		this.datum_racuna = datum_racuna;
		this.vrednost_robe = vrednost_robe;
		this.vrednost_usluga = vrednost_usluga;
		this.ukupno_roba_i_usluge = ukupno_roba_i_usluge;
		this.ukupan_rabat = ukupan_rabat;
		this.ukupan_porez = ukupan_porez;
		this.oznaka_valute = oznaka_valute;
		this.iznos_za_uplatu = iznos_za_uplatu;
		this.uplata_na_racun = uplata_na_racun;
		this.datum_valute = datum_valute;
		this.stavke = stavke;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv_dobavljaca() {
		return naziv_dobavljaca;
	}

	public void setNaziv_dobavljaca(String naziv_dobavljaca) {
		this.naziv_dobavljaca = naziv_dobavljaca;
	}

	public String getAdresa_dobavljaca() {
		return adresa_dobavljaca;
	}

	public void setAdresa_dobavljaca(String adresa_dobavljaca) {
		this.adresa_dobavljaca = adresa_dobavljaca;
	}

	public String getPib_dobavljaca() {
		return pib_dobavljaca;
	}

	public void setPib_dobavljaca(String pib_dobavljaca) {
		this.pib_dobavljaca = pib_dobavljaca;
	}

	public String getNaziv_kupca() {
		return naziv_kupca;
	}

	public void setNaziv_kupca(String naziv_kupca) {
		this.naziv_kupca = naziv_kupca;
	}

	public String getAdresa_kupca() {
		return adresa_kupca;
	}

	public void setAdresa_kupca(String adresa_kupca) {
		this.adresa_kupca = adresa_kupca;
	}

	public String getPib_kupca() {
		return pib_kupca;
	}

	public void setPib_kupca(String pib_kupca) {
		this.pib_kupca = pib_kupca;
	}

	public int getBroj_racuna() {
		return broj_racuna;
	}

	public void setBroj_racuna(int broj_racuna) {
		this.broj_racuna = broj_racuna;
	}

	public Date getDatum_racuna() {
		return datum_racuna;
	}

	public void setDatum_racuna(Date datum_racuna) {
		this.datum_racuna = datum_racuna;
	}

	public double getVrednost_robe() {
		return vrednost_robe;
	}

	public void setVrednost_robe(double vrednost_robe) {
		this.vrednost_robe = vrednost_robe;
	}

	public double getVrednost_usluga() {
		return vrednost_usluga;
	}

	public void setVrednost_usluga(double vrednost_usluga) {
		this.vrednost_usluga = vrednost_usluga;
	}

	public double getUkupno_roba_i_usluge() {
		return ukupno_roba_i_usluge;
	}

	public void setUkupno_roba_i_usluge(double ukupno_roba_i_usluge) {
		this.ukupno_roba_i_usluge = ukupno_roba_i_usluge;
	}

	public double getUkupan_rabat() {
		return ukupan_rabat;
	}

	public void setUkupan_rabat(double ukupan_rabat) {
		this.ukupan_rabat = ukupan_rabat;
	}

	public double getUkupan_porez() {
		return ukupan_porez;
	}

	public void setUkupan_porez(double ukupan_porez) {
		this.ukupan_porez = ukupan_porez;
	}

	public String getOznaka_valute() {
		return oznaka_valute;
	}

	public void setOznaka_valute(String oznaka_valute) {
		this.oznaka_valute = oznaka_valute;
	}

	public double getIznos_za_uplatu() {
		return iznos_za_uplatu;
	}

	public void setIznos_za_uplatu(double iznos_za_uplatu) {
		this.iznos_za_uplatu = iznos_za_uplatu;
	}

	public String getUplata_na_racun() {
		return uplata_na_racun;
	}

	public void setUplata_na_racun(String uplata_na_racun) {
		this.uplata_na_racun = uplata_na_racun;
	}

	public Date getDatum_valute() {
		return datum_valute;
	}

	public void setDatum_valute(Date datum_valute) {
		this.datum_valute = datum_valute;
	}

	public Set<FakturaStavke> getStavke() {
		return stavke;
	}

	public void setStavke(Set<FakturaStavke> stavke) {
		this.stavke = stavke;
	}
	
	

}

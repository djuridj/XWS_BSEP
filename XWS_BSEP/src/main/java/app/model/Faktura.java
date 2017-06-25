package app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="fakture")
public class Faktura {
	
	@Id
	@Max(50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Pattern(regexp="[0-9]{6}")
	@Column(unique=false, nullable=false)
	private int broj_racuna;
	@Column(unique=false, nullable=false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datum_racuna;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(15,2)")
	private double vrednost_robe;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(15,2)")
	private double vrednost_usluga;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(15,2)")
	private double ukupno_roba_i_usluge;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(15,2)")
	private double ukupan_rabat;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(15,2)")
	private double ukupan_porez;
	@Column(unique=false, nullable=false,  length = 3)
	private String oznaka_valute;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(15,2)")
	private double iznos_za_uplatu;
	@Column(unique=false, nullable=false, length = 18)
	@Pattern(regexp="[0-9]{3}-[0-9]{13}-[0-9]{2}")
	private String uplata_na_racun;
	@Column(unique=false, nullable=false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datum_valute;
	
	@Column(insertable=false, updatable=false)
	private int id_dobavljaca;
	
	@Column(insertable=false, updatable=false)
	private int id_kupca;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="id_dobavljaca")
	private Firma firma_dobavljac;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="id_kupca")
	private Firma firma_kupac;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "maticnaFaktura")
	@JsonManagedReference
	private Set<FakturaStavke> stavke = new HashSet<FakturaStavke>();
	
	
	public Faktura() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

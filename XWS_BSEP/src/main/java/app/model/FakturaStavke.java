package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "stavke_fakture")
public class FakturaStavke {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Max(999)
	@Column(name="redni_broj")
	private int rednibroj;
	@Column(unique=false, nullable=false, length = 120)
	private String naziv_robe_ili_usluge;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(10,2)")
	private double kolicina;
	@Column(unique=false, nullable=false, length = 120)
	private String jedinica_mere;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(10,2)")
	private double jedinicna_cena;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(12,2)")
	private double vrednost;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(5,2)")
	private double procenat_rabata;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(12,2)")
	private double iznos_rabata;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(12,2)")
	private double umanjeno_za_rabat;
	@Column(unique=false, nullable=false, columnDefinition="Decimal(12,2)")
	private double ukupan_porez;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name= "maticna_faktura_id", referencedColumnName = "id")
	private Faktura maticnaFaktura;
	
	
	public FakturaStavke() {
		// TODO Auto-generated constructor stub
	}

	public FakturaStavke(int rednibroj, String naziv_robe_ili_usluge, double kolicina, String jedinica_mere,
			double jedinicna_cena, double vrednost, double procenat_rabata, double iznos_rabata,
			double umanjeno_za_rabat, double ukupan_porez) {
		super();
		this.rednibroj = rednibroj;
		this.naziv_robe_ili_usluge = naziv_robe_ili_usluge;
		this.kolicina = kolicina;
		this.jedinica_mere = jedinica_mere;
		this.jedinicna_cena = jedinicna_cena;
		this.vrednost = vrednost;
		this.procenat_rabata = procenat_rabata;
		this.iznos_rabata = iznos_rabata;
		this.umanjeno_za_rabat = umanjeno_za_rabat;
		this.ukupan_porez = ukupan_porez;
	}

	public int getRednibroj() {
		return rednibroj;
	}

	public void setRednibroj(int rednibroj) {
		this.rednibroj = rednibroj;
	}

	public String getNaziv_robe_ili_usluge() {
		return naziv_robe_ili_usluge;
	}

	public void setNaziv_robe_ili_usluge(String naziv_robe_ili_usluge) {
		this.naziv_robe_ili_usluge = naziv_robe_ili_usluge;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public String getJedinica_mere() {
		return jedinica_mere;
	}

	public void setJedinica_mere(String jedinica_mere) {
		this.jedinica_mere = jedinica_mere;
	}

	public double getJedinicna_cena() {
		return jedinicna_cena;
	}

	public void setJedinicna_cena(double jedinicna_cena) {
		this.jedinicna_cena = jedinicna_cena;
	}

	public double getVrednost() {
		return vrednost;
	}

	public void setVrednost(double vrednost) {
		this.vrednost = vrednost;
	}

	public double getProcenat_rabata() {
		return procenat_rabata;
	}

	public void setProcenat_rabata(double procenat_rabata) {
		this.procenat_rabata = procenat_rabata;
	}

	public double getIznos_rabata() {
		return iznos_rabata;
	}

	public void setIznos_rabata(double iznos_rabata) {
		this.iznos_rabata = iznos_rabata;
	}

	public double getUmanjeno_za_rabat() {
		return umanjeno_za_rabat;
	}

	public void setUmanjeno_za_rabat(double umanjeno_za_rabat) {
		this.umanjeno_za_rabat = umanjeno_za_rabat;
	}

	public double getUkupan_porez() {
		return ukupan_porez;
	}

	public void setUkupan_porez(double ukupan_porez) {
		this.ukupan_porez = ukupan_porez;
	}

	public Faktura getMaticnaFaktura() {
		return maticnaFaktura;
	}

	public void setMaticnaFaktura(Faktura maticnaFaktura) {
		this.maticnaFaktura = maticnaFaktura;
	}
	
	
}

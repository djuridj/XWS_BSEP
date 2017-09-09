package app.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;




@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "racuni", propOrder = {

})

@Entity
@Table(name="racuni")
public class Racuni {
	@Id
	@Column
	@XmlElement(name ="id_racuna",required = true)
	protected String id_racuna;
	@Column
	@XmlElement(name = "broj_racuna", required = true, defaultValue = "000-0000000000000-00")
	protected String brojRacuna;
	@Column
	@XmlElement(name = "stanje_na_racunu")
	protected BigDecimal stanje_na_racunu;
	@ManyToOne
	@JoinColumn(name = "id")
	@XmlElement(name ="maticna_banka")
	protected Banka maticnaBanka;
	
	
	
	
	public String getId_racuna() {
		return id_racuna;
	}
	public void setId_racuna(String id_racuna) {
		this.id_racuna = id_racuna;
	}
	public String getBrojRacuna() {
		return brojRacuna;
	}
	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}
	public Banka getMaticnaBanka() {
		return maticnaBanka;
	}
	public void setMaticnaBanka(Banka maticnaBanka) {
		this.maticnaBanka = maticnaBanka;
	}
	public BigDecimal getStanje_na_racunu() {
		return stanje_na_racunu;
	}
	public void setStanje_na_racunu(BigDecimal stanje_na_racunu) {
		this.stanje_na_racunu = stanje_na_racunu;
	}
	
	
	
	

	
}

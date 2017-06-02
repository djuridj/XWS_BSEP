package app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="firme_prenos")
public class FirmePrenos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "matFP1") 
	@JsonManagedReference
	private Set<Firma> firma_uplatilac = new HashSet<Firma>();
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "matFP2") 
	@JsonManagedReference
	private Set<Firma> firma_primalac = new HashSet<Firma>();
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "matFP") 
	@JsonManagedReference
	private Set<Faktura> faktura = new HashSet<Faktura>();
	
	public FirmePrenos() {
		// TODO Auto-generated constructor stub
	}


	public FirmePrenos(int id, Set<Firma> firma_uplatilac, Set<Firma> firma_primalac, Set<Faktura> faktura) {
		super();
		this.id = id;
		this.firma_uplatilac = firma_uplatilac;
		this.firma_primalac = firma_primalac;
		this.faktura = faktura;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Set<Firma> getFirma_uplatilac() {
		return firma_uplatilac;
	}


	public void setFirma_uplatilac(Set<Firma> firma_uplatilac) {
		this.firma_uplatilac = firma_uplatilac;
	}


	public Set<Firma> getFirma_primalac() {
		return firma_primalac;
	}


	public void setFirma_primalac(Set<Firma> firma_primalac) {
		this.firma_primalac = firma_primalac;
	}


	public Set<Faktura> getFaktura() {
		return faktura;
	}


	public void setFaktura(Set<Faktura> faktura) {
		this.faktura = faktura;
	}




	
	

}

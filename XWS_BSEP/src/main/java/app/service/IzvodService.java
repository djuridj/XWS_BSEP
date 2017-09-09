package app.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repo.IzvodRepo;
import app.repo.NalogZaPlacanjeRepo;
import app.soap.izvod.Izvod;
import app.soap.izvod.StavkaPreseka;
import app.soap.izvod.Zaglavlje;
import app.soap.nalog_za_placanje.NalogZaPlacanje;
import app.soap.izvod.ZahtevZaIzvod;

@Service
public class IzvodService {
	
	@Autowired
	private IzvodRepo ir;
	private NalogZaPlacanjeRepo npr;
	
	public Izvod getOneById(String id_poruke) {
		return ir.findOne(id_poruke);
	}
	
	public Izvod addNew(Izvod izvod) {		
		return ir.save(izvod);
	}

}

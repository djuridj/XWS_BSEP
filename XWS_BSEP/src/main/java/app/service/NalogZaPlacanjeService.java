package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repo.NalogZaPlacanjeRepo;
import app.soap.nalog_za_placanje.NalogZaPlacanje;

@Service
public class NalogZaPlacanjeService {
	
	@Autowired
	private NalogZaPlacanjeRepo nzpr;
	
	public NalogZaPlacanje getOneById(String id_poruke) {
		return nzpr.findOne(id_poruke);
	}
	
	public NalogZaPlacanje addNew(NalogZaPlacanje n) {
		return nzpr.save(n);
	}

}

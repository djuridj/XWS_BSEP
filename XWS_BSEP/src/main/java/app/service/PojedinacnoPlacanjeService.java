package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import app.repo.PojedinacniNaloziRepo;
import app.soap.clearing_mt102.ClearingMt102.PojedinacnoPlacanje;


@Service
public class PojedinacnoPlacanjeService {
	@Autowired
	private PojedinacniNaloziRepo pnr;
	
	public PojedinacnoPlacanje getOneById(String id_poruke) {
		return pnr.findOne(id_poruke);
	}
	
	public PojedinacnoPlacanje addNew(PojedinacnoPlacanje n) {
		return pnr.save(n);
	}
}

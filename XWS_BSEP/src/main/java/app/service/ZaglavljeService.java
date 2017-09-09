package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repo.ZaglavljeRepo;
import app.soap.izvod.Zaglavlje;


@Service
public class ZaglavljeService {
	
	@Autowired
	private ZaglavljeRepo zr;
	
	public Zaglavlje getOneById(String id_poruke) {
		return zr.findOne(id_poruke);
	}
	
	public Zaglavlje addNew(Zaglavlje zaglavlje) {		
		return zr.save(zaglavlje);
	}

}

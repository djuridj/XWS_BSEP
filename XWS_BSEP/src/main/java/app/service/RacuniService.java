package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Racuni;
import app.repo.RacuniRepo;


@Service
public class RacuniService {
	
	@Autowired
	public RacuniRepo rrep;
	
	public Racuni getOneById(String id_racuna) {
		return rrep.findOne(id_racuna);
	}
	
	public Racuni getOneByBrojRacun(String brojRacuna) {
		  return rrep.findOne(brojRacuna);
	}
	public Racuni addNew(Racuni r) {
		return rrep.save(r);
	}
	public Racuni getOneByRacun(String brojRacuna){
		return rrep.findBybrojRacuna(brojRacuna);
	}
}

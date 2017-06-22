package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repo.IzvodRepo;
import app.soap.izvod.Izvod;

@Service
public class IzvodService {
	
	@Autowired
	private IzvodRepo ir;
	
	public Izvod getOneById(String id_poruke) {
		return ir.findOne(id_poruke);
	}
	
	public Izvod addNew(Izvod n) {
		return ir.save(n);
	}

}

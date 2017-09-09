package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repo.StavkaRepo;
import app.soap.izvod.StavkaPreseka;


@Service
public class StavkaService {
	
	@Autowired
	private StavkaRepo sr;
	
	public StavkaPreseka getOneById(String id_poruke) {
		return sr.findOne(id_poruke);
	}
	
	public StavkaPreseka addNew(StavkaPreseka stavka) {		
		return sr.save(stavka);
	}

}

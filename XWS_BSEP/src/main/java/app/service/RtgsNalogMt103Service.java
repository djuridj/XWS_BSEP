package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import app.repo.RtgsNalogMt103Repo;

import app.soap.rtgs_mt103.RtgsMt103;

@Service
public class RtgsNalogMt103Service {
	@Autowired
	private RtgsNalogMt103Repo rnmt;
	
	public RtgsMt103 getOneById(String id_poruke) {
		return rnmt.findOne(id_poruke);
	}
	
	public RtgsMt103 addNew(RtgsMt103 r) {
		return rnmt.save(r);
	}
}

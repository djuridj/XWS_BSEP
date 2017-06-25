package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repo.ClearingMt102Repo;
import app.soap.clearing_mt102.ClearingMt102;

@Service
public class ClearingMt102Service {
	@Autowired
	private ClearingMt102Repo cmt;
	
	public ClearingMt102 getOneById(String id_poruke) {
		return cmt.findOne(id_poruke);
	}
	
	public ClearingMt102 addNew(ClearingMt102 c) {
		return cmt.save(c);
	}
}

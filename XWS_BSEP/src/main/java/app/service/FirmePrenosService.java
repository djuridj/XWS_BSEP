package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.FirmePrenos;
import app.repo.FirmePrenosRepo;

@Service
public class FirmePrenosService {
	
	@Autowired
	private FirmePrenosRepo fpRepo;
	
	public FirmePrenosService() {
		// TODO Auto-generated constructor stub
	}
	
	public FirmePrenos getOneById(int id) {
		return fpRepo.findOne(id);
	}
}

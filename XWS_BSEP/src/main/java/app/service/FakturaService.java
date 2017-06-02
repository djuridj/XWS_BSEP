package app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Faktura;
import app.repo.FakturaRepo;

@Service
public class FakturaService {

	@Autowired
	private FakturaRepo fakturaRepo;
	
	public FakturaService() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Faktura> getAll() {
		ArrayList<Faktura> fakture = new ArrayList<>();
		fakturaRepo.findAll().forEach(fakture::add);
		return fakture;
	}
	
	public Faktura getOneById(int id) {
		return fakturaRepo.findOne(id);
	}
	
	public Faktura addNew(Faktura faktura) {
		return fakturaRepo.save(faktura);
	}
	
	public Faktura editFaktura(Faktura faktura) {
		return fakturaRepo.save(faktura);
	}
	
	public void deleteFaktura(int id){
		fakturaRepo.delete(id);
	}
}

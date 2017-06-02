package app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.FakturaStavke;
import app.repo.FakturaStavkeRepo;

@Service
public class FakturaStavkeService {

	@Autowired
	private FakturaStavkeRepo fsRepo;
	
	public FakturaStavkeService() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<FakturaStavke> getAllByFaktura(int fakturaId) {
		ArrayList<FakturaStavke> fs = new ArrayList<>();
		fsRepo.findByMaticnaFaktura_Id(fakturaId).forEach(fs::add);
		return fs;
	}
	
	public FakturaStavke getOneById(int fakturaId, int rednibroj) {
		FakturaStavke fs = fsRepo.findByMaticnaFaktura_IdAndRednibroj(fakturaId, rednibroj);
		return fs;
	}
	
	public FakturaStavke addNew(FakturaStavke fs) {
		return fsRepo.save(fs);
	}
	
	public FakturaStavke editFakturaStavke(FakturaStavke fs) {
		return fsRepo.save(fs);
	}
	
	public void deleteStavka(int rednibroj) {
		fsRepo.delete(rednibroj);
	}
}

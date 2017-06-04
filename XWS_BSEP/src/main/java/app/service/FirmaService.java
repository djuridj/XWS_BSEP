package app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Firma;
import app.repo.FirmaRepo;

@Service
public class FirmaService {

	@Autowired
	private FirmaRepo fs;
	
	public FirmaService() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Firma> getAll() {
		ArrayList<Firma> firme = new ArrayList<>();
		fs.findAll().forEach(firme::add);
		return firme;
	}
	
	public Firma getOneById(int id) {
		return fs.findOne(id);
	}
	
	public Firma addNew(Firma f) {
		return fs.save(f);
	}
	
	public Firma edit(Firma f) {
		return fs.save(f);
	}
	
	public void delete(int id) {
		fs.delete(id);
	}
}

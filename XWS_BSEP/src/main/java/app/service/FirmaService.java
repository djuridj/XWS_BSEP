package app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import app.model.Firma;
import app.repo.FirmaRepo;

@Service
public class FirmaService {

	@Autowired
	private FirmaRepo fs;
	
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
		f.setPassword(bCryptPasswordEncoder.encode(f.getPassword()));
		return fs.save(f);
	}
	
	public Firma edit(Firma f) {
		f.setPassword(bCryptPasswordEncoder.encode(f.getPassword()));
		return fs.save(f);
	}
	
	public void delete(int id) {
		fs.delete(id);
	}
	
	public Firma logIn(Firma firma) {
		String email = firma.getEmail();
		return this.fs.findByEmail(email);
	}
}

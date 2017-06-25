package app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import app.model.Banka;
import app.repo.BankaRepo;

@Service
public class BankaService {

	@Autowired
	public BankaRepo br;
	
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public ArrayList<Banka> getAll() {
		ArrayList<Banka> banke = new ArrayList<Banka>();
		br.findAll().forEach(banke::add);
		return banke;
	}
	
	public Banka getById(int id) {
		return br.findOne(id);
	}
	
	public Banka addNew(Banka banka) {
		banka.setPassword(bCryptPasswordEncoder.encode(banka.getPassword()));
		return br.save(banka);
	}
	
	public Banka editBanka(Banka banka) {
		banka.setPassword(bCryptPasswordEncoder.encode(banka.getPassword()));
		return br.save(banka);
	}
	
	public void deleteBanka(int id){
		br.delete(id);
	}
	
	public Banka logIn(Banka banka) {
		String email = banka.getEmail();
		return this.br.findByEmail(email);
	}
	
}

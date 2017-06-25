package app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import app.model.Banka;
import app.service.BankaService;

@RestController
@RequestMapping("/banke")
public class BankaController {

	@Autowired
	public BankaService bs;
	
	@Autowired
	private HttpSession session;

	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Banka> getSveBanke() {
		return bs.getAll();
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Banka> getById(@PathVariable int id) {
		Banka b = bs.getById(id);
		if (b == null) {
			return new ResponseEntity<Banka>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Banka>(b, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Banka> addFaktura(Banka b) {
		Banka ban = bs.editBanka(b);
		return new ResponseEntity<Banka>(ban, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}",
			method = RequestMethod.DELETE)
	public ResponseEntity<Banka> deleteBanka(@PathVariable int id) {
		bs.deleteBanka(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/login",
			method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Banka> logIn(@RequestBody Banka banka) {
	Banka temp = this.bs.logIn(banka);
	if(temp!=null && banka.getPassword() != null && temp.getPassword().equals(banka.getPassword())){
		session.setAttribute("banka", temp);
		return new ResponseEntity<Banka>(temp,HttpStatus.OK);
	}
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}

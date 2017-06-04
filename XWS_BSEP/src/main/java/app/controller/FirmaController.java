package app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Firma;
import app.service.FirmaService;

@RestController
@RequestMapping("/firme")
public class FirmaController {
	
	@Autowired
	private FirmaService fs;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Firma> getSviGosti() {
		return fs.getAll();
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Firma> getById(@PathVariable int id) {
		Firma f = fs.getOneById(id);
		return new ResponseEntity<Firma>(f, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Firma> register(Firma f) {
		Firma firma = fs.addNew(f);
	if (firma == null) {
		return new ResponseEntity<Firma>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<Firma>(firma, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Firma> deleteFirma(@PathVariable int id){
		fs.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Firma> edit(Firma firma) {
		Firma f = fs.edit(firma);
		return new ResponseEntity<Firma>(f, HttpStatus.OK);
	}
}

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

import app.model.Faktura;
import app.service.FakturaService;

@RestController
@RequestMapping("/fakture")
public class FakturaController {
	
	@Autowired
	private FakturaService fakturaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Faktura> getSveFakture() {
		return fakturaService.getAll();
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Faktura> getById(@PathVariable int id) {
		Faktura f = fakturaService.getOneById(id);
		if (f == null) {
			return new ResponseEntity<Faktura>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Faktura>(f, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST,
					consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Faktura> addFaktura(Faktura f) {
		Faktura fak = fakturaService.addNew(f);
		return new ResponseEntity<Faktura>(fak, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}",
			method = RequestMethod.DELETE)
	public ResponseEntity<Faktura> deleteFaktura(@PathVariable int id) {
		fakturaService.deleteFaktura(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

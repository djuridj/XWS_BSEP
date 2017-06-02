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
import app.model.FakturaStavke;
import app.service.FakturaService;
import app.service.FakturaStavkeService;

@RestController
@RequestMapping("/fakture/{fakturaId}/stavke")
public class FakturaStavkeController {
	
	@Autowired
	private FakturaStavkeService fsService;
	
	@Autowired
	private FakturaService fService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<FakturaStavke> getSveStavke(@PathVariable int fakturaId) {
		return fsService.getAllByFaktura(fakturaId);
	}
	
	@RequestMapping(value = "/{rednibroj}",
				method = RequestMethod.GET)
	public ResponseEntity<FakturaStavke> getById(@PathVariable int fakturaId, @PathVariable int rednibroj) {
		FakturaStavke fs = fsService.getOneById(fakturaId, rednibroj);
		return new ResponseEntity<FakturaStavke>(fs, HttpStatus.OK); 
	}
	
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FakturaStavke> add(FakturaStavke fs, @PathVariable int fakturaId){
		FakturaStavke faks = fs;
		Faktura f = fService.getOneById(fakturaId);
		faks.setMaticnaFaktura(f);
		f.getStavke().add(faks);
		FakturaStavke fakts = fsService.addNew(faks);
		return new ResponseEntity<FakturaStavke>(fakts, HttpStatus.OK);
	}
}

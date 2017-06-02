package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.FirmePrenos;
import app.service.FirmePrenosService;

@RestController
@RequestMapping("/firmeprenosi")
public class FirmePrenosController {
	
	@Autowired
	private FirmePrenosService fpService;
	
	@RequestMapping("/{id}")
	public ResponseEntity<FirmePrenos> getById(@PathVariable int id) {
		FirmePrenos fp = fpService.getOneById(id);
		return new ResponseEntity<FirmePrenos>(fp, HttpStatus.OK);
	}
}

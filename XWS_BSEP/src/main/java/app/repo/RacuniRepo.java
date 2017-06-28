package app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.model.Racuni;

public interface RacuniRepo extends CrudRepository<Racuni,String> {

	Racuni findBybrojRacuna(String brojRacuna);
     
	// Racuni findByRacun(String brojRacuna);
}

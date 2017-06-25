package app.repo;

import org.springframework.data.repository.CrudRepository;

import app.model.Firma;

public interface FirmaRepo extends CrudRepository<Firma, Integer> {

	public Firma findByEmail(String email);
	
}

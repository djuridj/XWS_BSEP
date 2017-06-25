package app.repo;

import org.springframework.data.repository.CrudRepository;

import app.model.Banka;

public interface BankaRepo extends CrudRepository<Banka,Integer>{

	public Banka findByEmail(String email);
	
}

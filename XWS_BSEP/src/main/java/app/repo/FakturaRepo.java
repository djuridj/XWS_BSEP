package app.repo;

import org.springframework.data.repository.CrudRepository;

import app.model.Faktura;

public interface FakturaRepo extends CrudRepository<Faktura, Integer> {

}

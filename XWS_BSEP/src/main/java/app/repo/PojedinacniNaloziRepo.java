package app.repo;

import org.springframework.data.repository.CrudRepository;

import app.soap.clearing_mt102.ClearingMt102.PojedinacnoPlacanje;


public interface PojedinacniNaloziRepo extends CrudRepository<PojedinacnoPlacanje,String> {

}

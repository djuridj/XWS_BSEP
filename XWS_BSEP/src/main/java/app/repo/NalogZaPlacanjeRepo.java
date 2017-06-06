package app.repo;

import org.springframework.data.repository.CrudRepository;

import app.soap.nalog_za_placanje.NalogZaPlacanje;

public interface NalogZaPlacanjeRepo extends CrudRepository<NalogZaPlacanje,String>{

}

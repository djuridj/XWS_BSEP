package app.repo;

import org.springframework.data.repository.CrudRepository;

import app.soap.izvod.Zaglavlje;

public interface ZaglavljeRepo extends CrudRepository<Zaglavlje,String>{

}

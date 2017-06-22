package app.repo;

import org.springframework.data.repository.CrudRepository;

import app.soap.zahtev_za_izvod.ZahtevZaIzvod;

public interface ZahtevZaIzvodRepo extends CrudRepository<ZahtevZaIzvod,String>{

}

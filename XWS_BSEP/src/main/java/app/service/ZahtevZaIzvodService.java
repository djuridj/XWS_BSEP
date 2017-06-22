package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repo.ZahtevZaIzvodRepo;
import app.soap.zahtev_za_izvod.ZahtevZaIzvod;

@Service
public class ZahtevZaIzvodService {
	
	@Autowired
	private ZahtevZaIzvodRepo zzir;
	
	public ZahtevZaIzvod getOneById(String id_poruke) {
		return zzir.findOne(id_poruke);
	}
	
	public ZahtevZaIzvod addNew(ZahtevZaIzvod n) {
		return zzir.save(n);
	}

}

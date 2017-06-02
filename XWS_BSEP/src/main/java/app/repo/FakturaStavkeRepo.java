package app.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import app.model.FakturaStavke;

public interface FakturaStavkeRepo extends CrudRepository<FakturaStavke, Integer> {
	
	public ArrayList<FakturaStavke> findByMaticnaFaktura_Id(int fakturaId);
	
	public FakturaStavke findByMaticnaFaktura_IdAndRednibroj(int fakturaId, int redni_broj);
	
	public FakturaStavke findByRednibroj(int rednibroj);
}

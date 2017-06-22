package app.repo;

import org.springframework.data.repository.CrudRepository;

import app.soap.izvod.Izvod;

public interface IzvodRepo extends CrudRepository<Izvod,String>{

}

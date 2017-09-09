package app.repo;

import org.springframework.data.repository.CrudRepository;

import app.soap.izvod.StavkaPreseka;

public interface StavkaRepo extends CrudRepository<StavkaPreseka,String>{

}
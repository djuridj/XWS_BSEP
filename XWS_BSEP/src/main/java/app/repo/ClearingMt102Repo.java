package app.repo;

import org.springframework.data.repository.CrudRepository;

import app.soap.clearing_mt102.ClearingMt102;


public interface ClearingMt102Repo extends CrudRepository<ClearingMt102,String> {

}

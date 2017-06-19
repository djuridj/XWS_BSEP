package app.repo;

import org.springframework.data.repository.CrudRepository;


import app.soap.rtgs_mt103.RtgsMt103;

public interface RtgsNalogMt103Repo extends CrudRepository<RtgsMt103,String>{

}

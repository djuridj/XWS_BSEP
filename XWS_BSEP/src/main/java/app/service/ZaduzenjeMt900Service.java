package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repo.ZaduzenjeMt900Repo;

import app.soap.zaduzenje_mt900.ZaduzenjeMt900;

@Service
public class ZaduzenjeMt900Service {
	
    @Autowired
	private ZaduzenjeMt900Repo zmtr;
    
    public ZaduzenjeMt900 getOneById(String id_poruke) {
		return zmtr.findOne(id_poruke);
	}
	
	public ZaduzenjeMt900 addNew(ZaduzenjeMt900 n) {
		return zmtr.save(n);
	}
}

package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repo.OdobrenjeMt910Repo;

import app.soap.odobrenje_mt910.OdobrenjeMt910;


@Service
public class OdobrenjeMt910Service {
	 @Autowired
		private OdobrenjeMt910Repo omtr;
	    
	    public OdobrenjeMt910 getOneById(String id_poruke) {
			return omtr.findOne(id_poruke);
		}
		
		public OdobrenjeMt910 addNew(OdobrenjeMt910 n) {
			return omtr.save(n);
		}
}

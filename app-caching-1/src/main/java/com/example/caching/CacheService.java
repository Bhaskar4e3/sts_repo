package com.example.caching;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
@Service
public class CacheService {
	@Autowired
  private	CacheRepo cacheRepo;
	
	org.slf4j.Logger logger=LoggerFactory.getLogger(CacheService.class);
	@CachePut(cacheNames = "students",key="#pupil.getStudent_id")
	public Pupil save(Pupil pupil) {
	Pupil p1=cacheRepo.save(pupil);
		return p1;
	}
	
	public List<Pupil> load() {
		logger.info("fetching all from db");
		 List<Pupil> p= cacheRepo.findAll();
		 return   p;
		
	}
	@Cacheable(cacheNames = "students",key="#student_id")
	public Pupil byId(int student_id) {
		logger.info("fetching student from db");
		Optional<Pupil> p=cacheRepo.findById(student_id);
		if(p.isPresent()) {
			return p.get();
		}
		else {
			return new Pupil();
		}
		
	}
	@CacheEvict(cacheNames = "students", key="#id")
	public void del(int id) {
		logger.info("delete from the db "+id);
		cacheRepo.deleteById(id);
		
	}

}

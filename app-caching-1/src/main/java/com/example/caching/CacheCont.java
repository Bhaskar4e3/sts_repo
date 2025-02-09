package com.example.caching;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheCont {
	@Autowired
	CacheService cacheService;
	@PostMapping("/add")
	public Pupil save(@RequestBody Pupil pupil) {
		
		return  cacheService.save(pupil);
		
	}
	@GetMapping("/load")
	public List<Pupil> get() {
		List<Pupil> pr=   cacheService.load();
		return  pr;
	}
	 @GetMapping("/{id}")
	public Pupil getById(@PathVariable ("id") int Student_id) {
		 return cacheService.byId(Student_id);
	 }
	 @PutMapping("/update")
	 public Pupil update(@RequestBody Pupil p) {
		 Pupil pu=cacheService.byId(p.getStudent_id());
		 pu.setStudent_name(p.getStudent_name());
		 pu.setStudent_address(p.getStudent_address());
		 pu.setStudent_contact(p.getStudent_contact());
		 
	  return  cacheService.save(pu);
	 }
	 @DeleteMapping("/del/{id}")
	 public String delete(@PathVariable ("id") int id) {
		 cacheService.del(id);
		return "deleted successfully"; 
	 }

}

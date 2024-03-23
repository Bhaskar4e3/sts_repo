package com.example.caching;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CacheRepo extends JpaRepository<Pupil, Integer> {
	

}

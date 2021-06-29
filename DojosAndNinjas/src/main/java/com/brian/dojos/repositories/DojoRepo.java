package com.brian.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.brian.dojos.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long>{

	List<Dojo> findAll();
	
	List<Dojo> findByNameContaining(String search);
}

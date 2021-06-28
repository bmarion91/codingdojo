package com.brian.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brian.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	List<Language> findAll();
	
	List<Language> findByNameContaining(String search);
	
	Long countByCreatorContaining(String search);
	
	Long deleteByCreatorStartingWith(String search);
}

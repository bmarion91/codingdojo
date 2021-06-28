package com.brian.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brian.languages.models.Language;
import com.brian.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public List<Language> allLanguages() {
		return languageRepo.findAll();
	}
	public Language createLanguage (Language l) {
		return languageRepo.save(l);
	}
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	public Language updateLanguage(Language language) {
		//Language l = findLanguage(id);
//		l.setName(language.getName());
//		l.setCreator(language.getCreator());
//		l.setCurrentVersion(language.getCurrentVersion());
		return languageRepo.save(language);
	}
	public void deleteLanguage(Long id) {
		Language language = findLanguage(id);
		languageRepo.delete(language);
	}
}

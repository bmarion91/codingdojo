package com.brian.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brian.languages.models.Language;
import com.brian.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	@RequestMapping("/languages")
	public String index(Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		model.addAttribute("language", new Language());
		return "/languages/index.jsp";
	}
	
	@RequestMapping(value="/languages/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	
	@RequestMapping("/languages/{id}/edit")
	public String update(@PathVariable("id") Long id, @ModelAttribute("language") Language language, Model model) {
//		if (result.hasErrors()) {
//			return "/languages/edit.jsp";
//		} else {
//			languageService.updateLanguage(language);
//			return "redirect:/languages";
//		}
		Language lang = languageService.findLanguage(id);
		model.addAttribute("lang", lang);
		return "/languages/edit.jsp";
	}
	@RequestMapping(value="/languages/{id}/update", method=RequestMethod.POST)
	public String applyUpdate(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/edit.jsp";
		} else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	@GetMapping("/languages/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
	languageService.deleteLanguage(id);
	return "redirect:/languages";
	}
}

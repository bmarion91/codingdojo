package com.brian.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brian.dojos.models.Dojo;
import com.brian.dojos.models.Ninja;
import com.brian.dojos.services.DojoService;
import com.brian.dojos.services.NinjaService;
@Controller
public class DojosController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojosController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	@RequestMapping("/dojos/new")
	public String index(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		model.addAttribute("dojo", new Dojo());
		return "dojos.jsp";
	}
	
	
	@RequestMapping(value="/dojos/create", method=RequestMethod.POST)
		public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "dojos.jsp";
		}else {
		dojoService.createDojo(dojo);
		List<Dojo> dojos = dojoService.allDojos();
		Long lastDojoId = dojos.get(dojos.size()-1).getId();
		return "redirect:/dojos/"+ lastDojoId;
		}
	}
	@RequestMapping("/dojos/{id}")
	 	public String showDojo(@PathVariable("id") Long id, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
			Dojo thisDojo = dojoService.findDojo(id);
			List<Ninja> ninjas = ninjaService.allNinjas();
			model.addAttribute("dojo", thisDojo);
			model.addAttribute("ninjas", ninjas);
			return "dojodetails.jsp";
	}
	@RequestMapping("/ninjas/new")
	public String makeANinja(Model model) {
		List<Ninja> ninjas = ninjaService.allNinjas();
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("dojos", dojos);
		return "ninjas.jsp";
	}
	@RequestMapping(value="/ninjas/create", method=RequestMethod.POST)
		public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "ninjas.jsp";
		} else {
			ninjaService.createNinja(ninja);
//			List<Ninja> ninjas = ninjaService.allNinjas();
//			List<Dojo> dojos = dojoService.allDojos();
//			Dojo newestNinjaDojo = ninjas.get(ninjas.size()-1).getDojo();
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
}

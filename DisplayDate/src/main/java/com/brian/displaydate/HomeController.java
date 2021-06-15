package com.brian.displaydate;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String datePage(Model model) {
		model.addAttribute("date", new Date());
		return "datePage.jsp";
	}
	@RequestMapping("/time")
	public String timePage(Model model) {
		model.addAttribute("time", new Date());
		return "timePage.jsp";
	}
}

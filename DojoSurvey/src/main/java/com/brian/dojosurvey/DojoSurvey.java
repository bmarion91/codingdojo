package com.brian.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DojoSurvey {
	@RequestMapping("/")
	public String index() {
		return "formDisplay.jsp";
	}
	@RequestMapping(value="/result", method=RequestMethod.POST)
	String result(@RequestParam(value="fullName") String fullName,@RequestParam(value="dojoLocation") String dojoLocation, 	@RequestParam(value="favLanguage") String favLanguage, @RequestParam(value="comments", required=false) String comments, HttpSession session) {
		session.setAttribute("fullName", fullName);
		session.setAttribute("dojoLocation", dojoLocation);
		session.setAttribute("favLanguage", favLanguage);
		session.setAttribute("comments", comments);
		return "redirect:/resultDisplay";
	}
	@RequestMapping("/resultDisplay")
	public String display() {
		return "formResult.jsp";
	}
}

package com.brian.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class homeController {
	@RequestMapping("/")
	public String index(@ModelAttribute("errors") String errors, Model model) {
		model.addAttribute("errors",errors);
		return "index.jsp";
	}
	@PostMapping(path="/code")
 String success(@RequestParam(value="codeSubmission")String codeSubmission, RedirectAttributes redirectAttributes) {
		if(codeSubmission.equals("bushido")) {
			return "code.jsp";
		}else {
			redirectAttributes.addFlashAttribute("errors", "You must train harder!");
			return "redirect:/";
		}
	}
}

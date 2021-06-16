package com.brian.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
	@RequestMapping("/my_server")
	public String index(HttpSession session){
        if(session.getAttribute("count") == null) {
        	session.setAttribute("count", 0);
        }
        Integer count = (Integer) session.getAttribute("count");
        session.setAttribute("count", count+1);

        return "index.jsp";
	}
	@RequestMapping("/my_server/counter")
	public String counter(HttpSession session) {
		return "counter.jsp";
	}
}

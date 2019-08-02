package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAction {
	@RequestMapping(value="/aaaa")
	public String hello(){
		System.out.println("helloAction");
		return "welcome";
	}
	
}

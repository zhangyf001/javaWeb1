package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="hello2")
public class HelloActionTwo {
	@RequestMapping(value="/a")
	public String zzzz(HttpServletRequest request){
		System.out.println(request.getAttribute("b2"));
		 return "two";
	}

}

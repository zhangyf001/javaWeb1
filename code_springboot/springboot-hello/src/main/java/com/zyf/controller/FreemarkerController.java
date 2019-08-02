package com.zyf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/free")
public class FreemarkerController {
	@RequestMapping("/say")
	public ModelAndView aa(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","springboot你好");
		modelAndView.setViewName("hello");
		return modelAndView;
	}
}

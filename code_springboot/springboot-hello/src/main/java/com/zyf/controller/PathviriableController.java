package com.zyf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/path")
public class PathviriableController {
	
	@RequestMapping("/{id}")
	public ModelAndView aa(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id",id);
		modelAndView.setViewName("path");	
		return modelAndView;
	}
	
	@RequestMapping("/query")
	public ModelAndView bb(@RequestParam(value="q")String q){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("q",q);
		modelAndView.setViewName("path");	
		return modelAndView;
	}
}

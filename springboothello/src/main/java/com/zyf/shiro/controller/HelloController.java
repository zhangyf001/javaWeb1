package com.zyf.shiro.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
	@RequestMapping("/hello")
	@ResponseBody
	public Map<String,Object> aa(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "zansan");
		map.put("gender", "男");
		return map;
	}

}

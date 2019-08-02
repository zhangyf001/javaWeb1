package com.zyf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajax")
public class AjaxController {
	@RequestMapping("/hello")
	public String aa(){
		return"{'msg1':'aaa','msg2':'bbb'}";
	}
}

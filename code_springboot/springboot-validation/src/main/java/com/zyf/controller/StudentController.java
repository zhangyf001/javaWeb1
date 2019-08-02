package com.zyf.controller;


import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyf.entity.Student;
import com.zyf.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {

	@Resource
	private StudentService studentService;
	

	@RequestMapping("/add")
	public String add(@Valid Student student,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return bindingResult.getFieldError().getDefaultMessage();
		}else{
			studentService.add(student);
			return "添加成功";
		}
	}
}

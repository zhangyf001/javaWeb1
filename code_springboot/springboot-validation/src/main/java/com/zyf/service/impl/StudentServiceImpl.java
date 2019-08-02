package com.zyf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zyf.dao.StudentDao;
import com.zyf.entity.Student;
import com.zyf.service.StudentService;

@Service("studentServie")
public class StudentServiceImpl implements StudentService {
	
	@Resource
	private StudentDao studentDao;
	
	public void add(Student student) {
		studentDao.save(student);
	}

}

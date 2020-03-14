package com.zyf.service;

import com.zyf.dao.StudentDao;
import com.zyf.entity.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by zhangyf on 2020-03-14 15:41
 */
@Service("studentService")
public class StudentService {
  @Resource
  private StudentDao studentDao;

  public void save(Student student) {
	studentDao.save(student);
  }

  public Student findById(Integer id) {
	return studentDao.findOne(id);
  }

  public List<Student> list() {
	return studentDao.findAll();
  }

  public void delete(Integer id) {
	studentDao.delete(id);
  }
}

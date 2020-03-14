package com.zyf.controller;

import com.zyf.entity.Student;
import com.zyf.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by zhangyf on 2020-03-14 15:43
 */
@RestController
@RequestMapping("/student")
public class StudentController {

  @Resource
  private StudentService studentService;

  /**
   * 添加或者修改学生信息
   * @param student
   * @return
   * 注：这里的RequestBody注解 是为了消费者调用时候能传参过来，不这么注解就传参不过来了
   */
  @PostMapping(value="/save")
  public boolean save(@RequestBody Student student){
	try{
	  studentService.save(student);
	  return true;
	}catch(Exception e){
	  return false;
	}
  }

  /**
   * 查询学生信息
   * @return
   */
  @GetMapping(value="/list")
  public List<Student> list(){
	return studentService.list();
  }

  /**
   * 根据id查询学生信息
   * @return
   */
  @GetMapping(value="/get/{id}")
  public Student get(@PathVariable("id") Integer id){
	return studentService.findById(id);
  }

  /**
   * 根据id删除学生信息
   * @return
   */
  @GetMapping(value="/delete/{id}")
  public boolean delete(@PathVariable("id") Integer id){
	try{
	  studentService.delete(id);
	  return true;
	}catch(Exception e){
	  return false;
	}
  }
}

package com.zyf.controller;

import com.zyf.entity.Student;
import com.zyf.service.StudentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 服务消费者-学生信息控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/student")
public class StudentConsumerController {

	/*@Resource
	private RestTemplate restTemplate;*/

	@Autowired
	private StudentClientService studentClientService;

	//private final static String PRE_HOST="http://localhost:1008";
	private final static String PRE_HOST="http://SPRINGCLUD-STUDENT";

	/**
     * 添加或者修改学生信息
     * @param student
     * @return
     */
    @PostMapping(value="/save")
    public boolean save(Student student){
//    	return restTemplate.postForObject(PRE_HOST+"/student/save", student, Boolean.class);
		return studentClientService.save(student);
    }
     
    /**
     * 查询学生信息
     * @return
     */
    @SuppressWarnings("unchecked")
	@GetMapping(value="/list")
    public List<Student> list(){
//        return restTemplate.getForObject(PRE_HOST+"/student/list", List.class);
		return studentClientService.list();
    }
     
    /**
     * 根据id查询学生信息
     * @return
     */
    @GetMapping(value="/get/{id}")
    public Student get(@PathVariable("id") Integer id){
//        return restTemplate.getForObject(PRE_HOST+"/student/get/"+id, Student.class);
		return studentClientService.get(id);
    }
     
    /**
     * 根据id删除学生信息
     * @return
     */
    @GetMapping(value="/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
//        return restTemplate.getForObject(PRE_HOST+"/student/delete/"+id, Boolean.class);
		return studentClientService.delete(id);
    }
	
}

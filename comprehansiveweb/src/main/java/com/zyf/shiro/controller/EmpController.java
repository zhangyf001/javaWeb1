package com.zyf.shiro.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyf.shiro.model.Employee;
import com.zyf.shiro.model.Type;
import com.zyf.shiro.service.EmployeeService;
import com.zyf.shiro.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("emp")
public class EmpController {
	
	@Resource
	private EmployeeService empService;
	@Resource
	private TypeService typeService;
	@RequestMapping("/emp_list")
	public String queryAllEmployee(Model model){
		List<Type> partList = typeService.queryByType("所在部门");
		List<Type> levelList = typeService.queryByType("员工级别");
		Map params = new HashMap();

		//	当前页、一页显示几条数据
		Page page = PageHelper.startPage(1,10);//使用pageHelper
		List<Employee> employeeList = empService.queryAllEmployee();

		/*System.out.println("当前页："+page.getPageNum());
		System.out.println("总记录："+page.getTotal());
		System.out.println("每页几条："+page.getPageSize());
		System.out.println("总页数："+page.getPages());*/

		//使用pageInfo
		PageInfo<Employee> pageInfo = new PageInfo<Employee>(employeeList,5);//这个5表示连续显示5页
		System.out.println("当前页："+pageInfo.getPageNum());
		System.out.println("总记录："+pageInfo.getTotal());
		System.out.println("每页几条："+pageInfo.getPageSize());
		System.out.println("总页数："+pageInfo.getPages());
		System.out.println("是否第一页："+pageInfo.isIsFirstPage());
		System.out.println("连续显示几页："+pageInfo.getNavigatepageNums().length);
		/*int[] nums = pageInfo.getNavigatepageNums();
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}*/
		model.addAttribute("partList", partList);
		model.addAttribute("levelList", levelList);

		params.put("pageNum",1);
		params.put("records",pageInfo.getPageSize());
		model.addAttribute("params", params);
		model.addAttribute("employeeList", pageInfo.getList());
//		model.addAttribute("pageNav", pageInfo.getNavigatepageNums());
		model.addAttribute("pageInfo",pageInfo);
		return "employee/employee_list";
	}


	@RequestMapping("queryList")
	public String queryEmployee(@RequestParam Map<String,Object> params,Model model){
		String name = (String)params.get("employeeName");
		List<Type> partList = typeService.queryByType("所在部门");
		List<Type> levelList = typeService.queryByType("员工级别");
		model.addAttribute("partList", partList);
		model.addAttribute("levelList", levelList);


		int pageNum = 0 ;
		if("".equals(params.get("pageNum"))){
			pageNum = 1;
		}else {
			pageNum = Integer.valueOf(params.get("pageNum").toString());
		}

		int records = Integer.valueOf(params.get("records").toString()) ;

		//当前页、一页显示几条数据
		PageHelper.startPage(pageNum,records);//分页
		List<Employee> employeeList = empService.queryByParams(params);

		PageInfo<Employee> pageInfo = new PageInfo<Employee>(employeeList,5);//这个5表示连续显示5页
		model.addAttribute("pageInfo",pageInfo);

		model.addAttribute("employeeList", employeeList);
		model.addAttribute("params",params);
		return "employee/employee_list";
	}

	/*@RequestMapping("queryList2")//表单提交传过来的分页实体类对象
	public String queryEmployee(Model model, QueryEmployee queryEmployee){
		List<Type> partList = typeBiz.queryTypeBytype("所在部门");
		List<Type> levelList = typeBiz.queryTypeBytype("员工级别");
		model.addAttribute("partList", partList);
		model.addAttribute("levelList", levelList);

		List<Employee> employeeList = employeeBiz.queryByquerEmployee(queryEmployee);
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("queryEmployee",queryEmployee);
		return "index";
	}*/
	/*@RequestMapping("delete")
	@ResponseBody
	public int deleteById(Integer employeeId){
		return employeeBiz.deleteById(employeeId);
	}
	@RequestMapping("edit")
	@ResponseBody
	public Employee queryById(Integer employeeId){
		Employee employee = employeeBiz.queryById(employeeId);
		return employee;
	}*/
	/*@RequestMapping("update")
	@ResponseBody
	public int update(Employee employee){
		return employeeBiz.updateEmployee(employee);
	}*/
	@RequestMapping("/timer")
	@ResponseBody
	public List timer(){
		List<Type> levelList = typeService.queryByType("员工级别");
		return levelList;
	}
}

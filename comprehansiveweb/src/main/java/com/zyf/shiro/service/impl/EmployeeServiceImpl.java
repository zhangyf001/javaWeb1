package com.zyf.shiro.service.impl;

import com.zyf.shiro.dao.EmployeeMapper;
import com.zyf.shiro.model.Employee;
import com.zyf.shiro.model.QueryEmployee;
import com.zyf.shiro.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
	private EmployeeMapper employeeMapper;
	public List<Employee> queryAllEmployee() {
		
		return employeeMapper.queryAllEmployee();
	}
	public List<Employee> queryByquerEmployee(QueryEmployee queryEmployee) {
		int rows = queryEmployee.getRows();//每页几条,实体类中默认了2条
		int page = queryEmployee.getPage();//第几页,实体类默认了是第1页
		int counts = employeeMapper.queryCountsByQueryEmployee(queryEmployee);
		
		int pageCounts = counts % rows == 0 ? (counts / rows) : (counts / rows + 1);
		if(pageCounts==0){
			return null;
		}
		page = page < 1 ? 1 : page;
		page = page > pageCounts ? pageCounts : page;
		queryEmployee.setPage(page);
		queryEmployee.setPageCounts(pageCounts);
		queryEmployee.setStart((page - 1) * rows);// 第几条开始
		queryEmployee.setNext(page + 1);// 下一页
		queryEmployee.setLast(page - 1);// 上一页
		
		return employeeMapper.queryByQueryEmployee(queryEmployee);
	}


	public List<Employee> queryByParams(Map params){
		return employeeMapper.queryByParams(params);
	}
	public int deleteById(int id) {
		return employeeMapper.deleteById(id);
	}
	public Employee queryById(int id) {
		return employeeMapper.queryById(id);
	}
	public int updateEmployee(Employee employee) {
		return employeeMapper.updateEmployee(employee);
	}
	
	
	
}

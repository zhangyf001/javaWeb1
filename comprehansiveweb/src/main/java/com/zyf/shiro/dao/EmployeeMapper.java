package com.zyf.shiro.dao;

import com.zyf.shiro.model.Employee;
import com.zyf.shiro.model.QueryEmployee;

import java.util.List;
import java.util.Map;


public interface EmployeeMapper {
	//查询所有员工信息
	public List<Employee> queryAllEmployee();
	
	//根据查询条件对象分页查询员工信息
	public List<Employee>queryByQueryEmployee(QueryEmployee queryEmployee);

	public List<Employee>queryByParams(Map params);

	//根据查询条件对象查询员工信息总记录
	public int queryCountsByQueryEmployee(QueryEmployee queryEmployee);


	
	//根据ID查询员工信息
	public Employee queryById(int id);
	
	//根据id删除员工
	public int deleteById(int id);
	
	//修改员工
	public int updateEmployee(Employee employee);
	
}

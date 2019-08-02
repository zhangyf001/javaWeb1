package com.zyf.shiro.service;

import com.zyf.shiro.model.Employee;
import com.zyf.shiro.model.QueryEmployee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
	public List<Employee> queryAllEmployee();
	public List<Employee> queryByquerEmployee(QueryEmployee queryEmployee);
	public List<Employee> queryByParams(Map params);
	public int deleteById(int id);
	public Employee queryById(int id);
	public int updateEmployee(Employee employee);
}

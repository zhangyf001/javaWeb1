package com.zyf.shiro.model;

public class Employee {
	private int employeeId;
	private String employeeName;
	private Type employeePart;
	private Type employeeLevel;
	private String employeePhone;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Type getEmployeePart() {
		return employeePart;
	}
	public void setEmployeePart(Type employeePart) {
		this.employeePart = employeePart;
	}
	public Type getEmployeeLevel() {
		return employeeLevel;
	}
	public void setEmployeeLevel(Type employeeLevel) {
		this.employeeLevel = employeeLevel;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public Employee() {
		super();
	}
	
	
}

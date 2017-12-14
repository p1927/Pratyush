package com.cg.test.dto;

public class Employee {
	private int empId;
	private String empName;
	protected int empPf;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public void getData(){
		System.out.println("Welcome to Java");
	}
	
	
	
}

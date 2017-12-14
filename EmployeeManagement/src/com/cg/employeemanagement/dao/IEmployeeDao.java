package com.cg.employeemanagement.dao;

import java.util.List;

import com.cg.employeemanagement.dto.Employee;
import com.cg.employeemanagement.exception.EmployeeException;

public interface IEmployeeDao {
	
	public int addEmployee(Employee emp) throws EmployeeException;
	public List<Employee> showAllEmployee() throws EmployeeException;
	public Employee searchEmployee(int empId) throws EmployeeException;
	public int deleteEmployee(int empId) throws EmployeeException;
	
}

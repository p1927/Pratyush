package com.cg.employeemanagement.service;

import java.util.List;

import com.cg.employeemanagement.dto.Employee;
import com.cg.employeemanagement.exception.EmployeeException;

public interface IEmployeeService {
	public int addEmployee(Employee emp) throws EmployeeException;
	public List<Employee> showAllData() throws EmployeeException;
	public Employee searchEmployee(int empId) throws EmployeeException;
	public int deleteEmployee(int empId) throws EmployeeException;

}

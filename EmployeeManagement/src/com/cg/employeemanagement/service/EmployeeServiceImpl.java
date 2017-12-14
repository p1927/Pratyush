package com.cg.employeemanagement.service;

import java.util.List;
import java.util.regex.Pattern;

import com.cg.employeemanagement.dao.EmployeeDaoImpl;
import com.cg.employeemanagement.dao.IEmployeeDao;
import com.cg.employeemanagement.dto.Employee;
import com.cg.employeemanagement.exception.EmployeeException;

public class EmployeeServiceImpl implements IEmployeeService{

	
	//to call Dao interface from service implementation
	IEmployeeDao employeeDao= new EmployeeDaoImpl();
	
	@Override
	public int addEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		
		return employeeDao.addEmployee(emp);
		
	}

	@Override
	public List<Employee> showAllData() throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.showAllEmployee();
	}

	@Override
	public Employee searchEmployee(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.searchEmployee(empId);
	}

	@Override
	public int deleteEmployee(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployee(empId);
		
	}
	
	public static boolean validateName(String reg, String input) throws EmployeeException{
		boolean msg=false;
		
		msg=Pattern.matches(reg, input);
		
		if(!msg){
				throw new EmployeeException("Name is not in desired format...");
		}
		return msg;
	}
	public static boolean validateSalary(String reg, String input) throws EmployeeException{
		boolean msg=false;	
		msg=Pattern.matches(reg, input);		
		if(!msg){
				throw new EmployeeException("Salary is not in number format...");
		}
		return msg;
	}
	
}































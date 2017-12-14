package com.employeemanagement.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.employeemanagement.dao.EmployeeDaoImpl;
import com.cg.employeemanagement.dto.Employee;
import com.cg.employeemanagement.exception.EmployeeException;

public class EmployeeDaoTest {
	Employee emp;
	EmployeeDaoImpl emplDao;
	
	@Before 
	public void beforeTest(){
		emplDao = new EmployeeDaoImpl();
		emp = new Employee();
		emp.setEmpName("Adsdfs");
		emp.setEmpSalary(125.63);
		emp.setEmpDep("Java");
	}
	
	@Test
	public void addEmployeeTest() throws EmployeeException{
		assertEquals(1, emplDao.addEmployee(emp));
	}
}

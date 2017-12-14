package com.cg.employeemanagement.ui;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cg.employeemanagement.dao.EmployeeDaoImpl;
import com.cg.employeemanagement.dto.Employee;
import com.cg.employeemanagement.exception.EmployeeException;
import com.cg.employeemanagement.service.EmployeeServiceImpl;
import com.cg.employeemanagement.service.IEmployeeService;

public class MyApplication {
	public static void main(String[] args){
		//to call Service interface from service implementation
		IEmployeeService empService = new EmployeeServiceImpl();	
		
		int choice=0;
		
		do{
			printDetails();
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the Choice :");
			choice = in.nextInt();
			switch(choice){
			case 1://add
				
			//	int id=EmployeeDaoImpl.getEmployeeId();
			//	System.out.println("Enter data for Employee Id : "+id);
				String regName="[A-Z][a-z]{3,10}";
				
				System.out.println("Enter the Employee Name");
				String name=in.next();
				
				try {
					EmployeeServiceImpl.validateName(regName,name);
				} catch (EmployeeException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
					break;
				}
				
				
				String regSal="[0-9]{1,11}(\\.[0-9]{1,3})?";
				System.out.println("Enter the Employee Salary");
				String salary=in.next();
				try {
					EmployeeServiceImpl.validateSalary(regSal, salary);
				} catch (EmployeeException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
					break;
				}
				
				double sal= Double.parseDouble(salary);
				System.out.println("Enter the department");
				String dep=in.next();
				Employee emp= new Employee();
			//	emp.setEmpId(id);
				emp.setEmpDep(dep);
				emp.setEmpName(name);
				emp.setEmpSalary(sal);
				//service layer is calling
				int msg=0;
				try {
					msg = empService.addEmployee(emp);
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getMessage());
				}			
				
				if(msg==1)
					System.out.println("Data Added");
				else
					System.out.println("Data Not Added");
				
				break;
				
			case 2://show
				List<Employee> myData=null;
				try {
					myData = empService.showAllData();
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getMessage());
				} 
				
				for (Employee employee : myData) {
					System.out.println("__________________");
					System.out.println("Id is "+employee.getEmpId());
					System.out.println("Name is "+employee.getEmpName());
					System.out.println("Salary is "+employee.getEmpSalary());
					System.out.println("Department is "+employee.getEmpDep());
				}
				
				/*Using iterator
				 * 
				 * for (Iterator<Employee> iterator = myData.iterator(); iterator.hasNext();) {
					Employee employee = (Employee) iterator.next();
					System.out.println(employee.toString());
				}*/
				break;
			case 3://search
				
				System.out.println("Enter the employee Id");
				int eid=in.nextInt();
				Employee empSearch=null;
				try {
					empSearch = empService.searchEmployee(eid);
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getMessage());
					
				}
				if(empSearch!=null){
				System.out.println("__________________");
				System.out.println("Id is "+empSearch.getEmpId());
				System.out.println("Name is "+empSearch.getEmpName());
				System.out.println("Salary is "+empSearch.getEmpSalary());
				System.out.println("Department is "+empSearch.getEmpDep());
				}
				else
					System.out.println("Employee not present in the database");
				break;
				
			case 4://delete
				System.out.println("Enter the employee Id");
				int empid=in.nextInt();
				int status=0;
				try {
					status = empService.deleteEmployee(empid);
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getMessage());				
				}			
				if(status==1)
					System.out.println("Deletion done");
				else
					System.out.println("Employee not present.");
				
				break;
			case 5://exit
				System.out.println("Program terminated successfully.");
				System.exit(0);
				break;				
			}
			
		}
		while(choice!=5);

		
	}
	
	public static void printDetails(){
		System.out.println("________________");
		System.out.println("1. Add Employee");
		System.out.println("2. Show All");
		System.out.println("3. Search Employee");
		System.out.println("4. Delete Employee");
		System.out.println("5. Exit");
		System.out.println("________________");
		
	}
}

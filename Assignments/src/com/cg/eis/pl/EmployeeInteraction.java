package com.cg.eis.pl;

import java.util.Scanner;

import com.cg.eis.bean.EmployeeServices;


public class EmployeeInteraction {

	public static void main(String[] args) {
		//Creating Service for Employee
		EmployeeServices Service = new EmployeeServices();
		//Scanner to get input
		Scanner sc = new Scanner(System.in);
		String Name, Design;
		int Id, Sal;
		
		//Getting input from User
		System.out.println("Enter Employee Name: ");
		sc.reset();
		Name = sc.nextLine();
		System.out.println("Enter Employee Designation: ");
		Design = sc.nextLine();
		System.out.println("Enter Employee Id: ");
		Id = sc.nextInt();
		System.out.println("Enter Employee Salary: ");
		Sal = sc.nextInt();
		sc.close();
		
		//Calling service method to set Values of Employee
		Service.getEmployeeDetail(Id, Name, Design, Sal);
		
		//Calling Service method to find Insurance Scheme
		Service.findInsuranceScheme();
		
		//Calling Service method to display Employee details
		Service.showEmployeeDetails();
	}
}

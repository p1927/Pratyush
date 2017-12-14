package com.cg.eis.bean;

import com.cg.eis.services.Employee;

//Interface containing Services provided to Employee
interface Services {
	void findInsuranceScheme();

	void showEmployeeDetails();

	void getEmployeeDetail(int Id, String Name, String Design, int Sal);
}

//Employee Services implementing the service provided to Employee

public class EmployeeServices implements Services {
	
	//Creating a Employee with default constructor
	Employee emp = new Employee();

	
	//Overriding finInsuranceScheme of Services
	@Override
	public void findInsuranceScheme() {
		
		//Setting insurance scheme based on Salalry
		if (emp.getSalary() >= 100000) {
			emp.setInsuranceScheme("\nPlatinum Scheme\nMonthly Premium="
					+ emp.getSalary() * 0.02 + "\nInsurance Cover="
					+ emp.getSalary() * 100);
		} else if (emp.getSalary() >= 50000) {
			emp.setInsuranceScheme("\nGold Scheme\nMonthly Premium="
					+ emp.getSalary() * 0.02 + "\nInsurance Cover="
					+ emp.getSalary() * 100);
		} else if (emp.getSalary() >= 25000) {
			emp.setInsuranceScheme("\nSilver Scheme\nMonthly Premium="
					+ emp.getSalary() * 0.02 + "\nInsurance Cover="
					+ emp.getSalary() * 100);
		} else if (emp.getSalary() >= 10000) {
			emp.setInsuranceScheme("\nBronze Scheme\nMonthly Premium="
					+ emp.getSalary() * 0.02 + "\nInsurance Cover="
					+ emp.getSalary() * 100);
		} else if (emp.getSalary() >= 5000) {
			emp.setInsuranceScheme("\nIron Scheme\nMonthly Premium="
					+ emp.getSalary() * 0.02 + "\nInsurance Cover="
					+ emp.getSalary() * 100);
		} else
			emp.setInsuranceScheme("\nNot eligible for and Insurance as salary below 5000");

		

	}
	
	
	//Overriding showEmployeeDetails of Services


	@Override
	public void showEmployeeDetails() {
		
		//Calling Employee object toString method to print details of Employee

		System.out.println(emp.toString());
		

	}
	
	//Overriding getEmployeeDetail of Services

	@Override
	public void getEmployeeDetail(int id, String name, String design, int sal) {
		
		//Setting values o=to Employee atrributes
		emp.setId(id);
		emp.setName(name);
		emp.setDesignation(design);
		emp.setSalary(sal);
	}

}

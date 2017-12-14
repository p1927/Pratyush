package com.cg.eis.services;

public class Employee {

	public Employee() {
		
		
		
	}
	int id;
	String name;
	int salary;
	String designation;
	String insuranceScheme;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getInsuranceScheme() {
		return insuranceScheme;
	}
	public Employee(int id, String name, int salary, String designation,
			String insuranceScheme) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
		this.insuranceScheme = insuranceScheme;
	}
	@Override
	public String toString() {
		return "\nid=" + id + "\nname=" + name + "\nsalary=" + salary
				+ "\ndesignation=" + designation + "\ninsuranceScheme is :"
				+ insuranceScheme;
	}
	public void setInsuranceScheme(String insuranceScheme) {
		this.insuranceScheme = insuranceScheme;
	}

}

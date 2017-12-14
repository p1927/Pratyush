package Lab6;


import com.cg.eis.exception.EmployeeException;

class Employee {

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
	public void setSalary(int salary) throws EmployeeException {
		if(salary<3000){
			throw new EmployeeException("Salary can not be less than 3000");
		}
		else
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
			String insuranceScheme) throws EmployeeException {
		super();
		if(salary<3000){
			throw new EmployeeException("Salary can not be less than 3000");
		}
		else{
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
		this.insuranceScheme = insuranceScheme;}
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

public class Lab6_3 {

	public static void main(String[] args) {
		Employee emp = null;
		try {
			emp = new Employee(1223,"Chandan",50000,"S A", "Premium");
		} catch (EmployeeException e1) {
			
			System.out.println(e1.getMessage());
		}
		try {
			emp.setSalary(2000);
		} catch (EmployeeException e) {
			
			System.out.println(e.getMessage());
		}
		System.out.println(emp.toString());
	}

}

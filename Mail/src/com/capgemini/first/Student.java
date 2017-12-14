package com.capgemini.first;

enum Gender{
	M,F;
}
public class Student {

	private String name;
	private int id;
	private float fees;
	private String email;
	private Gender gender;
	
	public Student(){
		
	}

	public Student(String name, int id, float fees, String email) {
		this.name = name;
		this.id = id;
		this.fees = fees;
		this.email = email;
	}
	
	public void display(Student s){
		System.out.println(s.hashCode());
		System.out.println(s.getClass());
		System.out.println(s.getEmail());
		System.out.println(s.getFees());
		System.out.println(s.getName());
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

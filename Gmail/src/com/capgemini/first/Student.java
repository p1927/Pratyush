package com.capgemini.first;

public class Student {

	private String nameOfStu;
	private int id;
	private float fees;
	private String email;
	
	public Student(){
		
	}
	
	public Student(String name, int id, float fees, String email) {
		this.nameOfStu = name;
		this.id = id;
		this.fees = fees;
		this.email = email;
	}
	
	
	public String getName() {
		return nameOfStu;
	}
	public void setName(String name) {
		this.nameOfStu = name;
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

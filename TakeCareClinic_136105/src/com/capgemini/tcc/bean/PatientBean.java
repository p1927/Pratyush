package com.capgemini.tcc.bean;

import java.sql.Date;

public class PatientBean {
	private int patientId;
	private String name;
	private int age;
	private String phone;
	private String desc;
	private Date date;
	
	public PatientBean() {
		// TODO Auto-generated constructor stub
	}
	
	public PatientBean(int patientId, String name, int age, String phone,
			String desc, Date date) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.desc = desc;
		this.date = date;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PatientBean [patientId=" + patientId + ", name=" + name
				+ ", age=" + age + ", phone=" + phone + ", desc=" + desc
				+ ", date=" + date + "]";
	}
	
	
	
	
}

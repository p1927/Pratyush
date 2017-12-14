package com.capgemini.first;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student studentObj = new Student();
	/*	
		System.out.println(studentObj.email);
		System.out.println(studentObj.fees);
		System.out.println(studentObj.name);

		studentObj.email = "ajeet@gmail.com";
		studentObj.fees = 12345.56f;
		studentObj.name = "Ajeet";
		int hashCode=studentObj.hashCode();
		
		System.out.println(hashCode);
		System.out.println(studentObj.email);
		System.out.println(studentObj.fees);
		System.out.println(studentObj.name);
	*/
		
		System.out.println(studentObj.getEmail());
		System.out.println(studentObj.getFees());
		System.out.println(studentObj.getName());
		
		studentObj.setEmail("ajeet@gmail.com");
		studentObj.setFees(12345.56f);
		studentObj.setName("Ajeet");
		
		System.out.println(studentObj.getEmail());
		System.out.println(studentObj.getFees());
		System.out.println(studentObj.getName());
		
		Student studObj= new Student("raju",123,1234.54f,"raju@mail.com");
		System.out.println(studObj.getEmail());
		System.out.println(studObj.getFees());
		System.out.println(studObj.getName());
	}
	
}

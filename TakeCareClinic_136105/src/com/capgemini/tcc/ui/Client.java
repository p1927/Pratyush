package com.capgemini.tcc.ui;

import java.util.Scanner;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;
import com.capgemini.tcc.service.IPatientService;
import com.capgemini.tcc.service.PatientService;

public class Client {
	
	static IPatientService patientSer = new PatientService();
 	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice=0;
		Scanner in = null;
		do{
			displayMenu();
			in = new Scanner(System.in);
			
			System.out.print("Enter the choice: ");
			choice = Integer.parseInt(in.next());
			
			switch(choice){
			case 1://add Patient
				
				System.out.println("Enter Patient Details: ");
				
				System.out.print("Enter the name of the Patient: ");
				String name=in.nextLine();
				name += in.nextLine();
				//validateName
				try {
					PatientService.validateName(name);
				} catch (PatientException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
					break;
				}
				
				
				System.out.print("Enter Patient Age: ");
				String ageString=in.next();
				//validateAge
				try {
					PatientService.validateAge(ageString);
				} catch (PatientException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
					break;
				}
				int age = Integer.parseInt(ageString);
				
				System.out.print("Enter Patient phone number: ");
				String phone=in.next();
				//validatePhone
				try {
					PatientService.validatePhone(phone);
				} catch (PatientException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
					break;

				}

				System.out.print("Enter Description: ");
				String desc=in.nextLine();
				desc += in.nextLine();
				//validate Description
				try {
					PatientService.validateDesc(desc);
				} catch (PatientException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
					break;
				}

				//create a patient object and set values
				PatientBean patient = new PatientBean();
				patient.setName(name);
				patient.setAge(age);
				patient.setPhone(phone);
				patient.setDesc(desc);	
				
				
				//add Patient to database and generate patient Id
				int patientId = 0;
				try {
					patientId = patientSer.addPatientDetails(patient);
				} catch (PatientException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getMessage());
					break;
				}
				
				if(patientId==0)
					System.out.println("Patient Data not added.");
				else
					System.out.println("Patient Information stored successfully for " + patientId+".");				
				break;
				
			case 2://search Patient
				System.out.print("Enter the Patient Id: ");	
				int searchId=in.nextInt();
				
				PatientBean searchPatient = null;
				try {
					searchPatient = patientSer.getPatientDetails(searchId);
				} catch (PatientException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getMessage());
				}
				
				if(searchPatient!=null){
					System.out.println("__________________");
					System.out.println("Name of the Patient: "+searchPatient.getName());
					System.out.println("Age: "+searchPatient.getAge());
					System.out.println("Phone Number: "+searchPatient.getPhone());
					System.out.println("Description: "+searchPatient.getDesc());
					System.out.println("Consultation Date: "+searchPatient.getDate());
					System.out.println("__________________");
					}
				else
					System.out.println("There is no patient with this ID");					
				break;
				
			case 3://exit Program
				System.out.println("Program terminated successfully.");
				in.close();	//closing the Scanner resource
				System.exit(0);
				break;		
			}	
		}
		while(choice != 3);
	}

	public static void displayMenu(){
		System.out.println("____________________");
		System.out.println("1. Add Patient Information");
		System.out.println("2. Search Patient by Id");
		System.out.println("3. Exit");
		System.out.println("____________________");
	}
}

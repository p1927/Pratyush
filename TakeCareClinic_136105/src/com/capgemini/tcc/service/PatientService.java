package com.capgemini.tcc.service;

import java.util.regex.Pattern;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.IPatientDAO;
import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.PatientException;

public class PatientService implements IPatientService {
	
	
	IPatientDAO patientDao = new PatientDAO();

	//------------------------ 1. TakeCareClinic_136105 --------------------------
			/*******************************************************************************************************
			 - Function Name	:	addPatientDetails(PatientBean patient)
			 - Input Parameters	:	PatientBean patient
			 - Return Type		:	int
			 - Throws			:  	PatientException
			 - Author			:	Ajeet Pandey
			 - Creation Date	:	26/09/2017
			 - Description		:	Adding Patient
			 ********************************************************************************************************/
	@Override
	public int addPatientDetails(PatientBean patient) throws PatientException {
		// TODO Auto-generated method stub
		return patientDao.addPatientDetails(patient);
	}

	//------------------------ 1. TakeCareClinic_136105 --------------------------
	/*******************************************************************************************************
	 - Function Name	:	getPatientDetails(int patientId)
	 - Input Parameters	:	int patientId
	 - Return Type		:	PatientBean
	 - Throws			:  	PatientException
	 - Author			:	Ajeet Pandey
	 - Creation Date	:	26/09/2017
	 - Description		:	Searching Patient by Id
	 ********************************************************************************************************/
	@Override
	public PatientBean getPatientDetails(int patientId) throws PatientException {
		// TODO Auto-generated method stub
		return patientDao.getPatientDetails(patientId);
	}
	
	
	//------------------------ 1. TakeCareClinic_136105 --------------------------
		/*******************************************************************************************************
		 - Function Name	:	validateName(String name)
		 - Input Parameters	:	String name
		 - Return Type		:	void
		 - Throws			:  	PatientException
		 - Author			:	Ajeet Pandey
		 - Creation Date	:	26/09/2017
		 - Description		:	validate name format.
		 ********************************************************************************************************/
	public static void validateName(String name) throws PatientException{
		boolean status=false;
		String pattern="[A-Z][a-zA-Z ]{0,20}";
		status=Pattern.matches(pattern, name);
		if(!status){
			throw new PatientException("Name should start with uppercase...");
		}	
	}
	
	
	//------------------------ 1. TakeCareClinic_136105 --------------------------
		/*******************************************************************************************************
		 - Function Name	:	validateAge(String age)
		 - Input Parameters	:	String age
		 - Return Type		:	void
		 - Throws			:  	PatientException
		 - Author			:	Ajeet Pandey
		 - Creation Date	:	26/09/2017
		 - Description		:	validate age.
		 ********************************************************************************************************/
	public static void validateAge(String age) throws PatientException{
		boolean status=false;
		String pattern="[0-9]{1,3}";
		status=Pattern.matches(pattern,age);
		if(!status){
			throw new PatientException("Age should be of 3 digits...");
		}	
				
	}
	
	//------------------------ 1. TakeCareClinic_136105 --------------------------
	/*******************************************************************************************************
	 - Function Name	:	validatePhone(String phone)
	 - Input Parameters	:	String phone
	 - Return Type		:	void
	 - Throws			:  	PatientException
	 - Author			:	Ajeet Pandey
	 - Creation Date	:	26/09/2017
	 - Description		:	validate phone no.
	 ********************************************************************************************************/
	public static void validatePhone(String phone) throws PatientException{
		boolean status=false;
		String pattern="[0-9]{10}";
		status=Pattern.matches(pattern, phone);
		if(!status){
			throw new PatientException("Phone must have 10 digits...");
		}		
	}
	
	//------------------------ 1. TakeCareClinic_136105 --------------------------
	/*******************************************************************************************************
	 - Function Name	:	validateDesc(String desc)
	 - Input Parameters	:	String desc
	 - Return Type		:	void
	 - Throws			:  	PatientException
	 - Author			:	Ajeet Pandey
	 - Creation Date	:	26/09/2017
	 - Description		:	validate description length.
	 ********************************************************************************************************/
	public static void validateDesc(String desc) throws PatientException{
		boolean status=false;
		String pattern="[A-Za-z0-9//.@,]?[a-zA-Z0-9//.@, ]{0,80}";
		status=Pattern.matches(pattern, desc);
		if(!status){
			throw new PatientException("Description cannot exceed 80 characters...");
		}		
	}
	
}

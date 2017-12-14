package com.capgemini.tcc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.PatientException;

public class InsertPatientTest {
	PatientBean patient=null;
	PatientDAO patientDao = null;

	/************************************
	 * Before test to create and set values to the object
	 * 
	 ************************************/
	@Before
	public void beforeTest(){
		patient = new PatientBean();
		patientDao = new PatientDAO();
		
		patient.setName("Ajfg");
		patient.setAge(21);
		patient.setPhone("7412741258");
		patient.setDesc("Suffering from fever");		
		
	}
	
	/************************************
	 * Test case for addPatientDetails()
	 * 
	 ************************************/
	@Test
	public void test() {
		try {
			assertEquals(true, patientDao.addPatientDetails(patient) != 0);
		} catch (PatientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/************************************
	 * After test to delete references to the object
	 * 
	 ************************************/
	@After
	public void afterTest(){
		patient=null;
		patientDao = null;
	}

}

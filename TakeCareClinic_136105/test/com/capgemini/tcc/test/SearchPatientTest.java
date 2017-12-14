package com.capgemini.tcc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.PatientException;

public class SearchPatientTest {
	
	PatientBean patient=null;
	PatientDAO patientDao = null;
	int searchId=0;
	
	/************************************
	 * Before test to create and set values to the object
	 * 
	 ************************************/
	@Before
	public void beforeTest(){
		searchId=1002;
		patient = new PatientBean();
		patientDao = new PatientDAO();
	}
	
	/************************************
	 * Test case for getPatientDetails()
	 * 
	 ************************************/
	@Test
	public void test() {
		try {
			assertNotNull(patientDao.getPatientDetails(searchId));
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

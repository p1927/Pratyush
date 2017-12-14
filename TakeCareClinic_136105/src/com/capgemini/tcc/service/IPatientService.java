package com.capgemini.tcc.service;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;

public interface IPatientService {
	int addPatientDetails(PatientBean patient) throws PatientException;
	PatientBean getPatientDetails(int patientId) throws PatientException;
}

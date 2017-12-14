package com.capgemini.tcc.dao;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;

public interface IPatientDAO {
	int addPatientDetails (PatientBean patient) throws PatientException;
	PatientBean getPatientDetails(int patientId) throws PatientException;
}

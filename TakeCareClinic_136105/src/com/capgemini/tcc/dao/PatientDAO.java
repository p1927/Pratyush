package com.capgemini.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.PatientException;
import com.capgemini.tcc.util.DbUtil;

public class PatientDAO implements IPatientDAO{
	static Connection con;
	
	
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
		
		int status=0;
		int patientId=0;
		
		Logger myLogger=Logger.getLogger(DbUtil.class);
		PropertyConfigurator.configure("resources/log4j.properties"); 
		
		patientId=getPatientId();	
		
		//set Auto Generate Id to patient object
		patient.setPatientId(patientId);
		
		//insert functionality
		try {
			con = DbUtil.getConnection();	
		
			//Inserting consultation date as current date
			String query = "INSERT INTO Patient values(?,?,?,?,?,sysdate)";	
			
			PreparedStatement pstm =con.prepareStatement(query);
			pstm.setInt(1, patient.getPatientId());
			pstm.setString(2, patient.getName());
			pstm.setInt(3, patient.getAge());
			pstm.setString(4, patient.getPhone());
			pstm.setString(5,patient.getDesc());
			
			status = pstm.executeUpdate();
			
			myLogger.info("Data for Patient Id: "+patient.getPatientId()+" is inserted...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			myLogger.error(e.getMessage());
			throw new PatientException("Insertion not happen...");
		}	
		finally{
			if(con!=null){
				try {
					con.close();
					myLogger.info("Connection with database closed");
				} catch (SQLException se){
					// TODO Auto-generated catch block
					//se.printStackTrace();
					myLogger.warn(se.getMessage());
				}
			}
		}	
		
		//return PatientId if insertion happens, else return 0
		if(status==1)
			return patientId;
		else
			return status;	
	}

	//------------------------ 1. TakeCareClinic_136105 --------------------------
			/*******************************************************************************************************
			 - Function Name	:	getPatientDetails(int patientId)
			 - Input Parameters	:	int patientId
			 - Return Type		:	PatientBean
			 - Throws			:  	PatientException
			 - Author			:	Ajeet Pandey
			 - Creation Date	:	26/09/2017
			 - Description		:	Search Patient by Id
			 ********************************************************************************************************/
		
	@Override
	public PatientBean getPatientDetails(int patientId) throws PatientException {
		// TODO Auto-generated method stub
		PatientBean patient = null;
		Logger myLogger=Logger.getLogger(DbUtil.class);
		PropertyConfigurator.configure("resources/log4j.properties"); 
		
		//search
		
		try {
			con=DbUtil.getConnection();
			String query = "Select patient_id,patient_name,age,phone,description,consultation_date from Patient where patient_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, patientId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				patient = new PatientBean();
				patient.setPatientId(rs.getInt("patient_id"));
				patient.setName(rs.getString("patient_name"));
				patient.setAge(rs.getInt("age"));
				patient.setPhone(rs.getString("phone"));
				patient.setDesc(rs.getString("description"));
				patient.setDate(rs.getDate("consultation_date"));
			}
			myLogger.info("Data is retrieved with search having Patient id = "+patientId+".");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			myLogger.error(e.getMessage()+"Not able to search data...");
			throw new PatientException("Not able to search data...");
		}
		finally{
			if(con!=null){
				try {
					con.close();
					myLogger.info("Connection with database closed");
				} catch (SQLException se){
					// TODO Auto-generated catch block
					//se.printStackTrace();
					myLogger.warn(se.getMessage());
				}
			}
		}		
		return patient;
	}
	
	//------------------------ 1. TakeCareClinic_136105 --------------------------
	/*******************************************************************************************************
	 - Function Name	:	getPatientId()
	 - Input Parameters	:	
	 - Return Type		:	int
	 - Throws			:  	PatientException
	 - Author			:	Ajeet Pandey
	 - Creation Date	:	26/09/2017
	 - Description		:	Auto-Generate Id for new Patient.
	 ********************************************************************************************************/

	public static int getPatientId() throws PatientException{
		int id=0;
		
		Logger myLogger=Logger.getLogger(DbUtil.class);
		PropertyConfigurator.configure("resources/log4j.properties"); 
		
		try {
			con=DbUtil.getConnection();	
			String query="Select Patient_Id_Seq.NEXTVAL from dual";
			
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()){
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			myLogger.error(e.getMessage());
		}
		finally{
			if(con!=null){
				try {
					con.close();
					myLogger.info("Connection with database closed");
				} catch (SQLException se){
					// TODO Auto-generated catch block
					//se.printStackTrace();
					myLogger.warn(se.getMessage());
				}
			}
		}		
		if(id>0){
			myLogger.info("Patient Id generated is: "+id);
			return id;
		}
		else{
			myLogger.error("Id cannot be generated.");
			throw new PatientException("Id cannot be generated.");
		}		
	}
	

}

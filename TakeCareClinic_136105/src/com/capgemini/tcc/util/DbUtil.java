package com.capgemini.tcc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.tcc.exception.PatientException;

public class DbUtil {
	
	/*****************************************************************
	 *  - Method Name:getConnection() 
	 *  - Input Parameters : 
	 *  - Return Type :Connection
	 *  - Throws : PatientException 
	 *  - Author : Ajeet Pandey 
	 *  - Creation Date : 26/09/2017
	 *  - Description :  Returns connection object
	 *******************************************************************/
	
	public static Connection getConnection() throws PatientException{
		Connection conn=null;
		InputStream fileRead=null;
		
		Logger myLogger=Logger.getLogger(DbUtil.class);
		PropertyConfigurator.configure("resources/log4j.properties"); 
		
		try {
			fileRead = new FileInputStream("resources/oracle.properties");
			Properties prop = new Properties();
			prop.load(fileRead);
			
			String driver=prop.getProperty("oracle.driver");
			String url=prop.getProperty("oracle.url");
			String uname=prop.getProperty("oracle.username");
			String pass=prop.getProperty("oracle.password");
			
			Class.forName(driver);  //load driver
			conn = DriverManager.getConnection(url, uname, pass);  //create connection
			
			myLogger.info("Connection established...");			
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			myLogger.error("Error in connection:" +e.getMessage());
			throw new PatientException("Error in connection  establishment. Try again.");
		}
		return conn;
		
	}
}

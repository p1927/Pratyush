package com.cg.employeemanagement.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.employeemanagement.exception.EmployeeException;

public class DbUtil {
	
	static Logger myLogger; 
	
	public static Connection getConnection() throws EmployeeException{
		Connection conn=null;
		InputStream fileRead=null;
		
		myLogger=Logger.getLogger(DbUtil.class);
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
			
			myLogger.info("Connection Establsihed ...");
			
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new EmployeeException("Connection is not established ...");
				
		}	
		
		
		return conn;
		
	}
}

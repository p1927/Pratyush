package com.cg.mobilesystem.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.mobilesystem.exception.PurchaseException;

public class DbUtil {
	public static Connection getConnection() throws PurchaseException{
		
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
			
			myLogger.info("Connection Establsihed ...");
			
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			myLogger.error("Connection is not established ...");
			throw new PurchaseException("Connection is not established ...");			
		}
		
		return conn;
		
	}
	
	
}

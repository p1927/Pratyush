package com.cg.airspacetelecomm.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.cg.airspacetelecomm.bean.UserBean;
import com.cg.airspacetelecomm.exception.AirSpaceException;
import com.cg.airspacetelecomm.util.DBConnection;



public class CSI {
	

	
	Connection con= null;
			
	
	public ArrayList<UserBean> get() throws AirSpaceException {
		// TODO Auto-generated method stub
	con=DBConnection.getConnection();
	String query = "SELECT * FROM UserDB";
	
	ArrayList <UserBean> uselist=new ArrayList<UserBean>();
      // create the java statement
      Statement st;
	try {
		st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
     		 while (rs.next())
     	      {
     	         UserBean user=new UserBean();
     	      	 user.setName(rs.getString("Fname"));
     	         user.setUserName(rs.getString("Username"));
     	         user.setPwd(rs.getString("Pass"));
     	         user.setMobileNo(rs.getString("Mbno"));
     	         uselist.add(user);
     	         /////////////////
     	         
     	    };
				
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return uselist;
	
}}
	
	
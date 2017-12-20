package com.cg.airspacetelecomm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.airspacetelecomm.bean.UserBean;
import com.cg.airspacetelecomm.exception.AirSpaceException;
import com.cg.airspacetelecomm.service.CSI;
import com.cg.airspacetelecomm.util.DBConnection;

public class CustomerDAOImpl implements CustomerDAO {

	//@Override
	public void addUser(UserBean user) throws AirSpaceException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement statement = null;
		con = DBConnection.getConnection();
		String query = "insert into UserDB VALUES(?,?,?,?,'750')";
		try {
			statement = con.prepareStatement(query);
			statement.setString(1, user.getName());
			statement.setString(2, user.getUserName());
			statement.setString(3, user.getPwd());
			statement.setString(4, user.getMobileNo());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AirSpaceException("Details Couldn't be added due to SQL Error : " + e.getMessage());
		}
		finally
		{
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new AirSpaceException("Connection could not be closed" + e.getMessage());
			}
			
		}

	}
	
	public void Adjustbill(UserBean user,int Balance) throws AirSpaceException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement statement = null;
		con = DBConnection.getConnection();
		String query = "update UserDB set BILL=? WHERE USERNAME=? AND PASS=?";
		try {
			statement = con.prepareStatement(query);
			statement.setString(1, String.valueOf(Balance));
			statement.setString(2, user.getUserName());
			statement.setString(3, user.getPwd());
			
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AirSpaceException("Details Couldn't be added due to SQL Error : " + e.getMessage());
		}
		finally
		{
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new AirSpaceException("Connection could not be closed" + e.getMessage());
			}
			
		}

	}
	////////////////////////////////////////////////////////////////////
	

	//////////////////////////////
	public int check(String un) throws AirSpaceException {
		// TODO Auto-generated method stub
		System.out.println("Insider ");
		System.out.println(un);
		CSI dataget = new CSI();
		
		ArrayList<UserBean> udata=dataget.fakeget();
		for(UserBean currbean : udata)
		{if (currbean.getUserName().equals(un))
			return 1;
		}
		
		
		return 0;
		/*Connection con = null;
	PreparedStatement statement = null;
	con = DBConnection.getConnection();
	String query = "SELECT USERNAME FROM UserDB WHERE USERNAME=?";
	try {
		statement = con.prepareStatement(query);
		statement.setString(1,un);
		System.out.println(statement);
		ResultSet rs = statement.executeQuery(query);
		
		if (!rs.next())
		{return 0;}
		else return 1;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new AirSpaceException("Details Couldn't be added due to SQL Error : " + e.getMessage());
	}
	finally
	{
		try {
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AirSpaceException("Connection could not be closed" + e.getMessage());
		}
		
	}
	
	
}
	*/
	

}}

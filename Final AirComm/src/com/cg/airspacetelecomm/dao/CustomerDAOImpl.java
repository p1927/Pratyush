package com.cg.airspacetelecomm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cg.airspacetelecomm.bean.UserBean;
import com.cg.airspacetelecomm.exception.AirSpaceException;
import com.cg.airspacetelecomm.util.DBConnection;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void addUser(UserBean user) throws AirSpaceException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement statement = null;
		con = DBConnection.getConnection();
		String query = "INSERT INTO UserDB VALUES(?,?,?,?)";
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

}

package com.cg.asts.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cg.asts.dto.UserBean;
import com.cg.asts.exception.AirSpaceException;
import com.cg.asts.util.DbUtil;

public class CustomerDaoImpl implements ICustomerDao{
	Connection con= null;
	@Override
	public void addUser(UserBean user) throws AirSpaceException {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			con=DbUtil.getConnection();
			String sql = "Insert into User values (?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getUserName());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getMobileNo());
			
			status = pstm.executeUpdate();
			if(status == 1){
				return;
			}
			else{
				throw new AirSpaceException("Not able to insert data");
			}
			
		} catch (AirSpaceException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AirSpaceException("System error");
		}
		finally{
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new AirSpaceException("Error in closing the connection");
				}
		}
		
	}
	
}

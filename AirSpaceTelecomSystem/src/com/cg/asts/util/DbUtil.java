package com.cg.asts.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.asts.exception.AirSpaceException;

public class DbUtil {
	public static Connection getConnection() throws AirSpaceException{
		DataSource ds = null;
		Connection con=null;
		try {
			InitialContext context= new InitialContext();
			ds=(DataSource) context.lookup("java:/jdbc/MyDs");
			con=ds.getConnection();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AirSpaceException("Error in Connection");			
		}
		return con;
	}
}

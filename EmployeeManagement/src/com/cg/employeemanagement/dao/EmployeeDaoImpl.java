package com.cg.employeemanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.employeemanagement.dto.Employee;
import com.cg.employeemanagement.exception.EmployeeException;
import com.cg.employeemanagement.util.DbUtil;

public class EmployeeDaoImpl implements IEmployeeDao {
	static Connection con;
	@Override	
	public int addEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		
		int status=0; //local
		int empId= getEmployeeId();
		
		Logger myLogger=Logger.getLogger(DbUtil.class);
		PropertyConfigurator.configure("resources/log4j.properties"); 
		
		
		try {
			con=DbUtil.getConnection();
			String query = "INSERT INTO emptwo VALUES(?,?,?,?)";
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setInt(1, empId);
			pstm.setString(2, emp.getEmpName());
			pstm.setDouble(3, emp.getEmpSalary());
			pstm.setString(4, emp.getEmpDep());

			status=pstm.executeUpdate();
			myLogger.info("Employee id inserted is "+empId);
			
		} catch (EmployeeException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			myLogger.error(e.getMessage()+"Data not inseting....");
			throw new EmployeeException("Insert not happen ...");
			
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		return status;
		
		
		
		
	}

	@Override
	public List<Employee> showAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employee> myList = new ArrayList<Employee>() ;
		try {
			con=DbUtil.getConnection();
			String query = "Select emp_id,emp_name,emp_sal,emp_dep from EMPTWO";
			PreparedStatement pstm=con.prepareStatement(query);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){				
				Employee e=new Employee();	
				e.setEmpId(rs.getInt("emp_id"));
				e.setEmpName(rs.getString("emp_name"));
				e.setEmpSalary(rs.getDouble("emp_sal"));
				e.setEmpDep(rs.getString("emp_id"));
				
				myList.add(e);				
			}
		} catch (EmployeeException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new EmployeeException("Unable to show Data ...");
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return myList;
	}

	@Override
	public Employee searchEmployee(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee e=null;
		try {
			con=DbUtil.getConnection();
			String query="Select emp_id,emp_name,emp_sal,emp_dep from EMPTWO where emp_id = ?";
			PreparedStatement pstm= con.prepareStatement(query);
			pstm.setInt(1,empId);			
			ResultSet rs=pstm.executeQuery();
			if(rs.next()){	
				e=new Employee();
				e.setEmpId(rs.getInt("emp_id"));
				e.setEmpName(rs.getString("emp_name"));
				e.setEmpSalary(rs.getDouble("emp_sal"));
				e.setEmpDep(rs.getString("emp_id"));
			} 
		}
		catch (EmployeeException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new EmployeeException("Employee not found");
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException se) {
					// TODO Auto-generated catch block
					se.printStackTrace();
				}
			}
		}		
		return e;
	}

	@Override
	public int deleteEmployee(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		int status=0; //local
		try {
			con=DbUtil.getConnection();
			String query = "DELETE FROM EMPTWO where emp_id=?";
			
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setInt(1,empId);
			status=pstm.executeUpdate();
			
		} catch (EmployeeException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new EmployeeException("Deletion not happen");				
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException se) {
					// TODO Auto-generated catch block
					se.printStackTrace();
				}
			}
		}	
		return status;
	}
	
	public static int getEmployeeId(){
		int empIdSeq=0;
		try {
			con=DbUtil.getConnection();
			String query="Select seq_emp_id.NEXTVAL from dual";
			
			PreparedStatement ps= con.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				empIdSeq = rs.getInt(1);
			}
			
			
		} catch (EmployeeException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			try {
				throw new EmployeeException("Not able to generate Id");
			} catch (EmployeeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException se){
					// TODO Auto-generated catch block
					se.printStackTrace();
				}
			}
		}	
		return  empIdSeq;
		
	}
	
	
}

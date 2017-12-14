package com.cg.mobilesystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.mobilesystem.dto.Mobile;
import com.cg.mobilesystem.dto.Purchase;
import com.cg.mobilesystem.exception.PurchaseException;
import com.cg.mobilesystem.util.DbUtil;

public class PurchaseDaoImpl implements IPurchaseDao{
	static Connection con;
	@Override
	public int addPurchase(Purchase purchase) throws PurchaseException{
		// TODO Auto-generated method stub	
		int status=0;
		int purchaseId = 0;
		int insertStatus=0;
		int updateStatus=0;
		
		Logger myLogger=Logger.getLogger(DbUtil.class);
		PropertyConfigurator.configure("resources/log4j.properties"); 
		
		String query;
		PreparedStatement pstm=null;
		
		//get Purchase Id from database
		purchaseId=getPurchaseId();
		purchase.setPurId(purchaseId);
		try {
			
			con = DbUtil.getConnection();	
			
			//check quantity from database			
			Mobile mob= new Mobile();
			query = "Select mobileid,name,price,quantity from Mobiles where MOBILEID=?";
			pstm = con.prepareStatement(query);
			pstm.setInt(1,purchase.getMobileId());
			ResultSet rs = pstm.executeQuery();	
			if(rs.next()){
				mob.setId(rs.getInt("mobileid"));
				mob.setQuantity(rs.getInt("quantity"));
				mob.setName(rs.getString("name"));
				mob.setPrice(rs.getInt("price"));
			}
			
			if(mob.getQuantity()>0){
				//insert data in purchase
				query = "INSERT INTO PurchaseDetails values(?,?,?,?,?,?)";
			
				pstm=con.prepareStatement(query);
			
				pstm.setInt(1, purchaseId);
				pstm.setString(2, purchase.getCusName());
				pstm.setString(3, purchase.geteMail());
				pstm.setLong(4, purchase.getPhone());
				pstm.setDate(5,purchase.getPurDate());
				pstm.setInt(6, purchase.getMobileId());
				insertStatus = pstm.executeUpdate();
			
				//update quantity on mobileId
			
				query = "Update Mobiles set QUANTITY=QUANTITY-1 where MOBILEID=?";
				pstm=con.prepareStatement(query);
				pstm.setInt(1, purchase.getMobileId());
				updateStatus = pstm.executeUpdate();
			}
			myLogger.info("Insertion done : "+purchase+ " || " + mob );
		} 
		catch (SQLException | PurchaseException e) {
			// TODO Auto-generated catch block
			
			//e.printStackTrace();	
			myLogger.error(e.getMessage()+"Data not inserting...");
			throw new PurchaseException("Purchase can't happen...");
		}
		finally{
			if(con!=null){
				try {
					
					con.close();
					myLogger.info("Connection with database closed");
				} catch (SQLException se){
					// TODO Auto-generated catch block
					//se.printStackTrace();		
					myLogger.error(se.getMessage());

				}
			}
		}
		
		// if both executed successfully set status 1	
		if(insertStatus==1 && updateStatus==1)
			status=purchaseId;
		
		return status;
	}

	@Override
	public List<Mobile> showAllMobiles() throws PurchaseException {
		// TODO Auto-generated method stub
		
		List<Mobile> myList = new ArrayList<Mobile>();
		
		
		Logger myLogger=Logger.getLogger(DbUtil.class);
		PropertyConfigurator.configure("resources/log4j.properties"); 
		
		
		try {
			con=DbUtil.getConnection();
			String query = "Select mobileid,name,price,quantity from MOBILES";
			PreparedStatement pstm=con.prepareStatement(query);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){	
				Mobile m =new Mobile();
				m.setId(rs.getInt("mobileid"));
				m.setQuantity(rs.getInt("quantity"));
				m.setName(rs.getString("name"));
				m.setPrice(rs.getInt("price"));
				myList.add(m);	
			}
			myLogger.info("All mobile data is retrieved.");
		} catch (PurchaseException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			myLogger.error(e.getMessage());
			throw new PurchaseException("Not able to retrieve data...");
		}
		finally{
			if(con!=null){
				try {
					con.close();
					myLogger.info("Connection with database closed");
				} catch (SQLException se){
					// TODO Auto-generated catch block
					//se.printStackTrace();
					myLogger.error(se.getMessage());

				}
			}
		}
		return myList;
	}

	@Override
	public int deleteMobile(int mobId) throws PurchaseException {
		// TODO Auto-generated method stub
		int status = 0;
		
		Logger myLogger=Logger.getLogger(DbUtil.class);
		PropertyConfigurator.configure("resources/log4j.properties"); 
		
		String query;
		PreparedStatement pstm=null;
		
		try {
			con =DbUtil.getConnection();
			query = "Delete from Mobiles where mobileid=?";
			pstm=con.prepareStatement(query);
			pstm.setInt(1,mobId);
			status = pstm.executeUpdate();
			
			myLogger.info("Mobile deleted having mobile Id :"+mobId);

		} catch (PurchaseException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			myLogger.error(e.getMessage());
			throw new PurchaseException("Deletion can't be happen...");
		}
		finally{
			if(con!=null){
				try {
					con.close();
					myLogger.info("Connection with database closed");
				} catch (SQLException se){
					// TODO Auto-generated catch block
					//se.printStackTrace();
					myLogger.error(se.getMessage());

				}
			}
		}
		return status;
	}

	@Override
	public List<Mobile> searchMobiles(int min,int max) throws PurchaseException {
		// TODO Auto-generated method stub
		List<Mobile> myList = new ArrayList<Mobile>();
		
		Logger myLogger=Logger.getLogger(DbUtil.class);
		PropertyConfigurator.configure("resources/log4j.properties"); 
		try {
			con=DbUtil.getConnection();
			String query = "Select mobileid,name,price,quantity from MOBILES where price between ? AND ?";
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setInt(1, min);
			pstm.setInt(2,max);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){	
				Mobile m =new Mobile();
				m.setId(rs.getInt("mobileid"));
				m.setQuantity(rs.getInt("quantity"));
				m.setName(rs.getString("name"));
				m.setPrice(rs.getInt("price"));
				myList.add(m);	
			}
			myLogger.info("Data is retrieved with search having minimum = "+ min +" and maximum = "+max);
		} catch (PurchaseException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			myLogger.error(e.getMessage());
			throw new PurchaseException("Not able to search data...");
		}
		finally{
			if(con!=null){
				try {
					con.close();
					myLogger.info("Connection with database closed");
				} catch (SQLException se){
					// TODO Auto-generated catch block
					//se.printStackTrace();
					myLogger.error(se.getMessage());

				}
			}
		}
		return myList;
	}
	
	public static int getPurchaseId() throws PurchaseException{
		
		int purId=0;
		
		Logger myLogger=Logger.getLogger(DbUtil.class);
		PropertyConfigurator.configure("resources/log4j.properties"); 
		
		
		try {
			con=DbUtil.getConnection();	
			String query="Select seq_pur_id.NEXTVAL from dual";
			PreparedStatement ps;
			ps = con.prepareStatement(query);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				purId = rs.getInt(1);
			}
			
		} catch (SQLException | PurchaseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
				myLogger.error(e.getMessage());
				throw new PurchaseException("Not able to generate Id");
			
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
		return purId;
	}
	
	public static boolean getMobileId(int mobId) throws PurchaseException{ 
	//search whether mobile is present or not
		String query = "Select mobileid from Mobiles where MOBILEID=?";
		
		Logger myLogger=Logger.getLogger(DbUtil.class);
		PropertyConfigurator.configure("resources/log4j.properties"); 
		
		try {
			con=DbUtil.getConnection();
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1,mobId);		
			
			ResultSet rs = pstm.executeQuery();	
			if(rs.next()){
				return true;
			}	
			myLogger.info("Mobile with id : " +  mobId + " is found.");	
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
		return false;
	}
	
}

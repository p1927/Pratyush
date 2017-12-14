package com.cg.mobilesystem.test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.mobilesystem.dao.PurchaseDaoImpl;
import com.cg.mobilesystem.dto.Purchase;
import com.cg.mobilesystem.exception.PurchaseException;

public class InsertMobileTest {
	
	PurchaseDaoImpl purDaoImpl;
	Purchase purchase;
	
	@Before
	public void beforeTest(){
		purDaoImpl = new PurchaseDaoImpl();
		purchase = new Purchase();
		
		
		Date purDate =new Date(new java.util.Date().getTime());	
		
		purchase.setCusName("Ajeet");
		purchase.seteMail("pandey@r.com");
		purchase.setMobileId(1002);
		purchase.setPhone(1234567890);		
		purchase.setPurDate(purDate);		
	}
	
	@Test
	public void test() {
		try {
			int purId = purDaoImpl.addPurchase(purchase);
			
			assertEquals(true, purId>0);
			
		} catch (PurchaseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@After
	public void afterTest(){
		purDaoImpl =null;
		purchase = null;
	}

}

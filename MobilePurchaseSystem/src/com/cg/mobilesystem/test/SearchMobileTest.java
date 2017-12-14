package com.cg.mobilesystem.test;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.mobilesystem.dao.PurchaseDaoImpl;
import com.cg.mobilesystem.dto.Mobile;
import com.cg.mobilesystem.exception.PurchaseException;

public class SearchMobileTest {
	
	Mobile mobile;
	PurchaseDaoImpl purDaoImpl;
	int min;
	int max;
	
	@Before
	public void beforeTest(){
		mobile =new Mobile();
		purDaoImpl = new PurchaseDaoImpl();
		min=4000;
		max=12000;
	}
	
	@Test
	public void searchTest() {
		try {		
			assertNotNull(purDaoImpl.searchMobiles(min,max));
		} catch (PurchaseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@After
	public void afterTest(){
		mobile=null;
		purDaoImpl=null;
	}
	
}

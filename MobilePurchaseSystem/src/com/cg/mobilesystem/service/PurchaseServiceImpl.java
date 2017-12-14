package com.cg.mobilesystem.service;

import java.util.List;
import java.util.regex.Pattern;

import com.cg.mobilesystem.dao.IPurchaseDao;
import com.cg.mobilesystem.dao.PurchaseDaoImpl;
import com.cg.mobilesystem.dto.Mobile;
import com.cg.mobilesystem.dto.Purchase;
import com.cg.mobilesystem.exception.PurchaseException;

public class PurchaseServiceImpl implements IPurchaseService{

	static IPurchaseDao purDaoImpl = new PurchaseDaoImpl();
	
	@Override
	public int addPurchase(Purchase purchase) throws PurchaseException {
		// TODO Auto-generated method stub			
		return purDaoImpl.addPurchase(purchase);
	}

	@Override
	public List<Mobile> showAllMobiles() throws PurchaseException {
		// TODO Auto-generated method stub
		return purDaoImpl.showAllMobiles();
	}

	@Override
	public int deleteMobile(int mobId) throws PurchaseException {
		// TODO Auto-generated method stub
		return purDaoImpl.deleteMobile(mobId);
	}

	@Override
	public List<Mobile> searchMobiles(int min,int max) throws PurchaseException {
		// TODO Auto-generated method stub
		return purDaoImpl.searchMobiles(min,max);
	}

	public static void validateName(String input) throws PurchaseException{
		// TODO Auto-generated method stub
		boolean status=false;
		String pattern="[A-Z][a-zA-Z ]{0,20}";
		status=Pattern.matches(pattern, input);
		if(!status){
			throw new PurchaseException("Name is not in desired format...");
		}
	}

	public static void validateEMail(String input) throws PurchaseException {
		// TODO Auto-generated method stub
		boolean status=false;
		String pattern="\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		status=Pattern.matches(pattern, input);
		if(!status){
			throw new PurchaseException("Email is not valid...");
		}
			
		
	}

	public static void validatePhone(String input) throws PurchaseException {
		// TODO Auto-generated method stub
		boolean status=false;
		String pattern="[0-9]{10}";
		status=Pattern.matches(pattern, input);
		if(!status){
			throw new PurchaseException("Phone is not valid...");
		}
	}
	
	public static void validateMobileId(String input) throws PurchaseException {
		// TODO Auto-generated method stub
		
		int mobid=Integer.parseInt(input);
		boolean status=PurchaseDaoImpl.getMobileId(mobid);
		if(!status){
			throw new PurchaseException("Mobile Id is not valid...");
		}
	}

}

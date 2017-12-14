package com.cg.mobilesystem.service;

import java.util.List;

import com.cg.mobilesystem.dto.Mobile;
import com.cg.mobilesystem.dto.Purchase;
import com.cg.mobilesystem.exception.PurchaseException;

public interface IPurchaseService {
	public int addPurchase(Purchase purchase) throws PurchaseException;
	public List<Mobile> showAllMobiles() throws PurchaseException;
	public int deleteMobile(int mobId) throws PurchaseException;
	public List<Mobile> searchMobiles(int min , int max) throws PurchaseException;
}

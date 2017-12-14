package com.cg.asts.service;

import com.cg.asts.Dao.CustomerDaoImpl;
import com.cg.asts.Dao.ICustomerDao;
import com.cg.asts.dto.UserBean;
import com.cg.asts.exception.AirSpaceException;

public class CustomerServiceImpl implements ICustomerService{
	ICustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public void addUser(UserBean user) throws AirSpaceException {
		// TODO Auto-generated method stub
		customerDao.addUser(user);
	}
	
	
}

package com.cg.airspacetelecomm.service;

import com.cg.airspacetelecomm.bean.UserBean;
import com.cg.airspacetelecomm.dao.CustomerDAO;
import com.cg.airspacetelecomm.dao.CustomerDAOImpl;
import com.cg.airspacetelecomm.exception.AirSpaceException;

public class CustomerServiceImpl implements CustomerService {
	
	
	//------------------------ 1. Contact Book Service Application --------------------------
		/*****************************************************************************************************************
		 - Author			:	134161_Kanchi_Narasimha_Lokesh
		 - Function Name	:	addUser
		 - Input Parameters	:	UserBeab Object
		 - Return Type		:	void
		 - Throws			:  	AirSpaceException
		 - Creation Date	:	22/09/2017
		 - Description		:	adds user details to the users table by invoking dao addUser method.
		 ****************************************************************************************************************/


	@Override
	public void addUser(UserBean user) throws AirSpaceException {
		// TODO Auto-generated method stub
		CustomerDAO paydao = new CustomerDAOImpl();
		paydao.addUser(user);
	}

}

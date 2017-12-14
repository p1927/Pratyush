package com.cg.asts.service;

import com.cg.asts.dto.UserBean;
import com.cg.asts.exception.AirSpaceException;

public interface ICustomerService {
	public void addUser(UserBean user) throws AirSpaceException;

}

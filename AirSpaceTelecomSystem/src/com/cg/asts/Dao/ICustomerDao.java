package com.cg.asts.Dao;

import com.cg.asts.dto.UserBean;
import com.cg.asts.exception.AirSpaceException;

public interface ICustomerDao {
	public void addUser(UserBean user) throws AirSpaceException;
}

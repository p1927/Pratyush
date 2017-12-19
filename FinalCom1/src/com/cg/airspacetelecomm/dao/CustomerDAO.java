package com.cg.airspacetelecomm.dao;

import com.cg.airspacetelecomm.bean.UserBean;
import com.cg.airspacetelecomm.exception.AirSpaceException;

public interface CustomerDAO {
	public void addUser(UserBean user) throws AirSpaceException;
	

}

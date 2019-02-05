package com.cg.crs.dao;

import com.cg.crs.entity.UserRole;
import com.cg.crs.exception.CRSException;

public interface CRSDao {

	

	boolean validateFields(UserRole user) throws CRSException;

	boolean profileCreation(UserRole userProfile)throws CRSException;

}

package com.cg.crs.service;

import com.cg.crs.entity.UserRole;
import com.cg.crs.exception.CRSException;

public interface CRSService {
    
	boolean profileCreation(UserRole userProfile)throws CRSException;

	boolean validateFields(UserRole user) throws CRSException;

}

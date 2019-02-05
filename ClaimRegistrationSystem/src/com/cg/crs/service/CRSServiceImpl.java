package com.cg.crs.service;

import com.cg.crs.dao.CRSDao;
import com.cg.crs.dao.CRSDaoImpl;
import com.cg.crs.entity.UserRole;
import com.cg.crs.exception.CRSException;

public class CRSServiceImpl implements CRSService {
CRSDao crsDao=new CRSDaoImpl();

	@Override
	public boolean profileCreation(UserRole userProfile) throws CRSException {
		// TODO Auto-generated method stub
		return crsDao.profileCreation(userProfile);
	}

	@Override
	public boolean validateFields(UserRole user) throws CRSException {
		// TODO Auto-generated method stub
		return crsDao.validateFields(user);
	}

}

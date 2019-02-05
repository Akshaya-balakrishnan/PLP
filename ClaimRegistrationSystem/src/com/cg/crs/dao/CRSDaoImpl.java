package com.cg.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.crs.entity.UserRole;
import com.cg.crs.exception.CRSException;
import com.cg.crs.utility.JdbcUtility;

public class CRSDaoImpl implements CRSDao {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	

	@Override
	public boolean validateFields(UserRole user) throws CRSException {
		// TODO Auto-generated method stub
			List<UserRole> list = new ArrayList<>();
			connection = JdbcUtility.getConnection();
			boolean flag = false;
			try {
				statement = connection.prepareStatement(QueryMapper.checkUser);
				statement.setString(1, user.getUserName());
				statement.setString(2, user.getPassword());
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					String roleCode = resultSet.getString(1);
					user.setRoleCode(roleCode);
					list.add(user);
				}
				
				if (!list.isEmpty()) {
					flag = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CRSException("Not valid");
			}
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CRSException("Result set is not closed");

			}
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CRSException("Statement is not closed");

			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CRSException("Connection is not closed");

			}
			return flag;

	}



	@Override
	public boolean profileCreation(UserRole userProfile) throws CRSException {
		// TODO Auto-generated method stub
		connection = JdbcUtility.getConnection();
		boolean flag = false;
		int value=0;
		String userName="";
		try {
			statement = connection.prepareStatement(QueryMapper.userProfileCheck);
			statement.setString(1, userProfile.getUserName());
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
			userName = resultSet.getString(1);
			}
				if(!userProfile.getUserName().equals(userName))
				{
					statement = connection.prepareStatement(QueryMapper.userProfileCreation);
					statement.setString(1, userProfile.getUserName());
					statement.setString(2, userProfile.getPassword());
					statement.setString(3, userProfile.getRoleCode());
					value = statement.executeUpdate();
				}
         if(value!=0)
         {
        	 flag=true;
         }
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CRSException("Not valid");
		}
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CRSException("Result set is not closed");

		}
		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CRSException("Statement is not closed");

		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CRSException("Connection is not closed");

		}
		return flag;

		
	}

}


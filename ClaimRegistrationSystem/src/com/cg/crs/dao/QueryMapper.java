package com.cg.crs.dao;

public interface QueryMapper {
	String checkUser="select role_code from User_role where username=? and password=?";
    String userProfileCheck="select username from user_role where username=?";
	String userProfileCreation = "insert into user_role values(?,?,?)";
}

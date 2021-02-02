package com.app.dao;

import java.util.List;

import com.app.pojos.Users;

public interface IUserDao {

	List<Users> getalluserbydoctorid(int userId);
	public Users validateUser(String email, String pass);
}

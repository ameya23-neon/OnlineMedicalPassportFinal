package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Description;
import com.app.pojos.Users;

public interface IUserService {

	//list All Users
	List<Users> getAllUsers();

	
	//user Details by its name
	Optional<Users>findByFirstname(String uFirstName);

	//user Details by specified id
	
	Users getUserDetailsById(int userId);


     Users addUserDetails(Users u);
	
	
	List<Users>getAllusersbyid(int userId);
	
	String deleteUser(int userId);
	
	public Users validateUser(String email, String pass);
	
	 Users updateUsers(int userId, Users detachedPOJO);	

	 Description assignDescription (Description d);

}

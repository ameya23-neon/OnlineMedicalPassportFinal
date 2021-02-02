package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.dao.DescriptionRepository;
import com.app.dao.IUserDao;
import com.app.dao.UserRepository;
import com.app.pojos.Description;
import com.app.pojos.Users;

@Service
@Transactional
public class UserServicesImpl implements IUserService{
	
	  @Autowired 
	  private UserRepository userrepository;
	  
	  @Autowired
	  private DescriptionRepository descriptionrep;
	  @Autowired
	  private IUserDao dao;
	  
	  public UserServicesImpl() {
		System.out.println("in user services");
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userrepository.findAll();
	}

	@Override
	public Optional<Users> findByFirstname(String uFirstName) {
		// TODO Auto-generated method stub
		return userrepository.findByFirstname(uFirstName);
	}

	//get users By Id
	@Override
	public Users getUserDetailsById(int userId) {
		// TODO Auto-generated method stub
		System.out.println("in user service impl class"+userrepository.findById(userId));
		Optional<Users>optionalUser=userrepository.findById(userId);
		if(optionalUser.isPresent())
			return optionalUser.get();
	
		throw new ResourceNotFoundException("user not found"+userId);
	}

	@Override
	public Users addUserDetails(Users u) {
		return userrepository.save(u);
		
	}

	@Override
	public List<Users> getAllusersbyid(int userId) {
		// TODO Auto-generated method stub
		return dao.getalluserbydoctorid(userId);
	}

	@Override
	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		System.out.println("in delete service"+userId);
		userrepository.deleteById(userId);
		return null;
	}
	@Override
	public Users validateUser(String email, String pass) {
		return dao.validateUser(email, pass);
	}

	@Override
	public Users updateUsers(int userId, Users detachedPOJO) {

		Optional<Users>extinguser=userrepository.findById(userId);
		if(extinguser.isPresent())
		{
			Users users=extinguser.get();
			users.setFirstname(detachedPOJO.getFirstname());;
			users.setMiddlename(detachedPOJO.getMiddlename());;
			users.setLastname(detachedPOJO.getLastname());
			users.setEmail(detachedPOJO.getEmail());
			users.setContactno(detachedPOJO.getContactno());
			users.setGender(detachedPOJO.getGender());
			users.setBloodgroup(detachedPOJO.getBloodgroup());
			users.setDateofbirth(detachedPOJO.getDateofbirth());
			users.setSelecteddoctor(detachedPOJO.getSelecteddoctor());
			return users;
		}
		throw new ResourceNotFoundException("Inavlid Description id");
	}

	@Override
	public Description assignDescription(Description d) {
		
		Optional<Users>optional=userrepository.findById(d.getUserdetails().getUsersId());
		Users s=optional.orElseThrow(()->new ResourceNotFoundException("user not found"));
		d.setUserdetails(s);
		
		return descriptionrep.save(d);
	}

	
	}

	
	
	

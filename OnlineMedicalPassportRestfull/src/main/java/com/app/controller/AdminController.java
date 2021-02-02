package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Description;
import com.app.pojos.Doctors;
import com.app.pojos.UserLogin;
import com.app.pojos.Users;
import com.app.service.IDoctorService;
import com.app.service.IUserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IUserService userservice;
	
	@Autowired
	private IDoctorService doctorservice;

	
	
	public AdminController() {
		System.out.println("In Admin Controller"+getClass().getName());
	}
	
	
	
	  @GetMapping("/users")
	  public ResponseEntity<?> listAllUsers() {
	  System.out.println("in list of all users");
	  List<Users> users=userservice.getAllUsers(); 
	  if(users.isEmpty()) 
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
	  return new ResponseEntity<>(users,HttpStatus.OK); }	 


		@GetMapping("/doctors")
		public ResponseEntity<?>listAllDoctors()
		{
			  System.out.println("in list of all doctors");
			  List<Doctors>doctors=doctorservice.listAllDoctors();
			  if(doctors.isEmpty())
				  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				  return new ResponseEntity<>(doctors,HttpStatus.OK);
		}


		@GetMapping("/users/{ufirstname}")
		public ResponseEntity<?>findByFirstname(@PathVariable String ufirstname)
		{
			System.out.println("in users details"+ufirstname);
			Optional<Users>userdetails=userservice.findByFirstname(ufirstname);
		if(userdetails.isPresent())
			return new ResponseEntity<>(userdetails.get(),HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		@GetMapping("/doctors/{dName}")
		@PostMapping(produces = "application/json")
		public ResponseEntity<?>findByName(@PathVariable String dName)
		{
			System.out.println("in users details"+dName);
			Optional<Doctors>doctordetails=doctorservice.findByName(dName);
		if(doctordetails.isPresent())
			return new ResponseEntity<>(doctordetails.get(),HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	
		
		//@PostMapping("/users")
		@PostMapping(produces = "application/json")
		public ResponseEntity<?> addNewUser(@RequestBody Users u ) {
			System.out.println("in add new user " + u);
			return ResponseEntity.ok(userservice.addUserDetails(u));
		}
		@PostMapping("/doctors")
		public ResponseEntity<?>registerdDoctor(@RequestBody Doctors doctors)
		{
			System.out.println("add doctors"+doctors);
			try {
				Doctors registreddoctor=doctorservice.registerdDoctor(doctors);
				return new ResponseEntity<>(registreddoctor,HttpStatus.OK);
			}catch (RuntimeException e) {
			e.printStackTrace();	
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		
		@GetMapping(produces = "application/json")
		@RequestMapping({ "/validateLogin" })
		public UserLogin validateLogin() {
			return new UserLogin("User successfully authenticated");
		}
		
 
		//@PostMapping("/users/description")
		@RequestMapping(produces = "application/json",value = "/users/desccription",method = RequestMethod.POST)
		public ResponseEntity<?> assignDescription(@RequestBody Description description)
		{
			System.out.println("assign description  "+description +" "+description.getUserdetails());
			return ResponseEntity.ok(userservice.assignDescription(description));
					
		}
		
		 

	
		
}

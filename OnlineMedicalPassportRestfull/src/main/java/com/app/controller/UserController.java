package com.app.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Users;
import com.app.service.IUserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController //cla s level annotation +@Responce Body anno added on types of all req handling methods
@RequestMapping("/users")
public class UserController {
	

	  @Autowired 
	  private IUserService service;
	  
	  public UserController() {
	  System.out.println("In User Controlller"+getClass().getName()); 
	 }	  

		//add new REST end point : to add a user
		@PostMapping
		public ResponseEntity<?> addNewUser(@RequestBody Users u ) {
			System.out.println("in add new user " + u);
			return ResponseEntity.ok(service.addUserDetails(u));
		}
		
		
		@GetMapping("/{userId}")
		public ResponseEntity<?> getuserslistbyid(@PathVariable int userId)
		{
			
			System.out.println("in list  update all crop buyers.... "+userId );
		try {
			List <Users> u= service.getAllusersbyid(userId);
			return new ResponseEntity<>(u,HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		}

		
		@DeleteMapping("/{userId}")
        public String deleteUser(@PathVariable int userId)
        {
			System.out.println("in dlete user"+userId);
			return service.deleteUser(userId);
        }
		
		
		
		
		@RequestMapping(value="/login",produces = "application/json",method = RequestMethod.POST)
		public ResponseEntity<?> validateUser(@RequestBody Users u,HttpSession hs)
		{
			System.out.println("in validate user");
			try {
				u=service.validateUser(u.getEmail(),u.getPassword());
				
				return new ResponseEntity<Users>(u,HttpStatus.OK);
					
			}catch (Exception e) {
				return new ResponseEntity<String>("User Invalid",HttpStatus.OK);
			}
		}
		
		@PutMapping("/updateusers/{userId}")
		public ResponseEntity <?>updateUserDetials(@PathVariable int userId,@RequestBody Users detachedPojo)
		{
			System.out.println("in service update  buyer"+userId+" "+detachedPojo);
			Users updateUser=service.updateUsers(userId, detachedPojo);
			if(updateUser==null)
			
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(updateUser,HttpStatus.OK);
		}
		
		
}

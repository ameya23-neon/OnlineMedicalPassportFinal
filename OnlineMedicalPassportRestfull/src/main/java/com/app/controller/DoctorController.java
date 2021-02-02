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

import com.app.pojos.Doctors;
import com.app.pojos.Users;
import com.app.service.IDoctorService;
import com.app.service.IUserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private IDoctorService service;
	
	@Autowired
	private IUserService userservice;
	
	
	public DoctorController() {
		System.out.println("In Doctor Controller"+getClass().getName());
	}
	
	  @GetMapping("/users")
	  public ResponseEntity<?> listAllUsers() {
	  System.out.println("in list of all users");
	  List<Users> users=userservice.getAllUsers(); 
	  if(users.isEmpty()) 
		  return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
	  return new ResponseEntity<>(users,HttpStatus.OK); 
	  }	 
	
	

		@PostMapping("/users")
		public ResponseEntity<?> addNewUser(@RequestBody Users u ) {
			System.out.println("in add new user " + u);
			return ResponseEntity.ok(userservice.addUserDetails(u));
		}
		
 
	@PostMapping(produces = "application/json")
  public ResponseEntity<?>registerdDoctor(@RequestBody Doctors doctors)
{
	System.out.println("add doctors"+doctors);
	try {
		Doctors registreddoctor=service.registerdDoctor(doctors);
		return new ResponseEntity<>(registreddoctor,HttpStatus.OK);
	}catch (RuntimeException e) {
	e.printStackTrace();	
	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
	
	
	@DeleteMapping("/{doctorsId}")
    public String deleteUser(@PathVariable int doctorsId)
    {
		System.out.println("in dlete user"+doctorsId);
		return service.deleteDoctor(doctorsId);
    }
	
	@PostMapping("/login")
	public ResponseEntity<?> validateDoctors(@RequestBody Doctors d,HttpSession hs)
	{
		System.out.println("in validate doctor");
		try {
			d=service.validateDoctors(d.getEmail(), d.getPassword());
			return new ResponseEntity<Doctors>(d,HttpStatus.OK);
		}catch (Exception e) {
			
			return new ResponseEntity<String>("Doctor Invalid",HttpStatus.OK);
		}
	}
	
	
	
	@RequestMapping(value="doctors/doctorId",produces = "application/json",method = RequestMethod.PUT)
	public ResponseEntity<?>updateDoctorsDetails(@PathVariable int doctorId,@RequestBody Doctors d)
	
	{
		System.out.println("in doctors"+doctorId+" "+d);
		try {
		
			Doctors updatedDetails=service.updateDoctors(doctorId, d);
			return new ResponseEntity<>(updatedDetails,HttpStatus.OK);
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/{doctorId}")
	public ResponseEntity <?>updateBuyerDetials(@PathVariable int doctorId,@RequestBody Doctors detachedPojo)
	{
		System.out.println("in service update  buyer"+doctorId+" "+detachedPojo);
		Doctors updateDoctor=service.updateDoctors(doctorId, detachedPojo);
		if(updateDoctor==null)
		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(updateDoctor,HttpStatus.OK);
	}
	
	
	@GetMapping("/{doctorsId}")
	public ResponseEntity<?> getDoctorslistbyid(@PathVariable int doctorsId)
	{
		
		System.out.println("in list  Doctorsdetails.. "+doctorsId );
	try {
		List <Doctors> d= service.getAllDoctorsbyid(doctorsId);
		return new ResponseEntity<>(d,HttpStatus.OK);
	}
	catch(RuntimeException e)
	{
		return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	}

	
	
	
}
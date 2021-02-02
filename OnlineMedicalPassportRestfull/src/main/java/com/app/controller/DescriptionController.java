package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Description;
import com.app.service.IDescriptionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/description")
public class DescriptionController {


	@Autowired
	private IDescriptionService descriptionservice;
	
	
	
	@PutMapping("{/descriptionid}")
	public ResponseEntity<?>updateDescriptionDetails(@PathVariable int descriptionid,@RequestBody Description d)
	
	{
		System.out.println("in description"+descriptionid+" "+d);
		try {
		
			Description updatedDetails=descriptionservice.updateDescrition(descriptionid, d);
			return new ResponseEntity<>(updatedDetails,HttpStatus.OK);
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		@GetMapping("/{descriptionid}")
		public ResponseEntity<?> getdoctorlistbyid(@PathVariable int descriptionid)
		{
			
			System.out.println("in list  description .... "+descriptionid );
		try {
			Description u= descriptionservice.getDescriptionDetailsById(descriptionid);
			return new ResponseEntity<>(u,HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
		@DeleteMapping("/{descriptionid}")
        public String deleteUser(@PathVariable int descriptionid)
        {
			System.out.println("in dlete description"+descriptionid);
			descriptionservice.deleteDescription(descriptionid);
			return "discription delete";
        }
		
		
	}

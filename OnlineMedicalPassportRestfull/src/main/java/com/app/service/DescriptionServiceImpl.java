package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.dao.DescriptionRepository;
import com.app.pojos.Description;

@Service
@Transactional
public class DescriptionServiceImpl implements IDescriptionService{

	@Autowired
	private DescriptionRepository dscriptionrep;
	

	@Override
	public Description updateDescrition(int descriptionid, Description d1) {
		// TODO Auto-gener ated method stub
		
	
		Optional<Description>d=dscriptionrep.findById(descriptionid);
		if(d.isPresent())
		{
			Description description=d.get();
			description.setAge(d1.getAge());
			description.setHeight(d1.getHeight());
			description.setOxygenLevel(d1.getOxygenLevel());
			description.setHeartRate(d1.getHeartRate());
			description.setBloodPressure(d1.getBloodPressure());
			description.setAllergies(d1.getAllergies());
			description.setMedicalhistory(d1.getMedicalhistory());
			description.setLastcheckupdate(d1.getLastcheckupdate());
			description.setUpcomingcheckupdate(d1.getUpcomingcheckupdate());
			return description;
		}
		throw new ResourceNotFoundException("Inavlid Description id");
	}


	@Override
	public Description getDescriptionDetailsById(int descriptionid) {
		// TODO Auto-generated method stub
		System.out.println("in user Description impl class"+dscriptionrep.findById(descriptionid));
		Optional<Description>optionaldescription=dscriptionrep.findById(descriptionid);
		if(optionaldescription.isPresent())
			return optionaldescription.get();
	
		throw new ResourceNotFoundException("Doctor not found"+descriptionid);
	}


	
	@Override
	public String deleteDescription(int descriptionid) {
		// TODO Auto-generated method stub
		System.out.println("in delete description"+descriptionid);
		dscriptionrep.deleteById(descriptionid);
		return null;
	}
	
	
}




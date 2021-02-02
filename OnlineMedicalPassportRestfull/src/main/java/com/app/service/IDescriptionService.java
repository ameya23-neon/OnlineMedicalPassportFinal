package com.app.service;

import com.app.pojos.Description;

public interface IDescriptionService {


	Description getDescriptionDetailsById(int descriptionid);

	 Description updateDescrition(int descriptionid, Description detachedPOJO);
	 
		String deleteDescription(int descriptionid);
}

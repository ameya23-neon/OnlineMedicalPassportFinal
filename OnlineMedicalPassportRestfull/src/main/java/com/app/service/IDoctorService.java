package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Doctors;

public interface IDoctorService {

	
	List<Doctors>listAllDoctors();
	Optional<Doctors>findByName(String dName);
	Doctors getDoctorrDetailsById(int doctorId);
	Doctors registerdDoctor(Doctors trannsientDoctor);
	String deleteDoctor(int doctorsId);
	public Doctors validateDoctors(String email, String pass);
	Doctors updateDoctors(int doctorId, Doctors detachedPOJO);
	List<Doctors>getAllDoctorsbyid(int doctorsId);
}

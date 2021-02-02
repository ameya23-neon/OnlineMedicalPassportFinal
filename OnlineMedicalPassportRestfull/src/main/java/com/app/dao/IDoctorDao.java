package com.app.dao;

import java.util.List;

import com.app.pojos.Doctors;

public interface IDoctorDao {

	public Doctors validateDoctors(String email, String pass);
	List<Doctors> getallDoctorsbydoctorid(int doctorsId);
}

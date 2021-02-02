package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.dao.DoctorRepository;
import com.app.dao.IDoctorDao;
import com.app.pojos.Doctors;

@Service
@Transactional
public class DoctorServiceImpl implements IDoctorService {

	
	@Autowired
	private DoctorRepository doctorrepository;
	
	
	@Autowired
	private IDoctorDao dao;
	
	@Override
	public List<Doctors> listAllDoctors() {
		return doctorrepository.findAll();
	}

	@Override
	public Optional<Doctors> findByName(String dName) {
		// TODO Auto-generated method stub
		return doctorrepository.findByName(dName);
	}

	@Override
	public Doctors getDoctorrDetailsById(int doctorId) {
		// TODO Auto-generated method stub
		System.out.println("in user service impl class"+doctorrepository.findById(doctorId));
		Optional<Doctors>optionaldoctor=doctorrepository.findById(doctorId);
		if(optionaldoctor.isPresent())
			return optionaldoctor.get();
	
		throw new ResourceNotFoundException("Doctor not found"+doctorId);
	}
	@Override
	public Doctors registerdDoctor(Doctors trannsientDoctor) {
		// TODO Auto-generated method stub
		return doctorrepository.save(trannsientDoctor);
	}

	@Override
	public String deleteDoctor(int doctorsId) {
		System.out.println("in delete service"+doctorsId);
	doctorrepository.deleteById(doctorsId);
		return null;
	}

	@Override
	public Doctors validateDoctors(String email, String pass) {
		// TODO Auto-generated method stub
		return dao.validateDoctors(email, pass);
	}

	@Override
	public Doctors updateDoctors(int doctorId, Doctors detachedPOJO) {
		System.out.println("in doctor update service");
		Optional<Doctors>existingdoctor=doctorrepository.findById(doctorId);
		if(existingdoctor.isPresent())
		{
			Doctors doctors=existingdoctor.get();
			doctors.setTitle(detachedPOJO.getTitle());
			doctors.setName(detachedPOJO.getName());
			doctors.setEmail(detachedPOJO.getEmail());
			doctors.setPassword(detachedPOJO.getPassword());
			
			doctors.setHospitalarea(detachedPOJO.getHospitalarea());
			doctors.setHospitalcity(detachedPOJO.getHospitalcity());
			doctors.setHospitalname(detachedPOJO.getHospitalname());
				doctors.setContactno(detachedPOJO.getContactno());
				
			return doctors;
		}
		return null;
	}

	@Override
	public List<Doctors> getAllDoctorsbyid(int doctorsId) {
		// TODO Auto-generated method stub
		return dao.getallDoctorsbydoctorid(doctorsId);
	}

	}


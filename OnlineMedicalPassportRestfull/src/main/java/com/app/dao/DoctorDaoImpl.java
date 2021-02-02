package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Doctors;
@Repository
public class DoctorDaoImpl implements IDoctorDao{

	@PersistenceContext
	private EntityManager mgr;
	
	
	@Override
	public Doctors validateDoctors(String email, String pass) {
		String jpql = "select d from Doctors d where d.email=:email and d.password = :pass";
		return mgr.createQuery(jpql, Doctors.class).setParameter("email", email).setParameter("pass", pass)
				.getSingleResult();
	}


	@Override
	public List<Doctors> getallDoctorsbydoctorid(int doctorsId) {
		String jpql="select d from Doctors d  where d.doctorsId=:doctorsId ";
		return mgr.createQuery(jpql,Doctors.class).setParameter("doctorsId", doctorsId).getResultList();
	}

}

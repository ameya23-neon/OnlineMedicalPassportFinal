package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.pojos.Users;
@Repository
public class UserDaoImpl implements IUserDao {

	@PersistenceContext
	private EntityManager mgr;
	
	@Override
	public List<Users> getalluserbydoctorid(int userId) {
		// TODO Auto-generated method stub
		
		String jpql="select u from Users u  where u.userId=:userId ";
		return mgr.createQuery(jpql,Users.class).setParameter("userId", userId).getResultList();
		
	}

	@Override
	public Users validateUser(String email, String pass) {
		String jpql = "select u from Users u where u.email=:email and u.password = :pass";
		return mgr.createQuery(jpql, Users.class).setParameter("email", email).setParameter("pass", pass)
				.getSingleResult();
	}

	
}

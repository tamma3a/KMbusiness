package com.esprit.km.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.km.domain.User;

@Stateless
@LocalBean
public class UserService {
	
	@PersistenceContext(unitName="KMbusiness")
	EntityManager em;

	public void addUser(User user){
		em.persist(user);
	}
	
	public List<User> getAll() {
		return em.createQuery("FROM User").getResultList();
		 
	}
	
	public void editUser(User user){
		em.merge(user);
	}
	
	public void deleteUser(User user){
		em.remove(user);
	}
}

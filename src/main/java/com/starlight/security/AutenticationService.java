package com.starlight.security;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticationService implements UserDetailsService {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unused")
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {

		@SuppressWarnings("unchecked")
		List<User> users = entityManager.createNamedQuery("User.findAll").getResultList();
		User user = null;

		for (User userSearch : users) {
			if (userSearch.getUsername().equals(userName)) {
				user = userSearch;
			}
		}
		if (user == null)
			throw new UsernameNotFoundException("User not found");

		String username = user.getUsername();
		String password = user.getPassword();

		
		return user;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}

package com.startlight.security;

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

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {

		List<User> users = entityManager.createNamedQuery("User.findAll",
				User.class).getResultList();
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
}

package com.starlight.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.starlight.model.Lista;
import com.starlight.model.User;

@Service
public class ListasService {

	  @PersistenceContext
	  private EntityManager em;
	  
	  public List<Lista> getAllListas(User usuario) {
			 Query q=em.createNativeQuery("Select * from Lista Where idUsuario=:idUsuario", Lista.class);
			 q.setParameter("idUsuario", usuario.getId());
			 List<Lista> listas=q.getResultList();
			 return listas;
		  }
}

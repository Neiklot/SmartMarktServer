package com.starlight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starlight.model.Lista;
import com.starlight.model.User;
import com.starlight.services.ListasService;

@CrossOrigin(origins = "http://localhost:8100")
@Controller
public class ListasController {

	@Autowired
	private ListasService listasService;
	
	@RequestMapping(value = "/listas", method = RequestMethod.GET)
	public ResponseEntity<?> getListas() {
		User usuario=new User();
		List<Lista> listas = listasService.getAllListas(usuario);
		return new ResponseEntity(listas, HttpStatus.OK);
	}
}

package com.starlight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.starlight.model.ContextBodyRequest;

@Controller
public class BasicController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView cliente() {
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";

		return new ModelAndView("index", "message", message);
	}

	@RequestMapping(value = "/loginApp", method = RequestMethod.POST)
	public String loginApp(@RequestBody ContextBodyRequest contextBodyRequest, ModelMap model) {
		return "OK";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginWeb(ModelMap model) {
		return new ModelAndView("login");
	}
}

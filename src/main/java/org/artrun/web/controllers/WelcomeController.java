package org.artrun.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping(value = "/")
	public String getHomePage() {
		
		return "index";
		
	}

}

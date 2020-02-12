package com.carlos.muroMensajes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RutasGenericas {

	@GetMapping("/")
	public String inicial() {

		return "index";
	}
	
	@GetMapping("/login")
	public String seguridad() {
		
		return "start";
	}
	
}

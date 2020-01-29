package com.carlos.muroMensajes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RutasGenericas {

	@GetMapping("/")
	public ModelAndView rutaInicial() {

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		return model;
	}
}
package com.carlos.muroMensajes.datos.mensajes;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MensajeRutas {

	@GetMapping("/mensajes")
	public ModelAndView rutaInicial() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("mensajes");
		model.addObject("mensajes", new ArrayList<Mensaje>());
		
		return model;
	}
	
	@GetMapping("/mensajes/{id}")
	public ModelAndView rutaEscribir() {
		
		ModelAndView model = new ModelAndView();

		return model;
	}
	
	@GetMapping("/mensajes/borrar/{id}")
	public ModelAndView rutaBorrar() {
		
		ModelAndView model = new ModelAndView();

		return model;
	}
	
	@GetMapping("/mensajes/anadir")
	public ModelAndView rutaVisualizar() {
		
		ModelAndView model = new ModelAndView();

		return model;
	}

}

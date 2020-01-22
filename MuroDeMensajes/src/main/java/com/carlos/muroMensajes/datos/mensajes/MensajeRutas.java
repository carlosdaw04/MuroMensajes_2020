package com.carlos.muroMensajes.datos.mensajes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MensajeRutas {

	@Autowired
	private MensajeDAO mensajeDAO;

	@GetMapping("/mensajes")
	public ModelAndView rutaInicial() {

		ModelAndView model = new ModelAndView();
		model.setViewName("mensajes");
		model.addObject("mensaje", new Mensaje());

		List<Mensaje> listaMensajes = (List<Mensaje>) mensajeDAO.findAll();
		model.addObject("mensajes", listaMensajes);

		return model;
	}
	
	@PostMapping("/mensajes/anadir")
	public String rutaAnadir(@ModelAttribute Mensaje mensaje) {

		mensajeDAO.save(mensaje);

		return "redirect:/mensajes";
	}

	@GetMapping("/mensajes/{id}")
	public ModelAndView rutaEscribir() {

		ModelAndView model = new ModelAndView();

		return model;
	}

	@GetMapping("/mensajes/borrar/{id}")
	public String rutaEliminar(@PathVariable long id) {
		//Version 1
//		Mensaje mensaje = mensajeDAO.findById(id).get();
//		mensajeDAO.delete(mensaje);
		
		//Version 2
		mensajeDAO.deleteById(id);
		
		return("redirect:/mensajes");

	}

}

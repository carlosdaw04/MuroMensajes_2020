package com.carlos.muroMensajes.datos.mensajes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.carlos.muroMensajes.datos.usuarios.Usuario;

@Controller
public class MensajeRutas {

	@Autowired
	private MensajeDAO mensajeDAO;
	

	@GetMapping("/mensajes")
	public ModelAndView rutaInicial(Authentication auth) {

		ModelAndView model = new ModelAndView();
		model.setViewName("mensajes");
		model.addObject("mensaje", new Mensaje());
		
		// Coge el objeto Usuario que haya iniciado sesion. Se le pasa al DAO para que recoga los mensajes de ese usuario
		Usuario usuario = (Usuario) auth.getPrincipal();
		
		List<Mensaje> listaMensajes = (List<Mensaje>) mensajeDAO.findByUsuario(usuario);
		model.addObject("mensajes", listaMensajes);

		return model;
	}
	
	@PostMapping("/mensajes/anadir")
	public String rutaAnadir(@ModelAttribute Mensaje mensaje) {

		// Guarda el mensaje
		mensajeDAO.save(mensaje);

		return "redirect:/mensajes";
	}

	@GetMapping("/mensajes/borrar/{id}")
	public String rutaEliminar(@PathVariable long id) {
		
		// Borra el mensaje con ese id
		mensajeDAO.deleteById(id);
		
		return("redirect:/mensajes");

	}

}

package com.carlos.muroMensajes.datos.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.carlos.muroMensajes.datos.mensajes.Mensaje;

@Controller
public class UsuarioRutas {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping("/usuarios")
	private ModelAndView rutaUsuario() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("usuario");
		model.addObject("usuario", new Usuario());
		
		List<Usuario> listaUsuarios = (List<Usuario>) usuarioDAO.findAll();
		model.addObject("usuarios", listaUsuarios);
		
		return model;
		
	}
	
	@PostMapping("usuarios/anadir")
	private String rutaAnadir(@ModelAttribute Usuario usuario) {
		
		usuarioDAO.save(usuario);
		
		return "redirect:/usuarios";
	}

	@GetMapping("/usuarios/borrar/{usuario}")
	public String rutaEliminar(@PathVariable String usuario) {

		
		//Version 2
		usuarioDAO.deleteById(usuario);
		
		return("redirect:/usuarios");

	}
	
	@GetMapping("/usuarios/{usuario}")
	private ModelAndView rutaUsuario(@PathVariable Usuario usuario) {
		ModelAndView model = new ModelAndView();
		model.setViewName("mostrarUsuario");
		model.addObject("usuario", usuario);

		
		return model;
		
	}
}

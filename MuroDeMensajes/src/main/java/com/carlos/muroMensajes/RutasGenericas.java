package com.carlos.muroMensajes;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.carlos.muroMensajes.sesiones.Carrito;


@Controller
public class RutasGenericas {

	@GetMapping("/")
	public String inicial(HttpSession sesion, ModelMap model) {

		return "index";
	}
	
	@GetMapping("/login")
	public String seguridad(HttpSession sesion) {
		
		sesion.setAttribute("carrito", new Carrito());
		
		return "start";
	}
	
	@GetMapping("/addCarrito")
	public String carrito(HttpSession sesion) {
		
		Carrito carrito = (Carrito)sesion.getAttribute("carrito");
		if(carrito!=null) {
			carrito.addProducto();
			//sesion.setAttribute("carrito", carrito);
		}
		
		return "redirect:/";
	}		
	
}

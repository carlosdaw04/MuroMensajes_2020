package com.carlos.muroMensajes.datos.mensajes;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlos.muroMensajes.datos.usuarios.Usuario;

@Repository
public interface MensajeDAO extends CrudRepository<Mensaje, Long> {
	
	// Saca un usuario
    List<Mensaje> findByUsuario(Usuario usuario);

}

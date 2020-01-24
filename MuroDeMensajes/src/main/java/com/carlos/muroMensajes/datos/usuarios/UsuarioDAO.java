package com.carlos.muroMensajes.datos.usuarios;

import org.springframework.data.repository.CrudRepository;

import com.carlos.muroMensajes.datos.mensajes.Mensaje;

public interface UsuarioDAO extends CrudRepository<Usuario, String> {

}

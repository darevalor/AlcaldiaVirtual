package edu.uniandes.alcaldiavirtual.servicios;

import javax.ejb.Local;

import edu.uniandes.alcaldiavirtual.dto.UsuarioDto;

@Local
public interface IServicioUsuarioGestor {
	/**
	 * Valida el usuario y contraseña del usuario
	 * @param usuarioDto
	 * @return Retorna los datos del usuario con el rol incluido
	 */
	UsuarioDto autenticar(String login, String contrasenia);
}

package edu.uniandes.alcaldiavirtual.boundary;

import javax.ejb.Local;

import edu.uniandes.alcaldiavirtual.dto.UsuarioDto;

@Local
public interface IUsuarioBoundary {
	/**
	 * Valida el usuario y contraseña del usuario
	 * @param usuarioDto
	 * @return Retorna los datos del usuario con el rol incluido
	 */
	UsuarioDto autenticar(String login, String contrasenia);
}

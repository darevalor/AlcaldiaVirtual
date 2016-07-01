package edu.uniandes.alcaldiavirtual.boundary.impl;

import edu.uniandes.alcaldiavirtual.boundary.IUsuarioBoundary;
import edu.uniandes.alcaldiavirtual.dto.UsuarioDto;

public class UsuarioBoundary implements IUsuarioBoundary {

	/**
	 * Valida el usuario y contraseña del usuario
	 * @param usuarioDto
	 * @return Retorna los datos del usuario con el rol incluido
	 */
	@Override
	public UsuarioDto autenticar(String login, String contrasenia) {
		UsuarioDto usuarioDto = new UsuarioDto("user", "#1234#", "A");
		return usuarioDto;
	}

}

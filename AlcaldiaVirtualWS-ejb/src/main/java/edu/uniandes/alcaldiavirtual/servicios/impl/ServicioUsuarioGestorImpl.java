package edu.uniandes.alcaldiavirtual.servicios.impl;

import javax.ejb.Stateless;

import edu.uniandes.alcaldiavirtual.boundary.IUsuarioBoundary;
import edu.uniandes.alcaldiavirtual.dto.UsuarioDto;
import edu.uniandes.alcaldiavirtual.servicios.IServicioUsuarioGestor;
import edu.uniandes.alcaldiavirtual.util.ConstantesAlcaldiaVirtual;
import edu.uniandes.alcaldiavirtual.util.PasswordCipher;

@Stateless
public class ServicioUsuarioGestorImpl implements IServicioUsuarioGestor {
	
	private IUsuarioBoundary usuarioBoundary;

	@Override
	public UsuarioDto autenticar(String login, String contrasenia) {
		String contraseniaEncriptada = PasswordCipher.encrypt(contrasenia, ConstantesAlcaldiaVirtual.STRKEY);
		return usuarioBoundary.autenticar(login, contraseniaEncriptada);
	}

}

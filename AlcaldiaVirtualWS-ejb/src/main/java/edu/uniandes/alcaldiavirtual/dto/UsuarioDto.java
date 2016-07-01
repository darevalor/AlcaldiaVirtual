package edu.uniandes.alcaldiavirtual.dto;

import java.io.Serializable;

public class UsuarioDto implements Serializable{
	private String login;
	private String contrasenia;
	private String estado;
	
	/**
	 * 
	 * @param login
	 * @param contrasenia
	 * @param estado
	 */
	public UsuarioDto(String login, String contrasenia, String estado) {
		super();
		this.login = login;
		this.contrasenia = contrasenia;
		this.estado = estado;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}
	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}

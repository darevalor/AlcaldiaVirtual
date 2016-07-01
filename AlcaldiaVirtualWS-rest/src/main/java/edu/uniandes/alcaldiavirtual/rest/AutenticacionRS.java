package edu.uniandes.alcaldiavirtual.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import edu.uniandes.alcaldiavirtual.dto.UsuarioDto;
import edu.uniandes.alcaldiavirtual.servicios.IServicioUsuarioGestor;

@Path("/servicios")
@Stateless
public class AutenticacionRS {
	
	@EJB
	private IServicioUsuarioGestor servicioUsuarioGestor;
	
	/**
	 * Valida el usuario y contraseña de un usuario
	 * @param login
	 * @param contrasenia
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("autenticar/")
	public Response autenticar(String login, String contrasenia){
		UsuarioDto usuarioDto = servicioUsuarioGestor.autenticar(login, contrasenia);
		String response = new Gson().toJson(usuarioDto);
		return Response.status(200).entity(response).build();
	}
}

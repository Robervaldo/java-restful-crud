package br.com.crud_restful.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.crud_restful.model.Usuario;
import br.com.crud_restful.service.UsuarioService;

@Path("/consulta-usuario")
@RequestScoped
public class ConsultaUsuario {
	
	@Inject
	private UsuarioService usuarioService;
	
	@GET
	@Path("/login/{login}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario consultarUsuarioPeloLoginGet(@PathParam("login") String login){
		return consultarUsuarioPeloLogin(login);
	}
	
	@POST
	@Path("/usuario.json")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Usuario consultarUsuarioPeloLogin(String login){
		Usuario response = usuarioService.findByLogin(login);
		return response;
	}
}

package br.com.crud_restful.view;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.com.crud_restful.model.Usuario;
import br.com.crud_restful.service.UsuarioService;

@Path("/usuario")
@Consumes({"application/json"})
@Produces({"application/json"})
public class ConsultaUsuario {
	
	@Inject
	private UsuarioService usuarioService;
	
	//SEARCH
	@GET
	@Path("/login/{login}")
	public Usuario searchUsuario(@PathParam("login") String login){
		Usuario usuario = usuarioService.findByLogin(login);
		if(usuario == null){
			usuario = new Usuario();
		}
		return usuario;
	}
	
	//CREATE
	@PUT
    @Path("/create/{login}")
    public Usuario createUsuario(@PathParam("login") String login, @QueryParam("nome") String nome) {
		return null;
    }
 
	//UPDATE
    @POST
    @Path("/update/{login}")
    public Usuario updateUsuario(@PathParam("login") String login, String nome) {
    	return null;
    }
 
    //DELETE
    @DELETE
    @Path("/delete/{login}")
    public Usuario removeUsuario(@PathParam("login") String login) {
    	return null;
    }
}

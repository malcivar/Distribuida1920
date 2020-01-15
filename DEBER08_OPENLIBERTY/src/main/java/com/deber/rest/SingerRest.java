package com.deber.rest;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.deber.entidad.Singer;
import com.deber.servicios.SingerCrud;

@Path("/singer")
@ApplicationScoped
public class SingerRest {

	@Inject
	SingerCrud jdbc ;
	
	
	@POST
    @Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response añadirSinger(Singer s) {
		String mensaje = "Singer Creado";
		jdbc.Ingresar(s);
		
		return Response.ok(mensaje).build();
		
	}
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarSinger(Singer s) {
		String mensaje = "Singer Actualizado";	
		jdbc.Actualizar(s);
		return Response.ok(mensaje).build();
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	 public Response  buscarSinger(@PathParam("id") int id) {
		Singer singer = jdbc.buscarSinger(id);
		if (singer.getSinger_id() == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
        } else {
        	
            return Response.ok(singer).build();
        }
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Singer> buscarSingers() {
		return jdbc.buscarSingers();
		
	}
	
	
	@DELETE
    @Path("/{id}")
	public Response borrarSinger(@PathParam("id") int id) {
		String mensaje = "Singer Eliminad0";
		Singer singer = jdbc.buscarSinger(id);
		
		jdbc.Eliminar(id);
		
		return Response.ok(mensaje).build();
	}
	
}

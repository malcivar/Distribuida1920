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

import com.deber.entidad.Album;
import com.deber.servicios.AlbumCrud;

@Path("/album")
@ApplicationScoped
public class AlbumRest {

	@Inject
	AlbumCrud jdbc;
	
	@POST
    @Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response añadirAlbum(Album a) {
		String mensaje = "Album creado";		
		jdbc.Ingresar(a);
	
		return Response.ok(mensaje).build();
		
	}
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarAlbum(Album a) {
		String mensaje = "Album actualizado";		
		jdbc.Actualizar(a);
		return Response.ok(mensaje).build();
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	 public Response  buscarAlbum(@PathParam("id") int id) {
		Album album = jdbc.buscarAlbum(id);
		if (album.getAlbum_id() == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
        } else {
        return Response.ok(album).build();
        }
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Album> buscarAlbums() {
		return jdbc.buscarAlbums();
		
	}
	
	
	@DELETE
    @Path("/{id}")
	public Response borrarAlbum(@PathParam("id") int id) {
		String mensaje = "Album eliminado";	
		Album album = jdbc.buscarAlbum(id);
		
		jdbc.Eliminar(id);
		return Response.ok(mensaje).build();
	}
}
	
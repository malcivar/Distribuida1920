package com.deber.servicios;

import java.util.List;

import com.deber.entidad.Album;


public interface AlbumCrud {

	 public void Ingresar(Album album);
	 public Album buscarAlbum(int id);
	 public void Actualizar(Album album);
	 public List<Album> buscarAlbums();
	 public void Eliminar(int id);
	
}

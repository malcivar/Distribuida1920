package com.deber.servicios;

import java.util.List;

import com.deber.entidad.Singer;


public interface SingerCrud {
	
	 public void Ingresar(Singer singer);
	 public Singer buscarSinger(int id);
	 public void Actualizar(Singer singer);
	 public List<Singer> buscarSingers();
	 public void Eliminar(int id);
}

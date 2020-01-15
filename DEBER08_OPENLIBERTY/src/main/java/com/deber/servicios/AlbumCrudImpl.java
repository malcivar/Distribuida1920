package com.deber.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;
import com.deber.entidad.Album;


@ApplicationScoped
public class AlbumCrudImpl implements AlbumCrud {

	// EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crud");
	
	 @Inject
		private EntityManager em;
	
	@Override
	  public void Ingresar(Album album) {
			// EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crud");
			//  EntityManager em = emf.createEntityManager();
		  em.getTransaction().begin();
			em.persist(album);
			em.getTransaction().commit();
			//em.clear();
		//	em.close();
	  }
	  
	@Override
	  public Album buscarAlbum(int id) {
		 // EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crud");
		//  EntityManager em = emf.createEntityManager();
		  Album album = em.find(Album.class, id);
		//		em.close();
				return album;
	  }

	@Override
	  public List<Album> buscarAlbums() {
		//  EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crud");
		//  EntityManager em = emf.createEntityManager();
		 // TypedQuery<Album> query = em.createQuery("select a.album_id,a.title,a.release_date, s.first_name from Singer s , Album a where a.singer_id=s.Singer.singer_id", Album.class);
		  TypedQuery<Album> query = em.createQuery("Select e from Album e", Album.class);
	      List<Album> albums = query.getResultList();
	    //  em.close();
	      return albums;

	  }
	  
	@Override
	  public void Actualizar(Album album) {
		//	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crud");
		//	  EntityManager em = emf.createEntityManager();
		  em.getTransaction().begin();
			em.merge(album);
			em.getTransaction().commit();
			//em.clear();
		//	em.close();
	  }
	  
	@Override
	  public void Eliminar(int id) {
		//  EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crud");
		// EntityManager em = emf.createEntityManager();
			 Album album = em.find(Album.class, id);
			em.getTransaction().begin();
					em.remove(album);
					em.getTransaction().commit();
		//			em.close();
		  }
	  
	
	
}

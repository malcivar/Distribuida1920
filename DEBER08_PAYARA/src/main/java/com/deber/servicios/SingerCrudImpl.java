package com.deber.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.deber.entidad.Singer;

@ApplicationScoped
public class SingerCrudImpl implements SingerCrud{
	
	 //EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crud");
	
	 @Inject
		private EntityManager em;
	
	@Override
	  public void Ingresar(Singer singer) {
		
		try {
			// EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crud");
			//  EntityManager em = emf.createEntityManager();
		  em.getTransaction().begin();
			em.persist(singer);
			em.getTransaction().commit();
			//em.clear();
			//em.close();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	  }
	  
	@Override
	  public Singer buscarSinger(int id) {
		//  EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crud");
		//  EntityManager em = emf.createEntityManager();
		  Singer singer = em.find(Singer.class, id);
			//	em.close();
				return singer;
	  }

	@Override
	  public List<Singer> buscarSingers() {
		//  EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crud");
		//  EntityManager em = emf.createEntityManager();
		  TypedQuery<Singer> query = em.createQuery("Select e from Singer e", Singer.class);
	      List<Singer> albums = query.getResultList();
	    //  em.close();
	      return albums;

	  }
	  
	@Override
	  public void Actualizar(Singer singer) {
		//	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crud");
		//	  EntityManager em = emf.createEntityManager();
		  em.getTransaction().begin();
			em.merge(singer);
			em.getTransaction().commit();
			//em.clear();
		//	em.close();
	  }
	  
	@Override
	  public void Eliminar(int id) {
	//	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crud");
		// EntityManager em = emf.createEntityManager();
			 Singer singer = em.find(Singer.class, id);
			em.getTransaction().begin();
					em.remove(singer);
					em.getTransaction().commit();
		//			em.close();
		  }
	  
}

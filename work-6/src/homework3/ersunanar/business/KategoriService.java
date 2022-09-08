package homework3.ersunanar.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import homework3.ersunanar.entity.*;





@Stateless
@Path("KategoriService")
public class KategoriService {
	
	
	@PersistenceContext
	private EntityManager entityManager;	
	
	
	public List<Kategori> getKategoriList()
	{
		return entityManager.createQuery("select a from Kategori a",Kategori.class).getResultList();
	}
	
	
	public void addCategory(String k)
	{
		Kategori kategori = new Kategori(k);
		entityManager.persist(kategori);
	}

	
	public Kategori findById(int id) {
		Kategori kategori =  entityManager.find(Kategori.class, id);
		
		 return kategori;
		
	}


	public void updateKategori(Kategori kategori) {
		entityManager.merge(kategori);	
		
		
	}
	


}

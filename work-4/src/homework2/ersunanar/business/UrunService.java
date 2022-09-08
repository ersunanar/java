package homework2.ersunanar.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import homework2.ersunanar.entity.*;





@Stateless
public class UrunService {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	
	public List<Urun> getUrunler()
	{
		return entityManager.createQuery("select a from Urun a",Urun.class).getResultList();
	}
	
	public List<Kategori> getKategoriList()
	{
		return entityManager.createQuery("select a from Kategori a",Kategori.class).getResultList();
	}
	
	
	public List<Urun> getUrunlerByKategoriId(int id)
	{
		TypedQuery<Urun>  query1 =  entityManager.createQuery("select h from Urun h  where h.kategori.id=?1",Urun.class);	//?1 yerine x,y,z gibi ifadeler de kullanılabilir.
		query1.setParameter(1,id);
		return query1.getResultList();
	}
	
	
	
	public void createInitialData()
	{
		
		Kategori kategori1 = new Kategori("Elektronik");
		Kategori kategori2 = new Kategori("Giyim");
		Kategori kategori3 = new Kategori("Gıda");
		Kategori kategori4 = new Kategori("Spor");
		Kategori kategori5 = new Kategori("Eğitim");
		
		entityManager.persist(kategori1);
		entityManager.persist(kategori2);
		entityManager.persist(kategori3);
		entityManager.persist(kategori4);
		entityManager.persist(kategori5);
		
		
		Urun urun1 = new Urun("laptop",8000,kategori1);
		Urun urun2 = new Urun("televizyon",5000,kategori1);
		Urun urun3 = new Urun("telefon",3500,kategori1);
		Urun urun4 = new Urun("tablet",9000,kategori1);
		Urun urun5 = new Urun("hoparlör",1000,kategori1);
		Urun urun6 = new Urun("ceket",650,kategori2);
		Urun urun7 = new Urun("takım elbise",1500,kategori2);
		Urun urun8 = new Urun("gömlek",180,kategori2);
		Urun urun9 = new Urun("mont",1800,kategori2);
		Urun urun10 = new Urun("pantolon",350,kategori2);
		
		Urun urun11 = new Urun("makarna",8,kategori3);
		Urun urun12 = new Urun("süt",16,kategori3);
		Urun urun13 = new Urun("elma",7,kategori3);
		Urun urun14 = new Urun("peynir",75,kategori3);
		Urun urun15 = new Urun("yumurta",6,kategori3);
		
		Urun urun16 = new Urun("tenis raketi",480,kategori4);
		Urun urun17 = new Urun("paten",250,kategori4);
		Urun urun18= new Urun("bisiklet",2300,kategori4);
		Urun urun19 = new Urun("krampon",180,kategori4);
		Urun urun20 = new Urun("basketbol topu",75,kategori4);
		
		Urun urun21 = new Urun("defter",13,kategori5);
		Urun urun22 = new Urun("kitap",55,kategori5);
		Urun urun23 = new Urun("kalem",35,kategori5);
		Urun urun24 = new Urun("silgi",10,kategori5);
		Urun urun25 = new Urun("okul çantası",200,kategori5);
		
		
		entityManager.persist(urun1);
		entityManager.persist(urun2);
		entityManager.persist(urun3);
		entityManager.persist(urun4);
		entityManager.persist(urun5);
		entityManager.persist(urun6);
		entityManager.persist(urun7);
		entityManager.persist(urun8);
		entityManager.persist(urun9);
		entityManager.persist(urun10);
		entityManager.persist(urun11);
		entityManager.persist(urun12);
		entityManager.persist(urun13);
		entityManager.persist(urun14);
		entityManager.persist(urun15);
		entityManager.persist(urun16);
		entityManager.persist(urun17);
		entityManager.persist(urun18);
		entityManager.persist(urun19);
		entityManager.persist(urun20);
		entityManager.persist(urun21);
		entityManager.persist(urun22);
		entityManager.persist(urun23);
		entityManager.persist(urun24);
		entityManager.persist(urun25);
		
		
		Magaza firmaA = new Magaza("A","5551112233");
		Magaza firmaB = new Magaza("B","5554445566");
		Magaza firmaC = new Magaza("C","5557778899");
		
		
		entityManager.persist(firmaA);
		entityManager.persist(firmaB);
		entityManager.persist(firmaC);
		
		
		Envanter env1 = new Envanter(urun1, firmaA, 100);
		Envanter env2 = new Envanter(urun1, firmaB, 150);
		Envanter env3 = new Envanter(urun1, firmaC, 200);
		
		Envanter env4 = new Envanter(urun2, firmaA, 100);
		Envanter env5 = new Envanter(urun2, firmaB, 150);
		Envanter env6 = new Envanter(urun2, firmaC, 200);
		
		Envanter env7 = new Envanter(urun3, firmaA, 100);
		Envanter env8 = new Envanter(urun3, firmaB, 150);
		Envanter env9 = new Envanter(urun3, firmaC, 200);
		
		entityManager.persist(env1);
		entityManager.persist(env2);
		entityManager.persist(env3);
		entityManager.persist(env4);
		entityManager.persist(env5);
		entityManager.persist(env6);
		entityManager.persist(env7);
		entityManager.persist(env8);
		entityManager.persist(env9);
	
	}


}

package homework2.ersunanar.beans;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import homework2.ersunanar.business.*;
import homework2.ersunanar.entity.*;




@RequestScoped
@Named
public class UrunBean {
	
	
	
	@EJB
	private UrunService urunService;
	@EJB
	private UserService userService;
	@EJB
	private KategoriService kategoriService;
	
	
	private int selectedlocId;
	private Urun urun =  new Urun();;
	private Urun selectedUrun = new Urun();;
	private Kategori selectedUrunKategori = new Kategori();;
	


	
	private Kategori newKategori =  new Kategori();;
	private Kategori selectedKategori = new Kategori();;
	private int kId;
	

	@PostConstruct
	public void init() {
		if (urunService.getUrunler().isEmpty()) {
			
			urunService.createInitialData();
			userService.addUser();
				
		}

		
		
		
		
	
	}
	
	

	
	
	
	public Kategori getSelectedKategori() {
		return selectedKategori;
	}




	public void setSelectedKategori(Kategori selectedKategori) {
		this.selectedKategori = selectedKategori;
	}




	public Kategori getNewKategori() {
		return newKategori;
	}

	public void setNewKategori(Kategori newKategori) {
		this.newKategori = newKategori;
	}
	
	
	public Kategori findByKategoriID(int id)
	
	{
		
		selectedKategori = kategoriService.findById(id);
		System.out.println(selectedKategori);
		return selectedKategori;
		
		
	}
	
	public void updateKategori()
	
	{
		
		kategoriService.updateKategori(selectedKategori);
		
	}
	
	
	public String addCategory()
	{
		
		String kategori = newKategori.getKategori();
		kategoriService.addCategory(kategori);		
		return "categorylist";
	}
	
	public List<Kategori> getKategoriList()
	{
		return kategoriService.getKategoriList();
	}
	
	
	public Urun getUrun() {
		return urun;
	}


	public void setUrun(Urun urun) {
		this.urun = urun;
	}


	public String addProduct()
	{
		
		String urunAdi = urun.getUrunAdi();
		double fiyat = urun.getFiyat();
		Kategori kategori = kategoriService.findById(selectedlocId);
		
		urunService.addProduct(urunAdi, fiyat,kategori);		
		return "productlist";
	}
	
	public void updateProduct(int id)
	{
		Urun urun = urunService.findById(id);
		urun.setUrunAdi(selectedUrun.getUrunAdi());
		urun.setFiyat(selectedUrun.getFiyat());
		urunService.updateProduct(urun);
		
		
	}
	
	
	public int getSelectedlocId() {
		return selectedlocId;
	}


	public void setSelectedlocId(int selectedlocId) {
		this.selectedlocId = selectedlocId;
	}

	private List<Urun> urunler;

	
	
	


	
	public Urun getSelectedUrun() {
		return selectedUrun;
	}


	public void setSelectedUrun(Urun selectedUrun) {
		this.selectedUrun = selectedUrun;
	}


	public List<Urun> getUrunler() {
		return urunService.getUrunlerByKategoriId(selectedlocId);
	}
	
	public List<Urun> getUrunlerAll() {
		return urunService.getUrunler();
	}


	public void setUrunler(List<Urun> urunler) {
		this.urunler = urunler;
	}


	public List<Urun> getUrunListesi()
	{
		return urunler;
	}
	
	public List<Urun> FilterUrunlerByKategoriId()
	{
		return urunService.getUrunlerByKategoriId(selectedlocId);
	}
	
	
	public void findUrunByID(int id)
	
	{
		selectedUrun = urunService.findById(id);
		selectedUrunKategori = selectedUrun.getKategori();
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
}

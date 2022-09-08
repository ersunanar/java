package homework2.ersunanar.beans;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import homework2.ersunanar.business.*;
import homework2.ersunanar.entity.*;




@RequestScoped
@Named
public class UrunBean {
	
	private int selectedlocId;
	
	public int getSelectedlocId() {
		return selectedlocId;
	}


	public void setSelectedlocId(int selectedlocId) {
		this.selectedlocId = selectedlocId;
	}

	private List<Urun> urunler;
	
	@Inject
	private UrunService urunService;
	
	
	
	
	
	@PostConstruct
	public void createInitialData() {
		if (urunService.getUrunler().isEmpty()) {
			
			urunService.createInitialData();
				
		}

		
	
	}

	
	public List<Urun> getUrunler() {
		return urunService.getUrunlerByKategoriId(selectedlocId);
	}


	public void setUrunler(List<Urun> urunler) {
		this.urunler = urunler;
	}


	public List<Urun> getUrunListesi()
	{
		return urunler;
	}
	
	public List<Kategori> getKategoriList()
	{
		return urunService.getKategoriList();
	}
	
	public List<Urun> FilterUrunlerByKategoriId()
	{
		return urunService.getUrunlerByKategoriId(selectedlocId);
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
}

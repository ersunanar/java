package homework2.ersunanar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Urun {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String urunAdi;
	private double fiyat;
	
	@ManyToOne
	private Kategori kategori;
	
	
	
	
	@OneToOne(mappedBy = "urun")
	private SiparisDetay siparisDetay;
	
	
	@OneToMany(mappedBy = "urun")
	private List<Envanter> stokBilgisi = new ArrayList<Envanter>();
	
	
	
	public Urun() {
		// TODO Auto-generated constructor stub
	}



	public Urun(String urunAdi, double fiyat, Kategori kategori) {
		super();
		this.urunAdi = urunAdi;
		this.fiyat = fiyat;
		this.kategori = kategori;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUrunAdi() {
		return urunAdi;
	}



	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}



	public double getFiyat() {
		return fiyat;
	}



	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}



	public Kategori getKategori() {
		return kategori;
	}



	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}



	public SiparisDetay getSiparisDetay() {
		return siparisDetay;
	}



	public void setSiparisDetay(SiparisDetay siparisDetay) {
		this.siparisDetay = siparisDetay;
	}



	public List<Envanter> getStokBilgisi() {
		return stokBilgisi;
	}



	public void setStokBilgisi(List<Envanter> stokBilgisi) {
		this.stokBilgisi = stokBilgisi;
	}
	
	
	
	
	
}

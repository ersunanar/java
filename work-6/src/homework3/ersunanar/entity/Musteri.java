package homework3.ersunanar.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Musteri {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ad;
	private String soyad;
	private String telefon;
	private String cinsiyet;
	//private Date dogumTarihi;	
	private String eposta;
	
	@OneToMany(mappedBy = "musteri",cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private List<Adres> adresler = new ArrayList<Adres>();
	
	
	@OneToMany(mappedBy = "musteri")
	private List<Siparis> siparisler = new ArrayList<Siparis>();
	
	
	
	public Musteri() {
		// TODO Auto-generated constructor stub
	}



	public Musteri(String ad, String soyad, String telefon, String cinsiyet, String eposta) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.telefon = telefon;
		this.cinsiyet = cinsiyet;
		this.eposta = eposta;
	}
	
	
	
	
	
	
	
}


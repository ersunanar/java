package homework2.ersunanar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Adres {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ulke;
	private String sehir;
	private String ilce;
	private String mahalle;	
	private String sokak;
	private String apartmanNo;
	private String daireNo;
	private String postaKodu;
	private String adresTipi;
	//private boolean teslimatAdresiMi;
	//private boolean faturaAdresiMi;
	
	@ManyToOne
	private Musteri musteri;
	
	
	public Adres() {
		
	}


	public Adres(String ulke, String sehir, String ilce, String mahalle, String sokak, String apartmanNo,
			String daireNo, String postaKodu, String adresTipi) {
		super();
		this.ulke = ulke;
		this.sehir = sehir;
		this.ilce = ilce;
		this.mahalle = mahalle;
		this.sokak = sokak;
		this.apartmanNo = apartmanNo;
		this.daireNo = daireNo;
		this.postaKodu = postaKodu;
		this.adresTipi = adresTipi;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}

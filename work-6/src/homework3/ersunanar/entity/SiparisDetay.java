package homework3.ersunanar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SiparisDetay {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	private int adet;
	
	
	@OneToOne
	private Urun urun;
	
	
	
	@ManyToOne
	private Siparis siparis;
	
	
	public SiparisDetay() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}

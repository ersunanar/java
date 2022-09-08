package homework3.ersunanar.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Siparis {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date date;
	
	
	@ManyToOne
	private Musteri musteri;
	
	
	@ManyToOne
	private Magaza firma;	
	
	
	@OneToMany(mappedBy = "siparis")
	private List<SiparisDetay> siparisDetay = new ArrayList<SiparisDetay>();
	
	
	@OneToOne
	private Fatura fatura;
	
	
	
	
	
	
	
	public Siparis() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}

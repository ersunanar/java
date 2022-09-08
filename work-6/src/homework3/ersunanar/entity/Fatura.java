package homework3.ersunanar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Fatura {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double toplamTutar;
	
	
	
	@OneToOne(mappedBy = "fatura")
	private Siparis siparis;
	
	
	
	public Fatura() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	

}

package homework3.ersunanar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Envanter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	private Urun urun;
	
	@ManyToOne
	private Magaza firma;
	
	private int adet;
	
	
	
	
	public Envanter() {
		// TODO Auto-generated constructor stub
	}




	public Envanter(Urun urun, Magaza firma, int adet) {
		super();
		//this.urun = urun;
		this.firma = firma;
		this.adet = adet;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}



/*
	public Urun getUrun() {
		return urun;
	}




	public void setUrun(Urun urun) {
		this.urun = urun;
	}

*/


	public Magaza getFirma() {
		return firma;
	}




	public void setFirma(Magaza firma) {
		this.firma = firma;
	}




	public int getAdet() {
		return adet;
	}




	public void setAdet(int adet) {
		this.adet = adet;
	}




	@Override
	public String toString() {
		return "Envanter [firma=" + firma + ", adet=" + adet + "]";
	}
	
	
	
	

}

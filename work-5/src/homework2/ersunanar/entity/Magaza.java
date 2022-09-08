package homework2.ersunanar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Magaza {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int  id;
	private String unvan;
	private String telefon;
	//private Adres adres;
	
	
	
	
	
	@OneToMany(mappedBy = "firma")
	private List<Siparis> siparisler = new ArrayList<Siparis>();
	
	@OneToMany(mappedBy = "firma")
	private List<Envanter> stokBilgisi = new ArrayList<Envanter>();	
	
	public Magaza() {
		// TODO Auto-generated constructor stub
	}

	public Magaza(String unvan, String telefon) {
		super();
		this.unvan = unvan;
		this.telefon = telefon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnvan() {
		return unvan;
	}

	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Siparis> getSiparisler() {
		return siparisler;
	}

	public void setSiparisler(List<Siparis> siparisler) {
		this.siparisler = siparisler;
	}

	public List<Envanter> getStokBilgisi() {
		return stokBilgisi;
	}

	public void setStokBilgisi(List<Envanter> stokBilgisi) {
		this.stokBilgisi = stokBilgisi;
	}
	
	
	
	

}

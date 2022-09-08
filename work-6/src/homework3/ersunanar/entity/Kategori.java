package homework3.ersunanar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Kategori {
	
	
	@Override
	public String toString() {
		return "Kategori [id=" + id + ", kategori=" + kategori + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String kategori;
	
	@OneToMany(mappedBy = "kategori")
	private List<Urun> urunler = new ArrayList<Urun>();
	
	
	
	public Kategori() {
		// TODO Auto-generated constructor stub
	}

	public Kategori(String kategori) {
		super();
		this.kategori = kategori;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	
	
	
	
	
	
	
	
	
	

}

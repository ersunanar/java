package homework3.ersunanar.entity;


import java.security.MessageDigest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.DatatypeConverter;

import homework3.ersunanar.utils.IT526Utillty;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastName;
	private String username;
	private String password;
	private String role;
	
	public User(String name, String lastName, String username, String password,String role) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = IT526Utillty.hash(password);
		this.role = role;
	}
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = IT526Utillty.hash(password);
	}
	
	
	
	
}

package homework3.ersunanar.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import homework3.ersunanar.business.UrunService;
import homework3.ersunanar.business.UserService;
import homework3.ersunanar.entity.User;



@Named
@SessionScoped
public class LoginBean implements Serializable{
	
	@EJB
	private UserService userService;
	@EJB
	private UrunService urunService;
	
	private String username;
	private String password;
	
	private boolean loggedIn;
	private String role;
	
	private String accessPage;
	
	
	
	@PostConstruct
	public void init() {
	if (urunService.getUrunler().isEmpty()) {
		
		urunService.createInitialData();
		userService.addUser();
			
	}
	
	}
	
	public String mainPage() {		
		return "/mainpage";
	}
	
	
	public String urunListPage() {		
		return "/productlist";	
	}
	
	public String kategoriListPage() {		
		return "/categorylist";
	}
	
	public String urunEklePage() {		
		return "/secure/addproduct";	
	}
	
	public String kategoriEklePage() {		
		return "/secure/addcategory";	
	}
	
	public String urunGuncellePage() {		
		return "/secure/updateproduct";	
	}
	
	public String kategoriGuncellePage() {		
		return "/secure/updatecategory";	
	}

	public String login()
	{
		User user = userService.checkUser(username,password);
		//System.out.println( "HASH  --> " +IT526Utillty.hash("123"));
		if ( user != null)
		{
			this.loggedIn = true;
			
			if (accessPage == null) {
				return "secure/admin.xthml?faces-redirect=true";
				
			}
			else {
				System.out.println(accessPage);
				return accessPage+"?faces-redirect=true";
			}
			
		}
		FacesContext.getCurrentInstance().addMessage("Wrong credentials",
				new FacesMessage("Wrong credentials!!", "Please check username and password"));
		return "login";
	}
	
	public String logout()
	{
		this.loggedIn = false;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		System.out.println("User Logged out");
		accessPage = null;
		return "/mainpage"+"?faces-redirect=true";
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
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAccessPage() {
		return accessPage;
	}

	public void setAccessPage(String accessPage) {
		this.accessPage = accessPage;
	}
	
	
	

}

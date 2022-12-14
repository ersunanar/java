package homework2.ersunanar.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import homework2.ersunanar.business.UserService;
import homework2.ersunanar.entity.User;



@Named
@SessionScoped
public class LoginBean implements Serializable{
	
	@EJB
	private UserService userService;
	
	private String username;
	private String password;
	
	private boolean loggedIn;
	private String role;
	
	private String accessPage;
	
	public String login()
	{
		User user = userService.checkUser(username,password);
		//System.out.println( "HASH  --> " +IT526Utillty.hash("123"));
		if ( user != null)
		{
			this.loggedIn = true;
			return this.accessPage;
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
		return "/login";
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

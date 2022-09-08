package homework3.ersunanar.filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import homework3.ersunanar.beans.LoginBean;



/**
 * Servlet Filter implementation class SecureFolderFilter
 */
@WebFilter("/secure/*")
public class SecureFolderFilter implements Filter {


	@Inject
	private LoginBean loginBean;
   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse res = (HttpServletResponse)response;
		HttpServletRequest req = (HttpServletRequest)request;		
		if(loginBean == null || ! loginBean.isLoggedIn())
		{
			String page = req.getRequestURI().replace(req.getContextPath(), "");
			page = page.replace("\\.xhtml", "");
			loginBean.setAccessPage(page);
			System.out.println(page);
			res.sendRedirect(req.getContextPath()+"/login.xhtml");
			return;
		}	
		chain.doFilter(request, response);
	}
}

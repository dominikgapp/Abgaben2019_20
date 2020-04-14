package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FI
 */
@WebFilter("*")
public class FI implements Filter {


	/**
     * Default constructor. 
     */
    public FI() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request; 
		HttpServletResponse res = (HttpServletResponse) response; 
		
		String uri = req.getRequestURI(); 
		this.context.log("Requested Resource:" +uri); 
		HttpSession session = req.getSession(false); 
		
		if (session == null && ! uri.toLowerCase().contains("login") && ! uri.toLowerCase().contains("registrieren")) {
			this.context.log("Unauthorized access request"); 
			res.sendRedirect("login.jsp");
		}else {
		chain.doFilter(request, response);
		}
	}

	ServletContext context; 
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		context = fConfig.getServletContext(); 
	}

}

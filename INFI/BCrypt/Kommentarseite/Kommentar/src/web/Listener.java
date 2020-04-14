package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener("/*")
public class Listener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         
    	ServletContext ctx = sce.getServletContext(); 
    	
    	String dbname = ctx.getInitParameter("DBUser"); 
    	String pw = ctx.getInitParameter("PW"); 
    	String driver = ctx.getInitParameter("Driver"); 
    	String url = ctx.getInitParameter("URL"); 
    	
    	DBManager.getInstance().init(pw, dbname, driver, url);
    	
    	//ctx.getAttribute("DBManager", DBManager.getConnection());
    	
    	
    }
	
}

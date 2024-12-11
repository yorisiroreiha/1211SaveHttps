package controller;

import dao.PlayerDataDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DAOMakerListener
 *
 */
@WebListener
public class DAOMakerListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DAOMakerListener() {
    	
    }

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		application.removeAttribute("dao");
		System.out.println("System is Close");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		PlayerDataDAO dao = new PlayerDataDAO();
		ServletContext application = sce.getServletContext();
		application.setAttribute("dao",dao);
		System.out.println("Hello World");
	}
}

package controller;

import java.io.IOException;

import dao.PlayerDataDAO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class DAOCollFilter
 */
@WebFilter("/*")
public class DAOCollFilter extends HttpFilter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public DAOCollFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#doFilter(HttpServletRequest, HttpServletResponse, FilterChain)
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		ServletContext application = request.getServletContext();
		PlayerDataDAO dao = (PlayerDataDAO) application.getAttribute("dao");
		String msg = dao.active();
		System.out.println(msg);
		chain.doFilter(request, response);
	}

}



import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Menu1
 */
@WebServlet("/Menu1")
public class Menu1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // `Home.jsp` にフォワード
	    RequestDispatcher redi = req.getRequestDispatcher("menu1.jsp");
	    redi.forward(req, resp);
	}

	
}
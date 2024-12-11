package ex;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Fruit")
public class MainFruit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ex/fruit.jsp");
		dispatcher.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String tempPrice = req.getParameter("price");
		int price = Integer.parseInt(tempPrice);
		
		Fruit fruit = new Fruit();
		fruit.setName(name);
		fruit.setPrice(price);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("fruit2",fruit);
		req.setAttribute("fruit",fruit);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ex/fruit.jsp");
		dispatcher.forward(req, resp);
	}

}

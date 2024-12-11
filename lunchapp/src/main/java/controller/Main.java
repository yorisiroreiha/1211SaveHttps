package controller;

import java.io.IOException;
import java.util.List;

import dao.LunchDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Lunch;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LunchDAO dao = new LunchDAO();
		List<Lunch> list = dao.findAll();
		String dspath = "WEB-INF/view/Main.jsp";
		req.setAttribute("list",list);
		RequestDispatcher dispatcher = req.getRequestDispatcher(dspath);
		dispatcher.forward(req, resp);
	}
	
}

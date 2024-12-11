package controller;

import java.io.IOException;

import dao.LunchDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Lunch;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dsPath = "WEB-INF/view/Insert.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(dsPath);
		dispatcher.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String shop = req.getParameter("shop");
		String menu = req.getParameter("menu");
		Lunch lunch = new Lunch();
		lunch.setMenu(menu);
		lunch.setShop(shop);
		LunchDAO dao = new LunchDAO();
		dao.insertOne(lunch);
		HttpSession session = req.getSession();
		session.setAttribute("msg","1件登録しました。");
		resp.sendRedirect("Main");
	}
	
}

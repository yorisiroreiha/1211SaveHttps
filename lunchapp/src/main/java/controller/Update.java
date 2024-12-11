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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tempid = req.getParameter("id");
		if( tempid == null ) {
			resp.sendRedirect("Main");
			return ;
		}
		int id = Integer.parseInt(tempid);
		LunchDAO dao = new LunchDAO();
		Lunch lunch = dao.findOne(id);
		req.setAttribute("lunch",lunch);
		String dsPath = "WEB-INF/view/update.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(dsPath);
		dispatcher.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String tempid = req.getParameter("id");
		int id = Integer.parseInt(tempid);
		String shop = req.getParameter("shop");
		String menu = req.getParameter("menu");
		Lunch lunch = new Lunch(id,shop,menu);
		LunchDAO dao = new LunchDAO();
		dao.updateOne(lunch);
		HttpSession session = req.getSession();
		session.setAttribute("msg","1件変更しました。");
		resp.sendRedirect("Main");
	}
	
  }

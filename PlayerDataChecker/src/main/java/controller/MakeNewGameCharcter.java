package controller;

import java.io.IOException;

import dao.PlayerDataDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Data;

/**
 * Servlet implementation class MakeNewGameCharcter
 */
@WebServlet("/MakeNewGameCharcter")
public class MakeNewGameCharcter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tempId = req.getParameter("id");
		String dsPath = "" ;
		if( tempId == null) {
			dsPath = "AllPlayerCheck";
			resp.sendRedirect(dsPath);
		}
		PlayerDataDAO dao = new PlayerDataDAO();
		int id = Integer.parseInt(tempId);
		Data data = dao.findOne(id);
		req.setAttribute("data",data);
		dsPath  = "更新用JSP";
		RequestDispatcher dispatcher = req.getRequestDispatcher(dsPath);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}

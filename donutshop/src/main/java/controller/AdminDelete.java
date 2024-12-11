package controller;

import java.io.IOException;

import dao.DonutDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminDelete
 */
@WebServlet("/Admin/delete")
public class AdminDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tempId = req.getParameter("id");
		if( tempId != null) {
			DonutDAO dao = new DonutDAO();
			int id = Integer.parseInt(tempId);
			dao.deleteOne(id);
			req.setAttribute("msg", "1件削除しました");
		}
		RequestDispatcher rd=req.getRequestDispatcher("../Admin");
		rd.forward(req, resp);
	}
	
}

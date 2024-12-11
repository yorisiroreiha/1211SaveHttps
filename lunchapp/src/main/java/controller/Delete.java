package controller;

import java.io.IOException;

import dao.LunchDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
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
		dao.deleteOne(id);
		HttpSession session = req.getSession();
		session.setAttribute("msg","1件削除しました。");
		resp.sendRedirect("Main");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		super.doPost(req, resp);
	}
	
}

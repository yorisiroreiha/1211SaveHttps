package controller;

import java.io.IOException;

import dao.TodoDAO;
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
		String tempId = req.getParameter("id");
		if(tempId == null) {
			resp.sendRedirect("Main");
		}
		int id = Integer.parseInt(tempId);
		TodoDAO dao = new TodoDAO();
		dao.deleteOne(id);
		HttpSession session = req.getSession();
		session.setAttribute("msg","削除しました");
		resp.sendRedirect("Main");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		super.doPost(req, resp);
	}
	
}

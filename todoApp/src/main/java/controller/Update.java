package controller;

import java.io.IOException;

import dao.TodoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Todo;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tempId  = req.getParameter("id");
		if( tempId == null) {
			resp.sendRedirect("Main");
		}
		int id = Integer.parseInt(tempId);
		TodoDAO dao = new TodoDAO();
		Todo todo = dao.findOne(id);
		req.setAttribute("change",todo);
		String dsPath = "WEB-INF/view/Update.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(dsPath);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String tempImp = req.getParameter("importance");
		String tempId = req.getParameter("id");
		int importance = Integer.parseInt(tempImp);
		int id = Integer.parseInt(tempId);
		Todo todo = new Todo(id,title,importance);
		
		TodoDAO dao = new TodoDAO();
		dao.updateOne(todo);
		HttpSession session = req.getSession();
		session.setAttribute("msg","1件更新しました");
		
		resp.sendRedirect("Main");
	}


}

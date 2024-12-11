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
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dsPath = "WEB-INF/view/Insert.jsp" ;
		RequestDispatcher dispatcher = req.getRequestDispatcher(dsPath);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String temp = req.getParameter("importance");
		int importance = Integer.parseInt(temp);
		Todo todo = new Todo(title);
		todo.setImportant(importance);
		TodoDAO dao = new TodoDAO();
		dao.insertOne(todo);
		HttpSession session = req.getSession();
		session.setAttribute("msg","1件追加しました");
		
		resp.sendRedirect("Main");
	}


}

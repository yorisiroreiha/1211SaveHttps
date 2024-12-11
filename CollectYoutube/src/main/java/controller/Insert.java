package controller;

import java.io.IOException;

import dao.CollectYoutubeConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logic.CheckYoutube;
import model.Collections;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		String comment = req.getParameter("comment");
		Collections lunch = new Collections();
		CheckYoutube cyb = new CheckYoutube();
		body = cyb.execute(body);
		lunch.setTitle(title);
		lunch.setBody(body);
		lunch.setComment(comment);
		CollectYoutubeConnection dao = new CollectYoutubeConnection();
		dao.insertOne(lunch);
		HttpSession session = req.getSession();
		session.setAttribute("msg","1件登録しました。");
		resp.sendRedirect("Main");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/view/Add.jsp");
		dispatcher.forward(req, resp);
		
	}

}

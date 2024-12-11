package controller;

import java.io.IOException;

import dao.CollectYoutubeConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.CheckYoutube;
import model.Collections;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tempId = req.getParameter("id");
		if( tempId == null || tempId.isEmpty()) {
			resp.sendRedirect("/Main");
			return ;
		}
		int id = Integer.parseInt(tempId);
		CollectYoutubeConnection dao = new CollectYoutubeConnection();
		Collections collection = dao.findOne(id);
		System.out.println(collection.getId());
		req.setAttribute("collection",collection);
		String dsPath = "WEB-INF/view/update.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(dsPath);
		dispatcher.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String tempId = req.getParameter("id");
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		CheckYoutube cyb = new CheckYoutube();
		body = cyb.execute(body);
		String comment = req.getParameter("comment");
		int id = Integer.parseInt(tempId);
		CollectYoutubeConnection dao = new CollectYoutubeConnection();
		Collections colection = new Collections(id,title,body);
		colection.setComment(comment);
		dao.setOnt(colection);
		/*
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/view/Main.jsp");
		dispatcher.forward(req, resp);
		*/
		resp.sendRedirect("Main");
	}

}

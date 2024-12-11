package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.CollectYoutubeConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.UserNeedLogic;
import model.Collections;
import model.UserNeed;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String tempChoice = req.getParameter("choice");
		String temppage = req.getParameter("page");
		int page = temppage!=null?Integer.parseInt(temppage):1 ;
		List<Collections> list = new ArrayList<Collections>();
		if( title != null ) {
			int choice =  0 ;
			if( tempChoice != null) {
			choice = Integer.parseInt(tempChoice);
			}
			UserNeed und = new UserNeed(title,choice);
			und.setPage(page);
			UserNeedLogic unl = new UserNeedLogic();
			und.setList(unl.execute(und));
			und.setLimitList(unl.executeLimit(und));
			String msg = "";
			if(und.getList().isEmpty()) {
				msg = title+"を探しましたが見つかりませんでした";
			}else {
				msg = (page*12-11)+"~"+(page*12-12+und.getLimitList().size())+"/"+und.getList().size()+"件";
			}
			req.setAttribute("User", und);
			req.setAttribute("msg", msg);
		}else {
			CollectYoutubeConnection dao = new CollectYoutubeConnection();
			list = dao.findAll();
			req.setAttribute("Notitle", list);
		}
		String dsPath = "WEB-INF/view/Main.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(dsPath);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		String title = req.getParameter("title");
		String tempChoice = req.getParameter("choice");
		int choice = Integer.parseInt(tempChoice);
		UserNeed und = new UserNeed(title,choice);
		UserNeedLogic unl = new UserNeedLogic();
		und.setList(unl.execute(und));
		String msg = "";
		if(und.getList().isEmpty()) {
			msg = title+"を探しましたが見つかりませんでした";
		}
		req.setAttribute("User", und);
		req.setAttribute("msg", msg);
		doGet(req, resp);
		*/
	}
	
	
}

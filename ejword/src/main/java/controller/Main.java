package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.UserNeedLogic;
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
				msg = (page*20-19)+"~"+(page*20-20+und.getLimitList().size())+"/"+und.getList().size()+"件";
			}
			req.setAttribute("User", und);
			req.setAttribute("msg", msg);
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

package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carry;
import model.PIckUpLogic;


@WebServlet("/CurryMain")
public class MainControl extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String main = req.getParameter("main");
		Carry carry1 = new Carry(main);
		String timestemp = req.getParameter("times");
		int times = Integer.parseInt(timestemp);
		PIckUpLogic pul = new PIckUpLogic();
		pul.execute(carry1, times);
		req.setAttribute("carrys",carry1);
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/result.jsp");
		dispatcher.forward(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/form.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}

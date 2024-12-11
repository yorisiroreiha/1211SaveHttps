package pokerServlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/PokerCatchGodrop")
public class PokerCatchGodrop extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String select = req.getParameter("select");
		String disPath = "" ;
		if(select.equals("go")) {
			//PokerResultLogic
			disPath = "結果表示用URL";
		}else{
			disPath = "";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(disPath);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("welcomeページへ");
		dispatcher.forward(req, resp);
	}
	
}

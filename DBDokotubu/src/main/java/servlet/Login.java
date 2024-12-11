package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		User user = new User(name,pass);
		
		LoginLogic llc = new LoginLogic();
		boolean isLogin = llc.execute(user);
		
		if(isLogin) {
			HttpSession session = req.getSession();
			session.setAttribute("loginUser",user);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		super.doGet(req, resp);
	}


}

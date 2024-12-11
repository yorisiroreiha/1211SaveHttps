import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forwardPath = null ;
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		User registerUser = (User)session.getAttribute("registerUser");
		System.out.println("delete?");
		
		if( action == null ) {
			forwardPath="/FormJsp.jsp";
		}else if(action.equals("done")) {

			RegisterUserLogic logic = new RegisterUserLogic();
			logic.execute(registerUser);
			
			session.removeAttribute("registerUser");
			forwardPath="/registerDone.html";
			
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		User registerUser = new User(id,name,pass);
		
		HttpSession session = req.getSession();
		session.setAttribute("registerUser", registerUser);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}

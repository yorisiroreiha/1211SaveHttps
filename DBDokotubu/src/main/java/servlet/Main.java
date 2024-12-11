package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext application = this.getServletContext(); 
		List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
		
		if(mutterList == null) {
			mutterList = new ArrayList<>();
			application.setAttribute("mutterList",mutterList);
		}
		
		HttpSession session = req.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			resp.sendRedirect("index.jsp");
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/main.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String text = req.getParameter("text");
		
		if(text != null && text.length() != 0) {
			ServletContext application = this.getServletContext();
			List<Mutter> mls = (List<Mutter>)application.getAttribute("mutterList");
			
			HttpSession session = req.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			Mutter mutter = new Mutter(loginUser.getName(),text);
			
			PostMutterLogic pml = new PostMutterLogic();
			pml.execute(mutter, mls);
			
			application.setAttribute("mutterList", mls);
		}else{
			req.setAttribute("errorMsg","つぶやきがありません");
		}
	RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/main.jsp");
	dispatcher.forward(req,resp);
	}

}

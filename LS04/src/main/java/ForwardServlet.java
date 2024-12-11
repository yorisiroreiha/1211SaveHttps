

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Human;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/ForwardServlet")
public class ForwardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget");
		Human human = new Human("hathunemiku",16);
		request.setAttribute("human", human);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("WEB-INF/forword.jsp");
		dispatcher.forward(request, response);
	}

}

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
import model.Comment;
import model.PostCommentLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext application = this.getServletContext(); 
		List<Comment> commentList = (List<Comment>)application.getAttribute("commentList");
		
		if(commentList == null) {
			commentList = new ArrayList<>();
			application.setAttribute("commentList",commentList);
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
		String title = req.getParameter("title");
		String text = req.getParameter("text");
		
		if(title != null && title.length() != 0) {
			ServletContext application = this.getServletContext();
			List<Comment> mls = (List<Comment>)application.getAttribute("commentList");
			
			HttpSession session = req.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			Comment comment = new Comment(loginUser.getName(),title, text);
			System.out.println(comment.getUserName());
			System.out.println(comment.getTitle());
			System.out.println(comment.getText());
			
			PostCommentLogic pcl = new PostCommentLogic();
			pcl.execute(comment, mls);
			
			application.setAttribute("CommentList", mls);
		}else{
			req.setAttribute("errorMsg","タイトルがありません");
		}
	RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/main.jsp");
	dispatcher.forward(req,resp);
	}

}
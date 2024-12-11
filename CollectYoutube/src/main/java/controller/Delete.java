package controller;

import java.io.IOException;
import java.util.Arrays;

import dao.CollectYoutubeConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Collections;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tempId = req.getParameter("id");
		if(tempId==null) {
			resp.sendRedirect("Main");
		}
		int id = Integer.parseInt(tempId);
		CollectYoutubeConnection dao = new CollectYoutubeConnection();
		Collections collection = dao.findOne(id);
		req.setAttribute("collection",collection);
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/view/Delete.jsp");
		dispatcher.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tempId = req.getParameter("id");
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		String comment = req.getParameter("comment");
		String pass = req.getParameter("pass");
		String[] all = {tempId, title, body, comment, pass};
		
		String msg = "";
		String dsPath = "WEB-INF/view";
		// Streamを使ったnullチェック
		boolean hasNull = Arrays.stream(all).anyMatch(param -> param == null || param.isEmpty());

		if (hasNull) {
		    System.out.println("nullまたは空のパラメータがあります");
		    msg = "無効な処理があったため、最初に戻りました";
		    
		} else {
		    System.out.println("全てのパラメータが有効です");
		}
		
		/*まだ書き途中*/
		req.setAttribute("msg",msg);//予定
		RequestDispatcher dispatcher = req.getRequestDispatcher(dsPath);
		dispatcher.forward(req,resp);
	}
	
}

package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DateTimeLogic;
import model.Product;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO 自動生成されたメソッド・スタブ
		super.init(config);
		ServletContext  application = this.getServletContext();
		List<Product> list = new ArrayList<Product>();
		application.setAttribute("list",list);
		System.out.println("サーバースタートです");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String pricetemp = req.getParameter("price");
		int price = Integer.parseInt(pricetemp);
		Product pdt = new Product(name,price);
		ServletContext application = this.getServletContext();
		List<Product> list = (List<Product>)application.getAttribute("list");
		DateTimeLogic dtl = new DateTimeLogic();
		dtl.execute(pdt,list);
		application.setAttribute("list",list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, resp);
		
	}

	@Override
	public void destroy() {
		// TODO 自動生成されたメソッド・スタブ
		super.destroy();
		System.out.println("サーバーアウトです");
	}
	
	
}

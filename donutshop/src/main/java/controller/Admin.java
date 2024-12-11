package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import dao.DonutDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Donut;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
@MultipartConfig

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DonutDAO dao=new DonutDAO();
		List<Donut> list=dao.findAll();
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/main.jsp");
		rd.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String tempPrice = req.getParameter("price");
		int price = Integer.parseInt(tempPrice);
		Part part = req.getPart("imgname");
		String imgname = part.getSubmittedFileName();
		String path = getServletContext().getRealPath("upload");
		System.out.println(path);
		part.write(path+File.separator+imgname);
		DonutDAO dao=new DonutDAO();
		req.setAttribute("msg", "1件追加しました");
		dao.insertOne(new Donut(name,price,imgname));
		List<Donut> list=dao.findAll();
		req.setAttribute("list", list);
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/admin/main.jsp");
		rd.forward(req, resp);
	}

}

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
 * Servlet implementation class AdminUpdate
 */
@WebServlet("/Admin/update")
@MultipartConfig
public class AdminUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tempId = req.getParameter("id");
		if(tempId==null) {
			resp.sendRedirect("Admin");
			return ;
		}
		int id = Integer.parseInt(tempId);
		Donut donut = new DonutDAO().findOne(id);
		req.setAttribute("donut",donut);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/update.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		String orgname=req.getParameter("orgname");
		Part part=req.getPart("imgname");
		String imgname;
		if(part.getSize()==0) {
			imgname=orgname;
		}else {
			imgname=part.getSubmittedFileName();
			String path=getServletContext().getRealPath("/upload");
			part.write(path+File.separator+imgname);
		}
		DonutDAO dao=new DonutDAO();
		dao.updateOne(new Donut(Integer.parseInt(id),name,Integer.parseInt(price),imgname));
		List<Donut> list=dao.findAll();
		req.setAttribute("list", list);
		req.setAttribute("msg", "1件更新しました");
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/admin/main.jsp");
		rd.forward(req, resp);
	}

}

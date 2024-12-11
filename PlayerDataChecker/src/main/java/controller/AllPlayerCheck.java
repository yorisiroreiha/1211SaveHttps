
package controller;

import java.io.IOException;
import java.util.List;

import dao.PlayerDataDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Data;

/**
 * Servlet implementation class AllPlayerCheck
 */
@WebServlet("/AllPlayerCheck")
public class AllPlayerCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dsPath = "/WEB-INF/AdminJSP/AllPlayerList.jsp" ;
		PlayerDataDAO dao  = quickDao(req);
		List<Data> list = dao.findAll() ;
		System.out.println(list.size());
		req.setAttribute("dataList",list);
		RequestDispatcher dispatcher = req.getRequestDispatcher(dsPath);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PlayerDataDAO dao = quickDao(req);
		String tempId =  req.getParameter("id");
		String Name =  req.getParameter("name");
		String pass =  req.getParameter("pass");
		String tempSTR =  req.getParameter("STR");
		String tempCON =  req.getParameter("CON");
		String tempDEX =  req.getParameter("DEX");
		String tempAGI =  req.getParameter("AGI");
		String tempINT =  req.getParameter("INT");
		String tempSEC =  req.getParameter("SEC");
		String tempMET =  req.getParameter("MET");
		String tempLUC =  req.getParameter("LUC");
		
		String[] temps = {tempId,tempSTR,tempCON,tempDEX,tempAGI,tempINT,tempSEC,tempMET,tempLUC};
		int[] status = new int[9];
		for(int i = 0 ; i < temps.length ; i++ ) {
			if(temps[i] == null) {
				System.out.println("Error:request is null ");
				this.doGet(req, resp);
			}else {
				status[i] = Integer.parseInt(temps[i]); 
			}
		}
		
		Data data = new Data(status[0],Name,pass,status[1],status[2],status[3],status[4],status[5],status[6],status[7],status[8]);
		dao.InsertOne(data);
		
		this.doGet(req, resp);
		
	}
	
	private PlayerDataDAO quickDao(HttpServletRequest req) {
		ServletContext application = req.getServletContext();
		PlayerDataDAO dao  = (PlayerDataDAO) application.getAttribute("dao");
		return dao;
	}
	
}

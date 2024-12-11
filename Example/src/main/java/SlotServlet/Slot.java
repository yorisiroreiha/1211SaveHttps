package SlotServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/slot")
public class Slot extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int[] playerNumber = new int[3] ;
		for( int i = 0  ; i < playerNumber.length ; i++ ) {
			int number = new Random().nextInt(9)+1;
			playerNumber[i] = number ;
		}
		HashSet<Integer> hs = new HashSet<>();
		for( int i = 0 ; i < playerNumber.length ; i++ ) {
			hs.add(playerNumber[i]);
		}
		String player = "Null";
		int temp = 0;
		if( hs.size() == 1) {
			for (Integer n : hs) {
	            int addPoint = n *1000 ;
	            temp += addPoint ;
	        }
			player = "Win:" + temp ;
		}else if( hs.size() == 2 ){
			for (Integer n : hs) {
	            int addPoint = n *20 ;
	            temp += addPoint ;
	        }
			player = "Lose Win:" + temp ;
		}else {
			for (Integer n : hs) {
	            int addPoint = n *1 ;
	            temp += addPoint ;
	        }
			player = "Lose:" + temp ;
		}
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/destyle.css@3.0.2/destyle.css\">");
		out.println("<link rel=\"stylesheet\" href=\"CSS/main.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"allcontent\">");
		out.println("<h1>スロットゲーム</h1>");
		out.println("<div id=\"itemp\">");
		out.println("<h2>あなた</h2>");
		out.printf("<h3>%d%d%d</h3>%n",playerNumber[0],playerNumber[1],playerNumber[2]);
		out.printf("<p>%s</p>%n",player);
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
	
}

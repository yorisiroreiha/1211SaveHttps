import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nya")
public class HelloServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8") ;
		PrintWriter out = response.getWriter() ;
		Scanner sca = new Scanner(System.in);
		String[] fortunes = {"大吉","中吉","小吉","吉","凶"};
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>タイトル</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>こんにちは</p>");
		out.print("<p>あなたの名前を入力してください＞＞</p>");
		String name = sca.nextLine();
		int n = new Random().nextInt(5);
		out.printf("<p>%sの運勢は%sです</p>",name,fortunes[n]);
		out.println("</body>");
		out.println("</html>");
		sca.close();
	}

}

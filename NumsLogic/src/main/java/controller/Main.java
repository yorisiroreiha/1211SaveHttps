package controller;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import number.Number;
import number.checker;

@WebServlet("/NUMBERSCHECK")
public class Main extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションを取得
		HttpSession session = request.getSession();

		// 1から99までのランダムな数値を生成
		int random = new Random().nextInt(99) + 1;
		System.out.println("test");
		// セッションから 'player' を取得
		Number player = (Number) session.getAttribute("player");

		// player が null なら新しく生成してセッションにセットする
		if (player == null) {
		    player = new Number(); // 必要に応じて適切なコンストラクタを使用
		    session.setAttribute("player", player);
		}

		// player が確実に存在するため、メソッドを呼び出せる
		player.setBaseNumber(random);

		// リクエストを次のページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Game.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        String playerNumberTemp = request.getParameter("playerNumber");
	        int playerNumber = Integer.parseInt(playerNumberTemp);

	        HttpSession session = request.getSession();
	        Number player = (Number) session.getAttribute("player");

	        if (player == null) {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Player object is not found in the session.");
	            return;
	        }

	        player.setPlayerNumber(playerNumber);

	        checker a = new checker();
	        String checkTemp = a.jg(player, playerNumber == 0 ? 0 : playerNumber);
	        player.setCheck(checkTemp);

	        String pass = checkTemp.equals("Bingo") ? "/WEB-INF/jsp/EndGame.jsp" : "/WEB-INF/jsp/Game.jsp";

	        player.setCount(player.getCount() + 1);

	        RequestDispatcher dispatcher = request.getRequestDispatcher(pass);
	        dispatcher.forward(request, response);

	    } catch (NumberFormatException e) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid player number format.");
	    }
	}


}

package pokerServlet;

import java.io.IOException;
import java.util.ArrayList;

import gameApp.PokerChargeLogic;
import gameApp.PokerFirstLogic;
import gameApp.PokerTrashLogic;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Card;
import model.Deck;
import model.Player;


@WebServlet("/PokerMain")
public class PokerMain extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Player user = (Player)session.getAttribute("PlayerDate");
		String disPath = "" ;
		if(user==null) {
			disPath = "メイン画面に戻すURL";
		}else{
			PokerFirstLogic pfl = new PokerFirstLogic();
			ArrayList<Card> temp = pfl.execute(user);
			Deck deck = new Deck();
			deck.setDeck(temp);
			session.setAttribute("deck",deck);
			disPath ="ゲーム画面に移行";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(disPath);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("UTF-8");
		HttpSession session = req.getSession();
		Player user = (Player)session.getAttribute("playerDate");
		String disPath = "goDrop画面に飛ぶURL" ;
		String[] selects = req.getParameterValues("select");
		if(selects.length != 0) {
			PokerTrashLogic ptl = new PokerTrashLogic();
			PokerChargeLogic pcl = new PokerChargeLogic();
			Deck deck =(Deck) req.getAttribute("deck");
			ptl.execute(user, selects);
			pcl.execute(user, deck.getDeck(), selects.length);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(disPath);
		dispatcher.forward(req, resp);
	}
}

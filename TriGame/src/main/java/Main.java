import java.io.IOException;
import java.util.Random;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import stacker.CountAll;
import stacker.Judgement;
import stacker.Messege;

@WebServlet("/TriGame")
public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // セッションから CountAll オブジェクトを取得し、存在しない場合は新規作成
        CountAll ca = (CountAll) session.getAttribute("ca");
        Messege mes = new Messege();
        session.setAttribute("mes",mes);
        if (ca == null) {
            ca = new CountAll();
            session.setAttribute("ca", ca);
        }

        // ユーザーの手を取得
        String hand = req.getParameter("hand");
        mes.setPlayerHand(hand);
        // 敵の手をランダムに決定 (0: グー, 1: チョキ, 2: パー)
        int enemyHand = new Random().nextInt(3);


        Judgement jm = new Judgement();
        mes.setEnemyHand(jm.chengeEnemy(enemyHand));
        // 勝敗判定
        String result = jm.jg(hand, enemyHand);

        // 勝敗のカウントを更新
        switch (result) {
            case "Drow":
                ca.setDrow(ca.getDrow() + 1);
                mes.setMessege("Drow");
                break;
            case "Win":
                ca.setWin(ca.getWin() + 1);
                mes.setMessege("Win");
                break;
            default:
                ca.setLose(ca.getLose() + 1);
                mes.setMessege("Lose");
                break;
        }

        // JSP ページにフォワード
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Main.jsp");
        dispatcher.forward(req, resp);
    }
}

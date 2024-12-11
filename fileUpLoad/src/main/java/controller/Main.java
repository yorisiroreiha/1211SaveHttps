package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/Main")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10) // 最大ファイルサイズを10MBに設定
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/form.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String word = request.getParameter("word");

        Part part = request.getPart("pict");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String uploadPath = getServletContext().getRealPath("/upload");

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // ディレクトリが存在しない場合は作成
        }

        try {
            // ファイルを指定したディレクトリに保存
            part.write(uploadPath + File.separator + filename);
        } catch (IOException e) {
            // エラーハンドリング: エラーメッセージをログに出力
            e.printStackTrace();
            request.setAttribute("error", "ファイルのアップロードに失敗しました。");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/form.jsp");
            rd.forward(request, response);
            return;
        }

        request.setAttribute("name", name);
        request.setAttribute("word", word);
        request.setAttribute("filename", filename);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/result.jsp");
        rd.forward(request, response);
    }
}

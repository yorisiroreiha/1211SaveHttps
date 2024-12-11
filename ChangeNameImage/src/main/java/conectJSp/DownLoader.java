package conectJSp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Downloader")
public class DownLoader extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 画像が保存されているディレクトリのパス（サーバー上のパスに合わせてください）
        ServletContext context = getServletContext();
        String imageDirPath = context.getRealPath("/WEB-INF/Images");
        File imageDir = new File(imageDirPath);
        // 画像ファイルのリストを動的に取得
        File[] imageFiles = imageDir.listFiles((dir, name) -> {
            // 拡張子を確認して画像ファイルのみを対象にする
            return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".gif") || name.endsWith(".JPG");
        });

        // レスポンスの設定
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=\"images.zip\"");

        try (ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream())) {
        	int fileCount = 1;
            for (File imageFile : imageFiles) {
                // 各画像ファイルをZIPエントリとして追加
                String newFileName = "image_" + fileCount + getFileExtension(imageFile.getName());

                // ZIPエントリに新しいファイル名をセット
                zipOut.putNextEntry(new ZipEntry(newFileName));

                // 画像ファイルの内容をZIPエントリに書き込む
                try (FileInputStream inStream = new FileInputStream(imageFile)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;

                    while ((bytesRead = inStream.read(buffer)) != -1) {
                        zipOut.write(buffer, 0, bytesRead);
                    }


                    zipOut.closeEntry();
                }
            }
        }
    }
    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex);
    }
}

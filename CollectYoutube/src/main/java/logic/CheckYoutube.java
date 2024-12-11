package logic;

public class CheckYoutube {
    public String execute(String body) {
        String newBody = "";
        if (body == null || body.isEmpty()) {
            return body; // 空文字列または null の場合はそのまま返す
        }

        // YouTubeのURLを判別するための正規表現
        String youtubePattern = "^(https?://)?(www\\.)?(youtube\\.com/watch\\?v=|youtu\\.be/)([\\w-]+)";
        
        // 正規表現でURLをマッチング
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(youtubePattern);
        java.util.regex.Matcher matcher = pattern.matcher(body);

        if (matcher.find()) {
            // マッチした場合は埋め込み用のURLを作成
            newBody = "https://www.youtube.com/embed/" + matcher.group(4);
        } else {
            // マッチしなかった場合は元のURLをそのまま返す
            newBody = body;
        }

        return newBody;
    }
}

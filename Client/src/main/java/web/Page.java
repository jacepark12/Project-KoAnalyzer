package web;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Formatter;

public class Page {
    private Document main = null;
    private URL apiUrl;

    public Page(URL url) throws MalformedURLException {
        this.apiUrl = formatReadabilityURL(url);
    }

    public Document mainArticle() throws IOException {
        if (main != null) return main;

        main = new Document(
                Jsoup
                        .connect(apiUrl.toString())
                        .ignoreContentType(true)
                        .timeout(5000)
                        .execute()
                        .body()
        );

        return main;
    }

    private URL formatReadabilityURL(URL url) throws MalformedURLException {
        // Readability API Used.
        // Account Info: junhoseo@outlook.com
        final String apiBaseUrl = "https://www.readability.com/api/content/v1/parser?url=%s&token=%s";
        final String token = "ba58f845701cb7d7960e3b5496daf1e5a25dd060";

        StringBuilder parseAPI = new StringBuilder();
        Formatter formatter = new Formatter(parseAPI);
        formatter.format(apiBaseUrl, url, token);

        URL result = new URL(parseAPI.toString());
        return result;
    }
}
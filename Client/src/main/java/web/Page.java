package web;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Formatter;

public class Page {
    private String mainDocStr = "";
    private JSONObject mainDocJSON = null;
    private String mainArticle = "";
    private String url = "";

    //TODO: Create URL Class
    public Page(String url) {
        this.url = url;
    }

    public JSONObject mainArticle() {
        //TODO: Replace Readability API with Original Algorithm as Readability has capacity limit.
        // Readability API Used.
        // Acount Info: junhoseo@outlook.com
        //TODO: Save test data to files so that we can reduce capcity limit problem.
        final String parseAPIbase = "https://www.readability.com/api/content/v1/parser?url=%s&token=%s";
        final String token = "ba58f845701cb7d7960e3b5496daf1e5a25dd060";

        StringBuilder parseAPI = new StringBuilder();
        Formatter formatter = new Formatter(parseAPI);
        formatter.format(parseAPIbase, url, token);

        if (mainDocStr.isEmpty()) {
            try {
                mainDocStr = Jsoup
                        .connect(parseAPI.toString())
                        .ignoreContentType(true)
                        .timeout(5000)
                        .execute()
                        .body();
                try {
                    mainDocJSON = new JSONObject(mainDocStr);
                } catch (JSONException e) {
                    System.out.println(e.getMessage());
                    return null;
                }

            } catch (IOException e) {
                System.out.println(this.getClass().getName()
                        + ": " + url
                        + ": " + parseAPI.toString()
                        + ": " + e.getMessage());
                return new JSONObject();
            }
        }

        return mainDocJSON;
    }
}
package web.searcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO: Pages Support.
//TODO: Limit Maximum Result
public class GoogleSearcher implements Searcher {
    private String baseURL = "https://www.google.com/search?q=";
    private String userAgent = "Mozilla/5.0";

    public GoogleSearcher() {
    }

    @Override
    public Result search(Query query) {
        return search(query, 1);
    }

    @Override
    public Result search(Query query, int pages) {
        List<Document> doc = getSearchPage(query, pages);
        if (doc.contains(null)) {
            return null;
        } // Dirty

        return extractURLs(doc);
    }

    private List<Document> getSearchPage(Query query, int pages) {
        try {
            List<Document> docs = new ArrayList<Document>();
            for (int i = 0; i < pages; i++) {
                int start = i*10;
                Document doc = Jsoup
                        .connect(baseURL + query.get() + "&start=" + String.valueOf(start))
                        .userAgent(userAgent) // Google rejects request without user agent info.
                        .timeout(5000).get();
                docs.add(doc);
            }

            return docs;
        } catch (IOException e) {
            //TODO: Implement logging System
            System.out.println(this.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    private Result extractURLs(List<Document> docs) {
        List<String> urls = new ArrayList<String>();
        for (Document doc : docs) {
            List<String> list = new ArrayList<String>();
            Elements links = doc.body().select("h3.r > a[href]");
            for(Element elem : links) {
                String url = elem.attr("href");
                url = parseURL(url);
                if (!url.isEmpty()) {
                    list.add(url);
                }
            }
            urls.addAll(list);
        }

        return new Result(urls);
    }

    private String parseURL(String url) {
        String regexFullURL = "^\\/url\\?q=(https?://.+)&sa=.+$";
        Pattern urlPattern = Pattern.compile(regexFullURL);
        Matcher urlMatcher = urlPattern.matcher(url);

        if(urlMatcher.find()) {
            return urlMatcher.group(1);
        }
        return "";
    }
}

package web.searcher;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Query {
    private String query = "";

    public Query(String str) {
        try {
            query = URLEncoder.encode(str, "utf-8");
        } catch(UnsupportedEncodingException e) {
            //TODO: Create Logger
            System.out.println(this.getClass().getName() + ": " + e.getMessage());
        }
    }

    public String get() {
        return query;
    }
}

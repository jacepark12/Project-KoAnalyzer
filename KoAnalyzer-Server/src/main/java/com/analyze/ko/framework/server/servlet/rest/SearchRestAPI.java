package com.analyze.ko.framework.server.servlet.rest;

import com.analyze.ko.framework.server.util.FileIO;
import com.analyze.ko.framework.server.web.Page;
import com.analyze.ko.framework.server.web.searcher.GoogleSearcher;
import com.analyze.ko.framework.server.web.searcher.Query;
import com.analyze.ko.framework.server.web.searcher.Result;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by parkjaesung on 2016. 7. 22..
 */

@Path("/search")
public class SearchRestAPI {

    @GET
    @Produces("application/json"+ ";charset=utf-8")
    @Path("/google/keyword={keyword}&num={num}") //save -> true or false
    public String startWebCrawling(@PathParam("keyword")final String keyword, @PathParam("num")final int num){
        JSONObject resultJSON = new JSONObject();
        String searchResult = "";
        GoogleSearcher searcher = new GoogleSearcher();
        Result urls = searcher.search(new Query(keyword));

        resultJSON.put("keyword", keyword);

        for (int i = 0; urls.hasNext(); i++) {
            String url = urls.next();
            Page page = new Page(url);
            try {
                searchResult+= page.mainArticle().get("content").toString();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        FileIO fileIO = FileIO.getInstance();

        resultJSON.put("idx" ,fileIO.savetoDoc(searchResult));
        resultJSON.put("searchResult", resultJSON);

        return resultJSON.toString();
    }
}

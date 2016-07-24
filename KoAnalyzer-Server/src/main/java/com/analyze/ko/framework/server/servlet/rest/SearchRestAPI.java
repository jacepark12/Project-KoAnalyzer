package com.analyze.ko.framework.server.servlet.rest;

import com.analyze.ko.framework.server.web.Page;
import com.analyze.ko.framework.server.web.searcher.GoogleSearcher;
import com.analyze.ko.framework.server.web.searcher.Query;
import com.analyze.ko.framework.server.web.searcher.Result;

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
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/google/keyword={keyword}&num={num}")
    public String startWebCrawling(@PathParam("keyword")final String keyword, @PathParam("num")final int num){

        /*String result = "";
        GoogleSearcher searcher = new GoogleSearcher();
        Result urls = searcher.search(new Query(keyword));

        for (int i = 0; urls.hasNext(); i++) {
            String url = urls.next();
            Page page = new Page(url);
            try {
                result+= page.mainArticle().get("content").toString();
            //    out.write(page.mainArticle().get("content").toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }*/
        String result = "test";

        return result;
    }
}

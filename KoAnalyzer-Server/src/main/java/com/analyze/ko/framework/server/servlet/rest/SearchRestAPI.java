package com.analyze.ko.framework.server.servlet.rest;

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
        return "keyword : " + keyword + "\n" + "num : " + num;
    }
}

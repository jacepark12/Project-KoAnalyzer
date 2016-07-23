package com.analyze.ko.framework.server.servlet.rest;

import javax.annotation.Generated;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;

/**
 * Created by parkjaesung on 2016. 7. 23..
 */
@Path("/analyze")
public class AnalyzeRestAPI extends HttpServlet {

    @GET
    @Path("/document/q={document}")
    @Produces()
    public void analyzeDoucment(@PathParam("document")final String document){

    }

    @GET
    @Path("/setence/q={sentence}")
    public void analyzeSentence(@PathParam("sentence")final String sentence){

    }
}

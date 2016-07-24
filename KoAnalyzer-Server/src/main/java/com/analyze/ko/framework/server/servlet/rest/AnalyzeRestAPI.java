package com.analyze.ko.framework.server.servlet.rest;

import javax.annotation.Generated;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by parkjaesung on 2016. 7. 23..
 */
@Path("/analyze")
public class AnalyzeRestAPI {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/document/q={document}")
    public String analyzeDoucment(@PathParam("document")final String document){
        System.out.println("analyze document");

        return "Document analyze";
    }

    @GET
    @Path("/sentence/q={sentence}")
    @Produces()
    public String analyzeSentence(@PathParam("sentence")final String sentence){
        System.out.println("sentence analyze");
        return "sentence analyze";
    }
}

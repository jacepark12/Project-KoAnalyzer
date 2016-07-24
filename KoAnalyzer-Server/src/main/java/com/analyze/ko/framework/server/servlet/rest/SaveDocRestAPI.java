package com.analyze.ko.framework.server.servlet.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by parkjaesung on 2016. 7. 24..
 */
@Path("/save")
public class SaveDocRestAPI {

    @GET
    @Path("/document/q={doc}")
    @Produces(MediaType.TEXT_PLAIN)
    public String saveDocument(@PathParam("doc")final String doc){
        String currentDirectory = System.getProperty("user.dir");
        String idx = UUID.randomUUID().toString();
        String outPutFileDirectory = currentDirectory + "/KoAnalyzer-Server/src/main/resources/DataDocuments/"+ idx +".txt";

        FileWriter fw;

        FileWriter out;
        try {
            out = new FileWriter(outPutFileDirectory);
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return "saving doc failed. Please check log and stacktrace";
        }

        try {
            out.write(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return "Saving Document has been successed! \n Document idx : " + idx;
    }
}


package com.analyze.ko.framework.server.servlet.rest;

import com.analyze.ko.framework.server.manager.DocumentFile;
import com.analyze.ko.framework.server.manager.FileManager;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by parkjaesung on 2016. 7. 24..
 */
@Path("/files")
public class DocFileListRestAPI {

    @GET
    @Path("/documents")
    @Produces("application/json")
    public String getDocFiles(){
        JSONObject resultJSON = new JSONObject();
        JSONArray docFilesJSON = new JSONArray();
        FileManager fileManager = FileManager.getInstance();

        ArrayList<DocumentFile> docFiles = fileManager.getDocumentFiles();

        for (DocumentFile docFIle : docFiles) {
            JSONObject docFileJSON = new JSONObject();

            docFileJSON.put("idx", docFIle.getIdx());
            docFileJSON.put("text", docFIle.getText());

            docFilesJSON.put(docFileJSON);
        }
        resultJSON.put("saved documents", docFilesJSON);

      //  String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + resultJSON;
      //  return Response.status(200).entity(result).build();
        return resultJSON.toString();
    }
}

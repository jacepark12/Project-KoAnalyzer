package com.jsspark.kopinion.server;

import com.sun.jersey.server.impl.application.WebApplicationContext;
import com.sun.xml.internal.ws.handler.HandlerException;
import javafx.scene.web.WebEngineBuilder;
import org.apache.solr.client.solrj.SolrServerException;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by parkjaesung on 2016. 7. 19..
 */
public class ServerMain {

    public static void main(String[] args) throws IOException, SolrServerException {

        Server server = new Server(8080);

        WebAppContext webAppContext = new WebAppContext();

        webAppContext.setResourceBase("src/main/webapp");
        webAppContext.setContextPath("/");
      //  webAppContext.setDescriptor("WEB-INF/web.xml");
     //  webAppContext.setDefaultsDescriptor("/Users/parkjaesung/Documents/Github/Project-Kopinion/Project-Kopinion/DBServer/src/main/webdefault/webdefault.xml");

        // Adding the handlers to the server
        server.setHandler(webAppContext);

        // Starting the Server
        try {
            server.start();
            System.out.println("Started!");
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

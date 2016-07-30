package com.analyze.ko.framework.server;

import com.analyze.ko.framework.server.manager.DocumentFile;
import com.analyze.ko.framework.server.manager.FileManager;
import com.analyze.ko.framework.server.util.FileIO;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;
import java.io.*;
public class EmbeddedJettyWebXmlConfigurationMain {

	private static String currentDirectory = System.getProperty("user.dir");
	private static String documentFilesDirectory = currentDirectory + "/KoAnalyzer-Server/src/main/resources/DataDocuments/";
	private static String webdefaultDirectory = currentDirectory + "/KoAnalyzer-Server/src/main/webdefault/webdefault.xml";

	public static void main(String[] args) throws Exception {
		FileIO fileIO = FileIO.getInstance();
		FileManager fileManager = FileManager.getInstance();

		System.out.println("documentFilesDirectory : "+ documentFilesDirectory);
		Server server = new Server(8080);

		//Initialize FileManager
		File documentFilesDir = new File(documentFilesDirectory);
		File documentFiles[] = documentFilesDir.listFiles();

		if(documentFiles != null) {
			System.out.println("documentFiles length : " + documentFiles.length);
			for (File documentFile : documentFiles) {
				//System.out.println("docfiles");
				DocumentFile docFile = new DocumentFile();

				docFile.setText(fileIO.readFile(documentFile.getPath()));
				docFile.setIdx(documentFile.getName());

				fileManager.addDocumentFile(docFile);
			}
		}

		// Handler for multiple web apps
		HandlerCollection handlers = new HandlerCollection();

		// Creating the first web application context
		WebAppContext webapp1 = new WebAppContext();
		webapp1.setResourceBase("KoAnalyzer-Server/src/main/webapp1");
		webapp1.setContextPath("/KoAnalyze");
		webapp1.setDefaultsDescriptor(webdefaultDirectory);

		handlers.addHandler(webapp1);

		// Creating the second web application context
		WebAppContext webapp2 = new WebAppContext();
		webapp2.setResourceBase("KoAnalyzer-Server/src/main/webapp2");
		webapp2.setContextPath("/webapp2");
		webapp2.setDefaultsDescriptor(webdefaultDirectory);
		handlers.addHandler(webapp2);

		// Adding the handlers to the server
		server.setHandler(handlers);

		// Starting the Server
		server.start();
		System.out.println("Started!");
		server.join();


	}
}

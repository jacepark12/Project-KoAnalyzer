package com.analyze.ko.framework.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

public class EmbeddedJettyWebXmlConfigurationMain {

	public static void main(String[] args) throws Exception {

		Server server = new Server(8080);

		// Handler for multiple web apps
		HandlerCollection handlers = new HandlerCollection();

		// Creating the first web application context
		WebAppContext webapp1 = new WebAppContext();
		webapp1.setResourceBase("KoAnalyzer-Server/src/main/webapp1");
		webapp1.setContextPath("/KoAnalyze");
		webapp1.setDefaultsDescriptor("KoAnalyzer-Server/src/main/webdefault/webdefault.xml");

		handlers.addHandler(webapp1);

		// Creating the second web application context
		WebAppContext webapp2 = new WebAppContext();
		webapp2.setResourceBase("KoAnalyzer-Server/src/main/webapp2");
		webapp2.setContextPath("/webapp2");
		webapp2.setDefaultsDescriptor("KoAnalyzer-Server/src/main/webdefault/webdefault.xml");
		handlers.addHandler(webapp2);

		// Adding the handlers to the server
		server.setHandler(handlers);

		// Starting the Server
		server.start();
		System.out.println("Started!");
		server.join();

	}
}

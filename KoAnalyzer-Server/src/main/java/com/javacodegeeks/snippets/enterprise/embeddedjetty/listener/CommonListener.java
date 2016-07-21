package com.javacodegeeks.snippets.enterprise.embeddedjetty.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CommonListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context initialized:"+sce.getServletContext().getContextPath());

	}

	public void contextDestroyed(ServletContextEvent sce) {
		

	}

}

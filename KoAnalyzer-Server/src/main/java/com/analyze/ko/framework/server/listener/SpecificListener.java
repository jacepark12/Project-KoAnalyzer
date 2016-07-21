package com.analyze.ko.framework.server.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpecificListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Specific Context initialized:"+sce.getServletContext().getContextPath());
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}

package de.claudioaltamura.jetty.webannotations;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class HelloWorldServletContextListener implements ServletContextListener {


	private static final Logger LOG = LoggerFactory.getLogger(HelloWorldServletContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		LOG.info("context initialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		LOG.info("context destroyed");
	}

}
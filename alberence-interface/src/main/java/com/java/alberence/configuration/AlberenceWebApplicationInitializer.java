package com.java.alberence.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AlberenceWebApplicationInitializer extends AbstractWebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		loadRootApplicationContext(servletContext, AlberenceDomainApplicationContextConfig.class);
		loadDefaultFilters(servletContext);
		addDispatcherServlet(servletContext, "webServlet", AlberenceWebServletApplicationContextConfig.class, "/");
	}
}

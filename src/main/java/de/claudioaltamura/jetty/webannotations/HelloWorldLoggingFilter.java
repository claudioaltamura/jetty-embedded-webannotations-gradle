package de.claudioaltamura.jetty.webannotations;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(urlPatterns = {"/*"})
public class HelloWorldLoggingFilter implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(HelloWorldLoggingFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		Map<String, String> requestMap = this.getTypesafeRequestMap(httpServletRequest);

		StringBuilder logMessage = new StringBuilder().append("[HTTP METHOD:")
				.append(httpServletRequest.getMethod()).append("] [PATH INFO:").append(httpServletRequest.getRequestURI())
				.append("] [REQUEST PARAMETERS:").append(requestMap).append("]");

		chain.doFilter(httpServletRequest, httpServletResponse);

		LOG.info(logMessage.toString());
	}

	private Map<String, String> getTypesafeRequestMap(HttpServletRequest request) {
		Map<String, String> typesafeRequestMap = new HashMap<>();
		Enumeration<?> requestParamNames = request.getParameterNames();
		while (requestParamNames.hasMoreElements()) {
			String requestParamName = (String) requestParamNames.nextElement();
			String requestParamValue = request.getParameter(requestParamName);
			typesafeRequestMap.put(requestParamName, requestParamValue);
		}
		return typesafeRequestMap;
	}

	@Override
	public void destroy() {
	}

}

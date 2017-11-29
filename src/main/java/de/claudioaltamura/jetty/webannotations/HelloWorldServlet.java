package de.claudioaltamura.jetty.webannotations;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
@WebServlet(name = "HelloServlet", initParams = {@WebInitParam(name = "magicNumber", value = "42")}, urlPatterns = { "helloworld" }, loadOnStartup = 1)
public class HelloWorldServlet extends HttpServlet {

	private static final Logger LOG = LoggerFactory.getLogger(HelloWorldServlet.class);

	@PostConstruct
	public void postConstruct()
	{
		LOG.info("init through @PostConstruct");
	}

	@PreDestroy
	public void preDestroy()
	{
		LOG.info("bye bye!");
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		if(getInitParameter("magicNumber").equals(name))
		{
			throw new ServletException();
		}
		String result = name != null ? name : "World";
		response.getOutputStream().println("Hello " + result + "!");
	}

}

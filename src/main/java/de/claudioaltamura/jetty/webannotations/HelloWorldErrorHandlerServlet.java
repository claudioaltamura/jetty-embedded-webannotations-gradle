package de.claudioaltamura.jetty.webannotations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "errorHandlerServlet", urlPatterns = { "/errorHandler" }, loadOnStartup = 0)
public class HelloWorldErrorHandlerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getOutputStream().print("go away!");
	}

}

package de.claudioaltamura.jetty.webannotations;

public class HelloWorldApplication {

	public static void main(String[] args) throws Exception {
		int port = 8080;
		new JettyServer(port).start();
	}

}

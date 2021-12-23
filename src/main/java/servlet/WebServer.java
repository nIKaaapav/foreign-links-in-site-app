package servlet;

import db.DBConnection;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.sql.Connection;

public class WebServer {
    public void main() throws Exception {
        Connection connection = new DBConnection().getConnection();

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new LinksServlet(connection)), "/link");
        handler.addServlet(new ServletHolder(new HomeServlet(connection)), "/");

        Server server = new Server(8001);
        server.setHandler(handler);

        server.start();
        server.join();

    }
}

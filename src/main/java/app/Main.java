package app;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.*;

/**
 * Created by User on 13.03.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("C:\\Users\\User\\IdeaProjects\\simpleserver\\public_html");
        servletContextHandler.addServlet(new ServletHolder(new StatusServlet()), "/status");
        servletContextHandler.addServlet(new ServletHolder(new LogsServlet()), "/journals");
        servletContextHandler.addServlet(new ServletHolder(new LogServlet()), "/journal");
        servletContextHandler.addServlet(new ServletHolder(new GpsServlet()), "/gps");
        servletContextHandler.addServlet(new ServletHolder(new HelmServlet()), "/helm");
        servletContextHandler.addServlet(new ServletHolder(new DataBaseServlet()), "/database");
        servletContextHandler.addServlet(new ServletHolder(new DownloadDb()), "/download_database");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, servletContextHandler});
        server.setHandler(handlers);

        server.start();

        server.join();
    }
}

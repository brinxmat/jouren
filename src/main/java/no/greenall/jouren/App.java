package no.greenall.jouren;

import no.greenall.jouren.cors.CORSResponseFilter;
import no.greenall.jouren.entities.EntityResource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Arrays.asList;

/**
 * Responsibility: Start application in Jetty server.
 */
public final class App {
    private Server jettyServer;
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    private static final int JOUREN_PORT = 8005;
    private final int port;
    private String elasticSearchUrl = System.getProperty("ELASTICSEARCH_URL", "http://localhost:9200");

    public App(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        App app = new App(JOUREN_PORT);

    }


    private void startSync() throws Exception {
        try {
            startAsync();
            join();
        } finally {
            stop();
        }
    }

    public void startAsync() throws Exception {
        setUpMainWebApp();
    }

    private void setUpMainWebApp() throws Exception {

        jettyServer = new Server(port);


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter(ServerProperties.PROVIDER_CLASSNAMES,
                String.join(",", asList(
                        EntityResource.class.getCanonicalName(),
                        CORSResponseFilter.class.getCanonicalName()
                )));

        jettyServer.start();
        LOG.info("App started on port: " + port);
    }
    private void join() throws InterruptedException {
        jettyServer.join();
    }

    public void stop() throws Exception {
        LOG.info("Stopping App on port: " + port);
        try {
            jettyServer.stop();
        } finally {
            jettyServer.destroy();
        }
    }
}

package by.ralovets.epamcourse.server.main;

import by.ralovets.epamcourse.server.controller.ServerController;
import by.ralovets.epamcourse.server.controller.exception.ServerControllerException;
import org.apache.log4j.Logger;

public class Application {

    private final static Logger log = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        ServerController serverController = null;

        try {
            log.trace("Server: Trying to create ServerController");
            serverController = new ServerController(1234);
            log.trace("Server: ServerController was created");
            log.trace("Server: Trying to run listening socket");
            serverController.startListening();
        } catch (ServerControllerException e) {
            log.error("Server: Server work was stopped");
        } finally {
            if (serverController != null) {
                serverController.close();
            }
            log.trace("Server: Finalization of server controller is performed");
        }
    }
}

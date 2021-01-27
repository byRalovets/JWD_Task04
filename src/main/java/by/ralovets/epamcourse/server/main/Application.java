package by.ralovets.epamcourse.server.main;

import by.ralovets.epamcourse.server.controller.ServerController;
import by.ralovets.epamcourse.server.controller.exception.ServerControllerException;

public class Application {

    public static void main(String[] args) {
        ServerController serverController = null;

        try {
            serverController = new ServerController(1234);
            serverController.startListening();
        } catch (ServerControllerException e) {
            // ToDo: Logger
        } finally {
            if (serverController != null) {
                serverController.close();
            }
        }
    }
}

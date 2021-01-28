package by.ralovets.epamcourse.client.main;

import by.ralovets.epamcourse.client.controller.ClientController;
import by.ralovets.epamcourse.client.controller.exception.ControllerException;
import by.ralovets.epamcourse.common.CommandIdentifier;
import org.apache.log4j.Logger;

public class Application {

    private static final Logger log = Logger.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException {

        log.trace("Client: Main started");

        ClientController clientController;
        try {
            log.trace("Client: Trying to connect to server");
            clientController = new ClientController("127.0.0.1", 1234);
        } catch (ControllerException e) {
            log.error("Client: Connection to server was failed");
            System.out.println("Не удалось подключиться к серверу");
            return;
        }

        String response;
        try {
            response = clientController.doRequest(CommandIdentifier.TASK01, null);
            System.out.println(response);
        } catch (ControllerException e) {
            // ToDo: Logger
        } finally {
            // ToDo: Logger
            clientController.stop();
        }
    }
}

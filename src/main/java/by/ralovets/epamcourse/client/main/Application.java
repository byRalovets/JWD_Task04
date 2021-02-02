package by.ralovets.epamcourse.client.main;

import by.ralovets.epamcourse.client.controller.ClientController;
import by.ralovets.epamcourse.client.controller.exception.ControllerException;
import by.ralovets.epamcourse.common.CommandIdentifier;
import org.apache.log4j.Logger;

public class Application {

    private static final Logger log = Logger.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException {

        log.trace("Main method was started");

        ClientController clientController;
        try {
            log.trace("Trying to create ClientController");
            clientController = new ClientController("127.0.0.1", 1234);
        } catch (ControllerException e) {
            log.error("Creation ClientController was failed");
            System.out.println("Не удалось подключиться к серверу");
            return;
        }

        String response;
        try {
            log.trace("Trying to make request");
            response = clientController.doRequest(CommandIdentifier.TASK07, null);
            log.trace("Request was made successfully. Response was received");
            System.out.println(response);
        } catch (ControllerException e) {
            log.trace("Trying to make request");
        } finally {
            log.trace("Finalizing client controller");
            clientController.stop();
            log.trace("Client controller was finalized");
        }
    }
}
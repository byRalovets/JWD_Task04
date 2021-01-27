package by.ralovets.epamcourse.client.main;

import by.ralovets.epamcourse.client.controller.ClientController;
import by.ralovets.epamcourse.client.controller.exception.ControllerException;

public class Application {

    public static void main(String[] args) {

        ClientController clientController;
        try {
            clientController = new ClientController("127.0.0.1", 1234);
        } catch (ControllerException e) {
            // ToDo: Logger
            System.out.println("Не удалось подключиться к серверу");
            return;
        }

        String response;
        try {
            response = clientController.doRequest("Task01", null);
            System.out.println(response);

            response = clientController.doRequest("Task07", null);
            System.out.println(response);
        } catch (ControllerException e) {
            // ToDo: Logger
        } finally {
            // ToDo: Logger
            clientController.stop();
        }
    }
}

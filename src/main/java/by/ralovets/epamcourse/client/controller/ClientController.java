package by.ralovets.epamcourse.client.controller;

import by.ralovets.epamcourse.client.controller.exception.ControllerException;
import by.ralovets.epamcourse.client.service.ServiceFactory;
import by.ralovets.epamcourse.client.service.exception.ServiceException;
import by.ralovets.epamcourse.common.beans.request.Request;
import by.ralovets.epamcourse.common.beans.text.Text;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientController {

    private static final Logger log = Logger.getLogger(ClientController.class);

    private final Socket clientSocket;

    public ClientController(String host, int port) throws ControllerException {
        try {
            log.trace("Trying to create socket and connect to server");
            clientSocket = new Socket(host, port);
        } catch (IOException e) {
            log.error("Failed to connect to server");
            throw new ControllerException();
        }
        log.trace("ClientController was created. Connection to server was established");
    }

    public String doRequest(String commandId, List<String> params)
            throws ControllerException {
        log.trace("Method doRequest was called");

        Text text;

        try {
            log.trace("Trying to get text from service layer");
            text = ServiceFactory.getInstance().getTextService().parseText();
            log.trace("Text was received");
        } catch (ServiceException e) {
            log.error("Trying to get text from service layer");
            throw new ControllerException("Не удалось разобрать текст");
        }

        log.trace("Creating request object | commandId = " + commandId);
        Request request = new Request();
        request.setText(text);
        request.setCommandId(commandId);
        request.setParams(params == null ? new ArrayList<>() : params);

        try {
            log.trace("Trying to get OutputStream from connection");
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            log.trace("OutputStream was received");

            log.trace("Trying send request");
            out.writeObject(request);
            log.trace("Request was sent");
        } catch (IOException e) {
            log.error("An error occured while sending request");
            throw new ControllerException("Ошибка при отправке запроса");
        }

        String response;

        try {
            log.trace("Trying to get InputStream from connection");
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            log.trace("InputStream was received");

            log.trace("Trying to receive response");
            response = (String) in.readObject();
            log.trace("Response was received");

            log.trace("Trying to close InputStream");
            in.close();
            log.trace("InputStream was closed");
            return response;
        } catch (IOException | ClassNotFoundException e) {
            log.error("An error occured while receiving response");
            throw new ControllerException("Ошибка при плолучении ответа");
        }
    }

    public void stop() {
        try {
            log.trace("Trying to close connection");
            clientSocket.close();
            log.trace("Connection was closed");
        } catch (IOException e) {
            log.error("Connection already closed");
        }
    }
}

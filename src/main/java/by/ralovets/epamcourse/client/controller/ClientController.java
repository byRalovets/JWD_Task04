package by.ralovets.epamcourse.client.controller;

import by.ralovets.epamcourse.client.controller.exception.ControllerException;
import by.ralovets.epamcourse.client.service.ServiceFactory;
import by.ralovets.epamcourse.client.service.exception.ServiceException;
import by.ralovets.epamcourse.common.CommandIdentificator;
import by.ralovets.epamcourse.common.beans.request.Request;
import by.ralovets.epamcourse.common.beans.text.Text;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientController {

    private final ObjectInputStream in;
    private final ObjectOutputStream out;
    private Socket clientSocket;

    public ClientController(String host, int port) throws ControllerException {

        try {
            clientSocket = new Socket(host, port);
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            throw new ControllerException();
        }
    }

    public String doRequest(String commandId, List<String> params)
            throws ControllerException {

        Text text;

        try {
            text = ServiceFactory.getInstance().getTextService().parseText();
        } catch (ServiceException e) {
            throw new ControllerException("Не удалось разобрать текст");
        }

        Request request = new Request();
        request.setText(text);
        request.setCommandId(commandId);
        request.setParams(params == null ? new ArrayList<>() : params);

        try {
            out.writeObject(request);
        } catch (IOException e) {
            throw new ControllerException("Ошибка при отправке запроса");
        }

        String response;

        try {
            return (String) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new ControllerException("Ошибка при плолучении ответа");
        }
    }

    public void stop() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            // ToDo: Logger
        }
    }
}

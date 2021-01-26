package by.ralovets.epamcourse.client.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientController {

    private final ObjectInputStream in;
    private final ObjectOutputStream out;

    public ClientController(String host, int port) throws ControllerException {
        try {
            Socket clientSocket = new Socket(host, port);
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            throw new ControllerException();
        }
    }

    public String sendRequest(String text, int command) throws ControllerException {
        String result;

        try {
            out.writeObject(text);
            out.writeInt(command);
            result = (String) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new ControllerException();
        }

        return result;
    }

}

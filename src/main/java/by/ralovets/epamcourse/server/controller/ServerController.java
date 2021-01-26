package by.ralovets.epamcourse.server.controller;

import by.ralovets.epamcourse.request.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {

    private final ServerController instance = new ServerController();

    private final ServerSocket serverSocket;
    public int port = 1234;

    public ServerController getInstance() {
        return instance;
    }

    private ServerController() throws ServerControllerException {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new ServerControllerException();
        }
    }

    public void startListening() {
        try {
            while (true) {
                Socket connection = serverSocket.accept();
                ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());

                try {
                    Request requet = (Request) in.readObject();

                } catch (Exception e) {
                    out.writeObject(null);
                }
            }
        } catch (Exception e) {

        }
    }
}

package by.ralovets.epamcourse.server.controller;

import by.ralovets.epamcourse.server.controller.exception.ServerControllerException;
import by.ralovets.epamcourse.server.service.command.CommandProvider;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {

    Logger log = Logger.getLogger(ServerController.class);

    private final CommandProvider commandProvider = new CommandProvider();
    private final ServerSocket serverSocket;

    public ServerController(int port) throws ServerControllerException {
        try {
            serverSocket = new ServerSocket(port);
            log.trace("Server: Listening socket was opened");
        } catch (IOException e) {
            log.error("Server: Не удалось создать ServerSocket");
            throw new ServerControllerException();
        }
    }

    public void startListening() {
        try {
            while (true) {
                Socket connection = serverSocket.accept();
                log.trace("Server: New request for connection");
                try {
                    log.trace("Server: Trying to process connection in separate thread");
                    Thread thread = new ProcessingThread(connection);
                    thread.start();
//                    new ObjectInputStream(connection.getInputStream()).readObject();
//                    new ObjectOutputStream(connection.getOutputStream()).writeObject("Hahhaha");
                } catch (Exception e) {
                    log.error("Server: Exception was thrown when server proceed connection");
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            log.error("Server: Exception was thrown when server listened connections");
        }
    }

    public void close() {
        try {
            serverSocket.close();
        } catch (IOException ignored) {
            log.error("Server: Error while closing server socket");
        }
    }
}

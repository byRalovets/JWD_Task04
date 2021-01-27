package by.ralovets.epamcourse.server.controller;

import by.ralovets.epamcourse.common.beans.request.Request;
import by.ralovets.epamcourse.server.ProcessingThread;
import by.ralovets.epamcourse.server.controller.exception.ServerControllerException;
import by.ralovets.epamcourse.server.service.command.CommandProvider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerController {

    private final CommandProvider commandProvider = new CommandProvider();
    private final List<Thread> processingThreads = new ArrayList<>();
    private final ServerSocket serverSocket;

    public ServerController(int port) throws ServerControllerException {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            // ToDo: Logger
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
                    Request request = (Request) in.readObject();
                    Thread thread = new ProcessingThread(request, out);
                    processingThreads.add(thread);
                    thread.start();
                } catch (Exception e) {
                    // ToDo: Logger
                }
            }
        } catch (Exception ignored) {
            // ToDo: Logger
        }
    }

    public void close() {
        try {
            serverSocket.close();
        } catch (IOException ignored) {
        }
    }
}

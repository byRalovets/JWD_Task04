package by.ralovets.epamcourse.server.controller;

import by.ralovets.epamcourse.common.beans.request.Request;
import by.ralovets.epamcourse.server.service.command.CommandProvider;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ProcessingThread extends Thread {

    private static final Logger log = Logger.getLogger(ProcessingThread.class);
    private final Socket connection;

    public ProcessingThread(Socket connection) {
        this.connection = connection;
        log.trace("Server: Processing thread was created");
    }

    @Override
    public void run() {
        log.trace("Server: New processing thread was started");
        ObjectInputStream in;
        ObjectOutputStream out;

        try {
            log.trace("Server: Trying to get output stream");
            out = new ObjectOutputStream(connection.getOutputStream());
        } catch (IOException e) {
            log.trace("Server: I/O error was occured while trying to open output stream");
            return;
        }

        Request request;
        try {
            log.trace("Server: Trying to get input stream");
            in = new ObjectInputStream(connection.getInputStream());
            log.trace("Server: Trying to read Request object from input stream");
            request = (Request) in.readObject();
            log.trace("Server: Trying to generate response");
            String response = CommandProvider.getInstance()
                    .getCommand(request.getCommandId())
                    .execute(request.getText(), request.getParams());
            log.trace("Server: Trying to send response");
            out.writeObject(response);
        } catch (IOException | ClassNotFoundException e) {
            log.error("Server: An error was occured! pzdc");
        }
    }
}

package by.ralovets.epamcourse.server;

import by.ralovets.epamcourse.common.beans.request.Request;

import java.io.ObjectOutputStream;

public class ProcessingThread extends Thread {

    public ProcessingThread(Request request,
                            ObjectOutputStream responseOutputStream) {
//        CommandProvider commandProvider = new CommandProvider();
//
//        String response = commandProvider
//                .getCommand(request.getCommandId())
//                .execute(request.getText(), request.getParams());
//
//        try {
//            responseOutputStream.writeObject(response);
//        } catch (IOException e) {
//            // ToDo: Logger
//        }

    }
}

package by.ralovets.epamcourse.client.main;

import by.ralovets.epamcourse.client.controller.ClientController;
import by.ralovets.epamcourse.client.controller.ControllerException;
import by.ralovets.epamcourse.client.dao.DAOException;
import by.ralovets.epamcourse.client.dao.DAOProvider;
import by.ralovets.epamcourse.client.dao.TextDAO;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        TextDAO textDAO = DAOProvider.getInstance().getTextDAO();
        String text;

        try {
            text = textDAO.getText();
        } catch (DAOException e) {
            e.printStackTrace();
        }

        try {
            ClientController controller = new ClientController("0.0.0.0", 1234);

            controller.sendRequest("Once upon a time...", 0);
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }
}

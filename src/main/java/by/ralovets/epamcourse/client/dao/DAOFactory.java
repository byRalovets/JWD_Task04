package by.ralovets.epamcourse.client.dao;

import by.ralovets.epamcourse.client.dao.impl.FileTextDAO;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final TextDAO textDAO = new FileTextDAO();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public TextDAO getTextDAO() {
        return textDAO;
    }
}

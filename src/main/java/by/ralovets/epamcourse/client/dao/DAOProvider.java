package by.ralovets.epamcourse.client.dao;

import by.ralovets.epamcourse.client.dao.impl.FileTextDAO;

public class DAOProvider {

    private static final DAOProvider instance = new DAOProvider();

    private final TextDAO textDAO = new FileTextDAO();

    private DAOProvider () {}

    public TextDAO getTextDAO() {
        return textDAO;
    }

    public static DAOProvider getInstance() {
        return instance;
    }
}

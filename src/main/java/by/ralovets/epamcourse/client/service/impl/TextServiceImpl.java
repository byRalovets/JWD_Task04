package by.ralovets.epamcourse.client.service.impl;

import by.ralovets.epamcourse.client.dao.DAOFactory;
import by.ralovets.epamcourse.client.dao.exception.DAOException;
import by.ralovets.epamcourse.client.service.TextService;
import by.ralovets.epamcourse.client.service.exception.ServiceException;
import by.ralovets.epamcourse.client.service.parser.TextParser;
import by.ralovets.epamcourse.common.beans.text.Text;

public class TextServiceImpl implements TextService {

    @Override
    public Text parseText() throws ServiceException {

        String sourceString;

        try {
            sourceString = DAOFactory.getInstance().getTextDAO().getText();
        } catch (DAOException e) {
            throw new ServiceException("Не удалось прочесть строку из файла");
        }

        return TextParser.parseText(sourceString);
    }
}

package by.ralovets.epamcourse.client.service;

import by.ralovets.epamcourse.client.service.exception.ServiceException;
import by.ralovets.epamcourse.common.beans.text.Text;

public interface TextService {

    Text parseText() throws ServiceException;
}

package by.ralovets.epamcourse.client.dao.impl.file;

import by.ralovets.epamcourse.client.dao.TextDAO;
import by.ralovets.epamcourse.client.dao.exception.DAOException;

import java.io.*;
import java.util.Properties;

public class FileTextDAO implements TextDAO {

    private final static String PROPERTIES_FILE_PATH = "client.properties";
    private final static String PATH_TO_FILE_PROPERTY_NAME = "pathToFile";

    public FileTextDAO() {
    }

    @Override
    public String getText() throws DAOException {
         File file = new File(getPathToFileFromProperties());
         FileContentProvider fileContentProvider = new FileContentProvider(file);
         return fileContentProvider.getContent();
    }

    private String getPathToFileFromProperties() throws DAOException {
        Properties props;

        try {
            InputStream in = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_PATH);
            props = new Properties();
            props.load(in);
            if (in != null) in.close();
        } catch (IOException e) {
            // ToDo: Logger
            throw new DAOException("Cannot find client configuration file");
        }

        String filePath = props.getProperty(PATH_TO_FILE_PROPERTY_NAME);

        return (filePath == null) ? "" : filePath;
    }
}


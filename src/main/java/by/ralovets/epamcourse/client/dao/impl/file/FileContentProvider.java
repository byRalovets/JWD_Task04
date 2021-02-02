package by.ralovets.epamcourse.client.dao.impl.file;

import by.ralovets.epamcourse.client.dao.exception.DAOException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class FileContentProvider {

    private final File file;

    public FileContentProvider(File file) {
        this.file = file;
    }

    public String getContent() throws DAOException {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            return br.lines().collect(Collectors.joining());
        } catch (FileNotFoundException e) {
            // ToDo: Logger
            throw new DAOException("Failed to open file from resources");
        }
    }
}
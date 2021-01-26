package by.ralovets.epamcourse.client.dao.impl;

import by.ralovets.epamcourse.client.dao.DAOException;
import by.ralovets.epamcourse.client.dao.TextDAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class FileTextDAO implements TextDAO {

    private String text;

    public FileTextDAO() {
    }

    @Override
    public String getText() throws DAOException {
        if (text != null) return text;

        try {
            File f = new File("text");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            text = br.lines().collect(Collectors.joining());
        } catch (FileNotFoundException e) {
            throw new DAOException();
        }
        return text;
    }
}

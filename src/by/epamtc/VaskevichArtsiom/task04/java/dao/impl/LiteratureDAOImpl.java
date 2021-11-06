package by.epamtc.VaskevichArtsiom.task04.java.dao.impl;

import by.epamtc.VaskevichArtsiom.task04.java.dao.DAOException;
import by.epamtc.VaskevichArtsiom.task04.java.dao.LiteratureDAO;
import by.epamtc.VaskevichArtsiom.task04.java.entity.Literature;
import by.epamtc.VaskevichArtsiom.task04.java.entity.User;
import by.epamtc.VaskevichArtsiom.task04.java.entity.UserRole;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class LiteratureDAOImpl implements LiteratureDAO {
    private final static String PATH = "./resources/library.txt";
    private final static String DIVIDER = "|";

    @Override
    public void addLiterature(Literature newLiterature) throws DAOException {
        try (FileWriter writer = new FileWriter(PATH, true)) {
            String result = String.join(DIVIDER,
                    newLiterature.getLiteratureId().toString(),
                    newLiterature.getName(),
                    newLiterature.getAuthor(),
                    newLiterature.getType(),
                    "\n");
            writer.append(result);
        } catch (Exception e) {
            throw new DAOException("file read error");
        }
    }

    @Override
    public void removeLiterature(Literature literature) throws DAOException {
        List<Literature> newLiterature = readLiterature();

        newLiterature.remove(literature);
        try (FileWriter writer = new FileWriter(PATH)) {
            writer.write("");
        } catch (Exception e) {
            throw new DAOException("file read error");
        }

        for (Literature currentLiterature : newLiterature) {
            addLiterature(currentLiterature);
        }
    }

    @Override
    public List<Literature> readLiterature() throws DAOException {
        List<Literature> result = new ArrayList<>();
        String literature;

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))){
            while ((literature = reader.readLine()) != null){
                result.add(parse(literature));
            }
        } catch (Exception e){
            throw new DAOException("file read error");
        }
        return result;
    }

    public Literature parse(String line){
        Literature literature = null;
        if (line != null || !line.equals("")) {
            String[] array = line.split(DIVIDER);
            if (array.length > 2){
                literature = new Literature(array[0], array[1], array[2]);}
        }
        return literature;
    }
}

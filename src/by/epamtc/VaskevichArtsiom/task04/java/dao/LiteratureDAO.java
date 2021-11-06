package by.epamtc.VaskevichArtsiom.task04.java.dao;

import by.epamtc.VaskevichArtsiom.task04.java.entity.Literature;

import java.util.List;

public interface LiteratureDAO {
    void addLiterature(Literature newLiterature) throws DAOException;
    void removeLiterature(Literature literature) throws DAOException;
    List<Literature> readLiterature() throws DAOException;
}

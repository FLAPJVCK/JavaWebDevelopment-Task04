package by.epamtc.VaskevichArtsiom.task04.java.service;

import by.epamtc.VaskevichArtsiom.task04.java.entity.Literature;

import java.util.List;

public interface LiteratureService {
    void addLiterature(String name, String author, String type) throws ServiceException;
    void removeLiterature(String name, String author, String type) throws ServiceException;
    List<Literature> viewLiterature() throws ServiceException;
    List<Literature> findLiterature(String name, String author, String type) throws ServiceException;
    List<Literature> findByName (String name) throws ServiceException;
    List<Literature> findByAuthor (String author) throws ServiceException;
    List<Literature> findByType (String type) throws ServiceException;
}

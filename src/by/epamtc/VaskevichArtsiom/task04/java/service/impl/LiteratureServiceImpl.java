package by.epamtc.VaskevichArtsiom.task04.java.service.impl;

import by.epamtc.VaskevichArtsiom.task04.java.dao.DAOException;
import by.epamtc.VaskevichArtsiom.task04.java.dao.FactoryDAO;
import by.epamtc.VaskevichArtsiom.task04.java.entity.Literature;
import by.epamtc.VaskevichArtsiom.task04.java.service.LiteratureService;
import by.epamtc.VaskevichArtsiom.task04.java.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

import static by.epamtc.VaskevichArtsiom.task04.java.service.validation.Validator.*;

public class LiteratureServiceImpl implements LiteratureService {
    @Override
    public void addLiterature(String name, String author, String type) throws ServiceException {
        if (!isValidLiteratureName(name)){
            throw new ServiceException("Invalid literature name");
        }

        if (!isValidLiteratureAuthor(author)){
            throw new ServiceException("Invalid literature author");
        }

        if (!isValidLiteratureType(type)){
            throw new ServiceException("Invalid literature type");
        }

        Literature newLiterature = new Literature(name, author, type);

        try {
            FactoryDAO.getInstance().getLiteratureDAOImpl().addLiterature(newLiterature);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void removeLiterature(String name, String author, String type) throws ServiceException {
        if (!isValidLiteratureName(name)){
            throw new ServiceException("Invalid literature name");
        }

        if (!isValidLiteratureAuthor(author)){
            throw new ServiceException("Invalid literature author");
        }

        if (!isValidLiteratureType(type)){
            throw new ServiceException("Invalid literature type");
        }

        Literature oldLiterature = new Literature(name, author, type);

        try {
            FactoryDAO.getInstance().getLiteratureDAOImpl().addLiterature(oldLiterature);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Literature> viewAllLiterature() throws ServiceException {
        List<Literature> allLiterature;

        try {
            allLiterature = FactoryDAO.getInstance().getLiteratureDAOImpl().readLiterature();
        } catch (DAOException e){
            throw new ServiceException(e.getMessage(), e);
        }
        return allLiterature;
    }

    @Override
    public List<Literature> findLiterature(String name, String author, String type) throws ServiceException {
        if (name != null) {
            if (!isValidLiteratureName(name)){
                throw new ServiceException("Invalid literature name");
            }
            return findByName(name);
        }
        if (author != null) {
            if (!isValidLiteratureAuthor(author)){
                throw new ServiceException("Invalid literature author");
            }
            return findByAuthor(author);
        }
        if (type != null){
            if (!isValidLiteratureType(type)){
                throw new ServiceException("Invalid literature type");
            }
            return findByType(type);
        }
        return null;
    }

    @Override
    public List<Literature> findByName(String name) throws ServiceException {
        List<Literature> foundLiterature = new ArrayList<>();

        try {
            List<Literature> allLiterature = FactoryDAO.getInstance().getLiteratureDAOImpl().readLiterature();
            for (Literature literature : allLiterature) {
                if (literature.getName().equals(name)) {
                    foundLiterature.add(literature);
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return foundLiterature;
    }

    @Override
    public List<Literature> findByAuthor(String author) throws ServiceException {
        List<Literature> foundLiterature = new ArrayList<>();

        try {
            List<Literature> allLiterature = FactoryDAO.getInstance().getLiteratureDAOImpl().readLiterature();
            for (Literature literature : allLiterature) {
                if (literature.getAuthor().equals(author)) {
                    foundLiterature.add(literature);
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return foundLiterature;
    }

    @Override
    public List<Literature> findByType(String type) throws ServiceException {
        List<Literature> foundLiterature = new ArrayList<>();

        try {
            List<Literature> allLiterature = FactoryDAO.getInstance().getLiteratureDAOImpl().readLiterature();
            for (Literature literature : allLiterature) {
                if (literature.getType().equals(type)) {
                    foundLiterature.add(literature);
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return foundLiterature;
    }
}

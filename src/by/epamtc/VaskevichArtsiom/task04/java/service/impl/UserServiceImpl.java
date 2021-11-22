package by.epamtc.VaskevichArtsiom.task04.java.service.impl;

import by.epamtc.VaskevichArtsiom.task04.java.dao.DAOException;
import by.epamtc.VaskevichArtsiom.task04.java.dao.FactoryDAO;
import by.epamtc.VaskevichArtsiom.task04.java.entity.User;
import by.epamtc.VaskevichArtsiom.task04.java.service.ServiceException;
import by.epamtc.VaskevichArtsiom.task04.java.service.UserService;

import java.util.List;

import static by.epamtc.VaskevichArtsiom.task04.java.service.validation.Validator.*;

public class UserServiceImpl implements UserService {
    @Override
    public void register(String username, String password) throws ServiceException {
        if (!isValidUsername(username)){
            throw new ServiceException("Invalid username");
        }

        if (!isValidUsername(username)){
            throw new ServiceException("Incorrect password");
        }

        User newUser = new User(username, password);

        try {
            List<User> allUsers = FactoryDAO.getInstance().getUserDAOImpl().readUsers();
            if (allUsers.contains(newUser)) {
                FactoryDAO.getInstance().getUserDAOImpl().addUser(newUser);
            } else {
                throw new ServiceException("user already exists");
            }
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public User logIn(String username, String password) throws ServiceException {
        if (!isValidUsername(username)){
            throw new ServiceException("Invalid username");
        }

        if (!isValidUsername(username)){
            throw new ServiceException("Incorrect password");
        }

        User verifyUser = new User(username, password);
        try {
            List<User> allUsers = FactoryDAO.getInstance().getUserDAOImpl().readUsers();
            for (User currentUser : allUsers) {
                if (verifyUser.isUserExists(verifyUser)) {
                    return currentUser;
                } else {
                    throw new ServiceException("user does not exist");
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return null;
    }
}

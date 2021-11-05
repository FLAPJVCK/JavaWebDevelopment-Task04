package by.epamtc.VaskevichArtsiom.task04.java.dao;

import by.epamtc.VaskevichArtsiom.task04.java.entity.User;

public interface UserDAO {
    void registration(User newUser) throws DAOException;
    User authorisation(String login, String password) throws DAOException;
}

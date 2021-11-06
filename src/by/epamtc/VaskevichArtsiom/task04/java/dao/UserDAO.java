package by.epamtc.VaskevichArtsiom.task04.java.dao;

import by.epamtc.VaskevichArtsiom.task04.java.entity.User;

import java.util.List;

public interface UserDAO {
    void addUser(User newUser) throws DAOException;
    List<User> readUsers() throws DAOException;
}

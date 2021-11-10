package by.epamtc.VaskevichArtsiom.task04.java.service;

import by.epamtc.VaskevichArtsiom.task04.java.entity.User;

public interface UserService {
    void register(String username, String password) throws ServiceException;
    User logIn (String username, String password) throws ServiceException;
}

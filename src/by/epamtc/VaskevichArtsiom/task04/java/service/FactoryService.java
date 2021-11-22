package by.epamtc.VaskevichArtsiom.task04.java.service;

import by.epamtc.VaskevichArtsiom.task04.java.service.impl.LiteratureServiceImpl;
import by.epamtc.VaskevichArtsiom.task04.java.service.impl.UserServiceImpl;

public class FactoryService {
    private static final FactoryService instance = new FactoryService();

    private UserService UserServiceImpl = new UserServiceImpl();
    private LiteratureService LiteratureServiceImpl = new LiteratureServiceImpl();

    private FactoryService() {
    }

    public static FactoryService getInstance() {
        return instance;
    }


    public UserService getUserServiceImpl() {
        return UserServiceImpl;
    }

    public LiteratureService getLiteratureServiceImpl() {
        return LiteratureServiceImpl;
    }

    public void setUserServiceImpl(UserService userServiceImpl) {
        UserServiceImpl = userServiceImpl;
    }

    public void setLiteratureServiceImpl(LiteratureService literatureServiceImpl) {
        LiteratureServiceImpl = literatureServiceImpl;
    }
}

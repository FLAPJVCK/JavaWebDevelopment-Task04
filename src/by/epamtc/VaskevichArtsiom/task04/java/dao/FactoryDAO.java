package by.epamtc.VaskevichArtsiom.task04.java.dao;

import by.epamtc.VaskevichArtsiom.task04.java.dao.impl.LiteratureDAOImpl;
import by.epamtc.VaskevichArtsiom.task04.java.dao.impl.UserDAOImpl;

public class FactoryDAO {
    private static final FactoryDAO instance = new FactoryDAO();

    private final UserDAO userDAOImpl = new UserDAOImpl();
    private final LiteratureDAO literatureDAOImpl = new LiteratureDAOImpl();

    private FactoryDAO(){
    }

    public static FactoryDAO getInstance() {
        return instance;
    }

    public UserDAO getUserDAOImpl() {
        return userDAOImpl;
    }

    public LiteratureDAO getLiteratureDAOImpl() {
        return literatureDAOImpl;
    }
}

package by.epamtc.VaskevichArtsiom.task04.java.dao;

import by.epamtc.VaskevichArtsiom.task04.java.dao.impl.LiteratureDAOImpl;
import by.epamtc.VaskevichArtsiom.task04.java.dao.impl.UserDAOImpl;

public class FactoryDAO {
    private static final FactoryDAO instance = new FactoryDAO();

    private UserDAO userDAOImpl = new UserDAOImpl();
    private LiteratureDAO literatureDAOImpl = new LiteratureDAOImpl();

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

    public void setUserDAOImpl(UserDAO userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }

    public void setLiteratureDAOImpl(LiteratureDAO literatureDAOImpl) {
        this.literatureDAOImpl = literatureDAOImpl;
    }
}

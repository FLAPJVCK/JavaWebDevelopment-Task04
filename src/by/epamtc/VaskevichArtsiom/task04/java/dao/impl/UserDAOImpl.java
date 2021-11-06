package by.epamtc.VaskevichArtsiom.task04.java.dao.impl;

import by.epamtc.VaskevichArtsiom.task04.java.dao.DAOException;
import by.epamtc.VaskevichArtsiom.task04.java.dao.UserDAO;
import by.epamtc.VaskevichArtsiom.task04.java.entity.User;
import by.epamtc.VaskevichArtsiom.task04.java.entity.UserRole;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final static String PATH = "./resources/users.txt";
    private final static String DIVIDER = "|";

    @Override
    public void addUser(User newUser) throws DAOException {
        try (FileWriter writer = new FileWriter(PATH, true)) {
            String result = String.join(DIVIDER,
                    newUser.getUserId().toString(),
                    newUser.getUserRole().toString(),
                    newUser.getUsername(),
                    newUser.getPassword(),
                    "\n");
            writer.append(result);
        } catch (Exception e) {
            throw new DAOException("file read error");
        }
    }

    @Override
    public List<User> readUsers() throws DAOException {
        List<User> result = new ArrayList<>();
        String user;

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))){
            while ((user = reader.readLine()) != null){
                result.add(parse(user));
            }
        } catch (Exception e){
            throw new DAOException("file read error");
        }
        return result;
    }

    public User parse(String line){
        User user = null;
        if (line != null || !line.equals("")) {
            String[] array = line.split(DIVIDER);
            if (array.length > 2){
                user = new User(array[0], array[1], UserRole.valueOf(array[2].trim().toUpperCase()));}
        }
        return user;
    }
}

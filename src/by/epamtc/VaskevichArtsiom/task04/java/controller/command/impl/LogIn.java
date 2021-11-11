package by.epamtc.VaskevichArtsiom.task04.java.controller.command.impl;

import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Command;
import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Container;
import by.epamtc.VaskevichArtsiom.task04.java.entity.User;
import by.epamtc.VaskevichArtsiom.task04.java.service.FactoryService;
import by.epamtc.VaskevichArtsiom.task04.java.service.ServiceException;

import java.util.HashMap;
import java.util.Map;

public class LogIn implements Command {
    @Override
    public Container execute(Container request) {
        String username = (String) request.model.get("username");
        String password = (String) request.model.get("password");

        Map<String,Object> model = new HashMap<>();
        User currentUser;

        try {
            currentUser = FactoryService.getInstance().getUserServiceImpl().logIn(username,password);
        } catch (ServiceException e){
            model.put("message", e.getMessage());
            return new Container("Error", model);
        }
        model.put("user", currentUser);
        return new Container("Success",model);
    }
}

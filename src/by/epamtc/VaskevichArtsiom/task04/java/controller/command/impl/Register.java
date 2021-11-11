package by.epamtc.VaskevichArtsiom.task04.java.controller.command.impl;

import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Command;
import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Container;
import by.epamtc.VaskevichArtsiom.task04.java.service.FactoryService;
import by.epamtc.VaskevichArtsiom.task04.java.service.ServiceException;

import java.util.HashMap;
import java.util.Map;

public class Register implements Command {
    @Override
    public Container execute(Container request) {
        String username = (String) request.model.get("username");
        String password = (String) request.model.get("password");

        try {
            FactoryService.getInstance().getUserServiceImpl().register(username,password);
        } catch (ServiceException e){
            Map<String,Object> model = new HashMap<>();
            model.put("message", e.getMessage());
            return new Container("Error", model);
        }
        return new Container("Success", new HashMap<>());
    }
}

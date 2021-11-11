package by.epamtc.VaskevichArtsiom.task04.java.controller.command.impl;

import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Command;
import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Container;
import by.epamtc.VaskevichArtsiom.task04.java.service.FactoryService;
import by.epamtc.VaskevichArtsiom.task04.java.service.ServiceException;

import java.util.HashMap;
import java.util.Map;

public class AddLiterature implements Command {
    @Override
    public Container execute(Container request) {
        String name = (String) request.model.get("name");
        String author = (String) request.model.get("author");
        String type = (String) request.model.get("type");

        try {
            FactoryService.getInstance().getLiteratureServiceImpl().addLiterature(name,author,type);
        } catch (ServiceException e){
            Map<String, Object> model = new HashMap<>();
            model.put("message", e.getMessage());
            return new Container("Error", model);
        }
        return new Container("Success", new HashMap<>());
    }
}

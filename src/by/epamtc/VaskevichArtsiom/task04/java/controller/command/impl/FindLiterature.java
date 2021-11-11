package by.epamtc.VaskevichArtsiom.task04.java.controller.command.impl;

import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Command;
import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Container;
import by.epamtc.VaskevichArtsiom.task04.java.entity.Literature;
import by.epamtc.VaskevichArtsiom.task04.java.service.FactoryService;
import by.epamtc.VaskevichArtsiom.task04.java.service.ServiceException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLiterature implements Command {
    @Override
    public Container execute(Container request) {
        String name = (String) request.model.get("name");
        String author = (String) request.model.get("author");
        String type = (String) request.model.get("type");

        List<Literature> foundLiterature;
        Map<String,Object> model = new HashMap<>();
        try {
            foundLiterature = FactoryService.getInstance().getLiteratureServiceImpl().findLiterature(name,author,type);
        } catch (ServiceException e){
            model.put("message", e.getMessage());
            return new Container("Error", model);
        }
        model.put("Literature", foundLiterature);
        return new Container("Success", model);
    }
}

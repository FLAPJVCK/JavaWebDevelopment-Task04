package by.epamtc.VaskevichArtsiom.task04.java.controller.command.impl;

import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Command;
import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Container;
import by.epamtc.VaskevichArtsiom.task04.java.entity.Literature;
import by.epamtc.VaskevichArtsiom.task04.java.service.FactoryService;
import by.epamtc.VaskevichArtsiom.task04.java.service.ServiceException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewLiterature implements Command {
    @Override
    public Container execute(Container request) {
        List<Literature> allLiterature;
        Map<String, Object> model = new HashMap<>();

        try {
            allLiterature = FactoryService.getInstance().getLiteratureServiceImpl().viewAllLiterature();
        } catch (ServiceException e) {
            model.put("message", e.getMessage());
            return new Container("Error", model);
        }
        model.put("Literature", allLiterature);
        return new Container("Success", new HashMap<>());
    }
}

package by.epamtc.VaskevichArtsiom.task04.java.controller.command.impl;

import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Command;
import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Container;

import java.util.HashMap;
import java.util.Map;

public class WrongRequest implements Command {
    @Override
    public Container execute(Container request) {
        Map<String,Object> model = new HashMap<>();
        model.put("message", "Invalid request");
        return new Container("Error", model);
    }
}

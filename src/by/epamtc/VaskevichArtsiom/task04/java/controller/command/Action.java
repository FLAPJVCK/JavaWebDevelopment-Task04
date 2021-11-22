package by.epamtc.VaskevichArtsiom.task04.java.controller.command;

import by.epamtc.VaskevichArtsiom.task04.java.controller.command.impl.*;

import java.util.HashMap;

public class Action {
    private static Action instance;
    private final HashMap<String, Command> commands;

    private Action(){
        commands = new HashMap<>();
        commands.put("REGISTER", new Register());
        commands.put("LOG_IN", new LogIn());
        commands.put("ADD_LITERATURE", new AddLiterature());
        commands.put("REMOVE_LITERATURE", new RemoveLiterature());
        commands.put("FIND_LITERATURE", new FindLiterature());
        commands.put("VIEW_LITERATURE", new ViewLiterature());
        commands.put("WRONG_REQUEST", new WrongRequest());
    }

    public Command createAction(Container request){
        String action = request.header.toUpperCase();
        Command result = commands.get(action);
        return result == null ? new WrongRequest() : result;
    }

    public static Action getInstance() {
        if (instance == null){
            instance = new Action();
        }
        return instance;
    }
}

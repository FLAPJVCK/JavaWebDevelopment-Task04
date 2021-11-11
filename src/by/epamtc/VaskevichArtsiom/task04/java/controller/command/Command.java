package by.epamtc.VaskevichArtsiom.task04.java.controller.command;

import by.epamtc.VaskevichArtsiom.task04.java.service.ServiceException;

public interface Command {
    Container execute(Container request);
}

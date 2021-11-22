package by.epamtc.VaskevichArtsiom.task04.java.controller.command;

import java.util.Map;

@SuppressWarnings("ClassCanBeRecord")
public class Container {
    public final String header;
    public final Map<String, Object> model;

    public Container(String header,Map<String,Object> model){
        this.header = header;
        this.model = model;
    }
}

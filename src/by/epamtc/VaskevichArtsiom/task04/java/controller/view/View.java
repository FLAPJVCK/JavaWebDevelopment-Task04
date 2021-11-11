package by.epamtc.VaskevichArtsiom.task04.java.controller.view;

import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Action;
import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Command;
import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Container;
import by.epamtc.VaskevichArtsiom.task04.java.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final static String ERROR_INPUT = "Your input is incorrect";
    private final static String WELCOME = """
            Welcome to the library!
            1. Sign in
            2. Sign up
            3. Exit the application""";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = true;
        String input;

        while (loggedIn) {
            System.out.println(WELCOME);
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    signIn();
                    break;
                case "2":
                    signUp();
                    break;
                case "3":
                    loggedIn = false;
                    break;
                default:
                    System.out.println(ERROR_INPUT);
                    break;
            }
        }
    }

    private static User signIn() {
        Container request;
        Container response;

        Map<String, Object> model = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        model.put("username", scanner.nextLine());
        System.out.println("Enter password:");
        model.put("password", scanner.nextLine());

        request = new Container("SIGN_IN", model);
        response = Action.getInstance().createAction(request).execute(request);

        if ("Error".equals(response.header)){
            System.out.println(response.model.get("message"));
        }

        return (User) response.model.get("user");
    }

    private static void signUp() {
        Container request;
        Container response;

        Map<String, Object> model = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        model.put("username", scanner.nextLine());
        System.out.println("Enter password:");
        model.put("password", scanner.nextLine());

        request = new Container("REGISTER", model);
        response = Action.getInstance().createAction(request).execute(request);

        if ("Error".equals(response.header)){
            System.out.println(response.model.get("message"));
        }
    }
}

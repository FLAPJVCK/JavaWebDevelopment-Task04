package by.epamtc.VaskevichArtsiom.task04.java.controller.view;

import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Action;
import by.epamtc.VaskevichArtsiom.task04.java.controller.command.Container;
import by.epamtc.VaskevichArtsiom.task04.java.entity.Literature;
import by.epamtc.VaskevichArtsiom.task04.java.entity.User;
import by.epamtc.VaskevichArtsiom.task04.java.entity.UserRole;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final static String ERROR_INPUT = "Your input is incorrect";
    private final static String USER_NOT_FOUND = "User is not found";
    private final static String ENTER_USERNAME = "Enter username:";
    private final static String ENTER_PASSWORD = "Enter password:";
    private final static String WELCOME = """
            Welcome to the library!
            1. Sign in
            2. Sign up
            3. Exit the application""";
    private final static String ADMIN_MENU = """
            1. View all literature in the library
            2. Add literature
            3. Remove literature
            4. Find literature
            5. Add account
            6. Log out of your account
            7. Exit to the main menu""";
    private final static String USER_MENU = """
            1. View all literature in the library
            2. Add literature
            3. Remove literature
            4. Find literature
            5. Log out of your account
            6. Exit to the main menu""";
    private final static String LITERATURE_SEARCH_MENU = """
            1. Search by name
            2. Search by author
            3. Search by type""";

    public static void main(String[] args) {
        welcomePage();
    }

    private static void welcomePage() {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = true;
        String input;

        while (loggedIn) {
            System.out.println(WELCOME);
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    selection();
                    break;
                case "2":
                    signUp();
                    welcomePage();
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

        System.out.println(ENTER_USERNAME);
        model.put("username", scanner.nextLine());
        System.out.println(ENTER_PASSWORD);
        model.put("password", scanner.nextLine());

        request = new Container("SIGN_IN", model);
        response = Action.getInstance().createAction(request).execute(request);

        if ("Error".equals(response.header)) {
            System.out.println(response.model.get("message"));
        }

        return (User) response.model.get("user");
    }

    private static void signUp() {
        Container request;
        Container response;

        Map<String, Object> model = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println(ENTER_USERNAME);
        model.put("username", scanner.nextLine());
        System.out.println(ENTER_PASSWORD);
        model.put("password", scanner.nextLine());

        request = new Container("REGISTER", model);
        response = Action.getInstance().createAction(request).execute(request);

        if ("Error".equals(response.header)) {
            System.out.println(response.model.get("message"));
        }
    }

    private static void selection() {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean toStay = true;
        User currentUser = null;

        while (toStay) {
            if (currentUser != null) {
                if (currentUser.getUserRole() == UserRole.ADMIN) {
                    System.out.println(ADMIN_MENU);
                    input = scanner.nextLine();
                    if (input.matches("^[1-7]$")) {
                        switch (input) {
                            case "1":
                                viewAllLiterature();
                                break;
                            case "2":
                                addLiterature();
                                break;
                            case "3":
                                removeLiterature();
                                break;
                            case "4":
                                findLiterature();
                                break;
                            case "5":
                                signUp();
                                break;
                            case "6":
                                currentUser = null;
                                break;
                            case "7":
                                toStay = false;
                        }
                    } else {
                        System.out.println(ERROR_INPUT);
                    }
                } else if (currentUser.getUserRole() == UserRole.USER) {
                    System.out.println(USER_MENU);
                    input = scanner.nextLine();
                    if (input.matches("^[1-6]$")) {
                        switch (input) {
                            case "1":
                                viewAllLiterature();
                                break;
                            case "2":
                                addLiterature();
                                break;
                            case "3":
                                removeLiterature();
                                break;
                            case "4":
                                findLiterature();
                                break;
                            case "5":
                                currentUser = null;
                                break;
                            case "6":
                                toStay = false;
                        }
                    } else {
                        System.out.println(ERROR_INPUT);
                    }
                }
            } else {
                currentUser = signIn();
                if (currentUser == null) {
                    System.out.println(USER_NOT_FOUND);
                }
            }
        }
    }

    private static void viewAllLiterature() {
        Container request;
        Container response;

        Map<String, Object> model = new HashMap<>();
        request = new Container("VIEW_LITERATURE", model);
        response = Action.getInstance().createAction(request).execute(request);

        if ("Error".equals(response.header)) {
            System.out.println(response.model.get("message"));
        }
    }

    private static void addLiterature() {
        Container request;
        Container response;

        Map<String, Object> model = new HashMap<>();
        request = new Container("ADD_LITERATURE", model);
        response = Action.getInstance().createAction(request).execute(request);

        if ("Error".equals(response.header)) {
            System.out.println(response.model.get("message"));
        }
    }

    private static void removeLiterature() {
        Container request;
        Container response;

        Map<String, Object> model = new HashMap<>();
        request = new Container("REMOVE_LITERATURE", model);
        response = Action.getInstance().createAction(request).execute(request);

        if ("Error".equals(response.header)) {
            System.out.println(response.model.get("message"));
        }
    }

    private static void findLiterature() {
        Container request;
        Container response;

        Map<String, Object> model = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println(LITERATURE_SEARCH_MENU);
        String input = scanner.nextLine();

        if (input.matches("^[1-3]$")) {
            switch (input) {
                case "1":
                    System.out.println("Enter the title of literature");
                    model.put("name", scanner.nextLine());
                    break;
                case "2":
                    System.out.println("Enter author name");
                    model.put("author", scanner.nextLine());
                    break;
                case "3":
                    System.out.println("Enter the type of literature");
                    model.put("type", scanner.nextLine());
                    break;
            }
            request = new Container("FIND_LITERATURE", model);
            response = Action.getInstance().createAction(request).execute(request);
            if ("Success".equals(response.header)) {
                displayFoundLiterature((List<Literature>) response.model.get("books"));
            } else {
                System.out.println(response.model.get("message"));
            }
        } else {
            System.out.println(ERROR_INPUT);
        }
    }

    private static void displayFoundLiterature(List<Literature> literature) {
        StringBuilder displayLiterature = new StringBuilder();
        for (Literature lit : literature) {
            displayLiterature.append("Literature title: ").append(lit.getName()).append("\n");
            displayLiterature.append("Author's name: ").append(lit.getAuthor()).append("\n");
            displayLiterature.append("Type of literature: ").append(lit.getType()).append("\n");
        }
        System.out.println(displayLiterature);
    }
}

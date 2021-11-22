package by.epamtc.VaskevichArtsiom.task04.java.service.validation;

public class Validator {
    private final static String checkAuthorization = "^[a-zA-Z0-9_]+$";
    private final static String checkLiterature = "^[a-zA-Z0-9 ]+$";
    private final static String checkAuthor = "^[a-zA-Z]+$";

    public static boolean isValidUsername(String username) {
        return username.length() > 3 && username.length() < 40 && username.matches(checkAuthorization);
    }

    public static boolean isValidPassword(String password) {
        return password.length() > 5 && password.length() < 40 && password.matches(checkAuthorization);
    }

    public static boolean isValidLiteratureName(String name) {
        return name.matches(checkLiterature);
    }

    public static boolean isValidLiteratureAuthor(String author) {
        return author.matches(checkAuthor);
    }

    public static boolean isValidLiteratureType(String type) {
        return type.matches(checkLiterature);
    }
}

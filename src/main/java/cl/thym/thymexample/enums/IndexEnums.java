package cl.thym.thymexample.enums;

public enum IndexEnums {

    USER_TITLE("Users"),
    SEARCH_TITLE("Search User"),

    LOGIN_FIELD("Login"),

    ;

    private String value;

    private IndexEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

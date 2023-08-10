package cl.thym.thymexample.enums.entity;

public enum UserEnum {

    ID("ID"),
    USERNAME("Username"),

    ROLE_ID("Role ID")
    ;

    private String value;

    private UserEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

package cl.thym.thymexample.enums;

public enum Thymenum {

    TITLE("Thymexample App");

    private String value;

    private Thymenum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

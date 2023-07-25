package cl.thym.thymexample.ex;

public class NotFoundException extends Exception {

    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public NotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}

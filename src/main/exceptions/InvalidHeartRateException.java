package main.exceptions;

public class InvalidHeartRateException extends Exception {
    public InvalidHeartRateException(String message) {
        super(message);
    }
}
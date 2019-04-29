package it.thinkevent.utilis;

public class UserNotLoggedException extends Exception {
    public UserNotLoggedException(String errorMessage){
        super(errorMessage);
    }
}

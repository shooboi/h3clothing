package net.aptech.h3clothing.exception;

public class IllegalArgumentException extends ApplicationException{
    public IllegalArgumentException(String msg) {
        super(msg);
    }

    @Override
    public String getErrorCode() {
        return null;
    }
}

package net.aptech.h3clothing.exception;

public class DuplicateException extends ApplicationException {

    public DuplicateException(String msg) {
        super(msg);
    }

    @Override
    public String getErrorCode() {
        return null;
    }
}

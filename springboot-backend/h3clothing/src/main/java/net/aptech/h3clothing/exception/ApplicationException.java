package net.aptech.h3clothing.exception;

public abstract class ApplicationException extends RuntimeException{
    public ApplicationException(String msg){
        super(msg);
    }
    public abstract String getErrorCode();
}

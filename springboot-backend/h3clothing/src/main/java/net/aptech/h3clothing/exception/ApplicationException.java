package net.aptech.h3clothing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public abstract class ApplicationException extends RuntimeException{
    public ApplicationException(String msg){
        super(msg);
    }
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
    public abstract String getErrorCode();
}

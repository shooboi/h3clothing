package net.aptech.h3clothing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException{
    public AppException(String msg){
        super(msg);
    }
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}

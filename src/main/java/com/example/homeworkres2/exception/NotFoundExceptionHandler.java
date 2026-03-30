package com.example.homeworkres2.exception;

public class NotFoundExceptionHandler  extends  RuntimeException{
    public NotFoundExceptionHandler(String message) {
        super(message);
    }
    public NotFoundExceptionHandler(String message, Throwable message1) {
        super(message, message1);
    }

}

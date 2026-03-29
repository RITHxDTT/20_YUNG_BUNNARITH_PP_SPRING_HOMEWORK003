package com.example.homeworkres2.exception;

public class NotFoundExceptionHandler  extends  RuntimeException{
    public NotFoundExceptionHandler(String message) {
        super(message);
    }
}

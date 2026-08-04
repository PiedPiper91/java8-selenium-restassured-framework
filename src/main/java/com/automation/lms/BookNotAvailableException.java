package com.automation.lms;

public class BookNotAvailableException extends Exception {

    public BookNotAvailableException(String message){
        super(message);
    }

}
package org.scoula.todo.exception;

public class BadMenuException extends Exception{
    public BadMenuException(){
        super("Bad Menu");
    }
    public BadMenuException(String message){
        super(message);
    }
}

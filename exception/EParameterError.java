package edu.lab04;

import java.util.InputMismatchException;

public class EParameterError extends IllegalArgumentException{
    private static int code = 4;
    protected String pName;

    public EParameterError( String pName, String message) {
        super(String.format("Error code: %d, parametr name : %s, Message: %s",
                code,pName, message));
        this.pName = pName;
    }

    public EParameterError(String pName, String message, Throwable cause) {
        super(String.format("Error code: %d, parametr name : %s, Message: %s",
                code,pName, message), cause);
        this.pName = pName;
    }

}
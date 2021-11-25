package edu.lab04;

import java.io.IOException;

public class EDataFileIncorrectFooter extends IOException {
    private static int code = 1;

    public EDataFileIncorrectFooter(String message) {
        super(String.format("Error code: %d. Message: %s", code, message));
    }

    public EDataFileIncorrectFooter(String message, Throwable cause) {
        super(String.format("Error code: %d. Message: %s", code, message), cause);
    }

}

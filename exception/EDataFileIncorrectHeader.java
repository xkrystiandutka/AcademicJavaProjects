package edu.lab04;

import java.io.IOException;

public class EDataFileIncorrectHeader extends IOException {
    private static int code = 2;

    public EDataFileIncorrectHeader(String message) {
        super(String.format("Error code: %d. Message: %s", code, message));
    }

    public EDataFileIncorrectHeader(String message, Throwable cause) {
        super(String.format("Error code: %d. Message: %s", code, message), cause);
    }

}

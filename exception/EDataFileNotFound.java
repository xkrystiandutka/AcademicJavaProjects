package edu.lab04;

import java.io.FileNotFoundException;

public class EDataFileNotFound extends FileNotFoundException {
    private static int code = 3;

    public EDataFileNotFound(String message) {
        super(String.format("Error code: %d. Message: %s", code, message));
    }

}

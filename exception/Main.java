package edu.lab04;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static CDataFile badReference = null;
    private static Logger logger = Logger.getLogger("aLogger");
    private static FileHandler fh;

    private static PrintStream assignLogger() {
        try {
            fh = new FileHandler("c:\\temp\\mojLoger.log", true);
            logger.addHandler(fh);
            //logger.setUseParentHandlers(false);
            fh.setFormatter(new SimpleFormatter());
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void releaseLogger() {
        logger.removeHandler(fh);
    }

    public static void main(String[] args)  {
        assignLogger();
        try {
            //badReference.readFile();
            // CDataFile badDataFile = new CDataFile("C:\Users\User\Desktop\laboratorium4\src\resource\\file.dat");
            //CDataFile dataFile = new CDataFile("C:\Users\User\Desktop\laboratorium4\src\resource\\file-bad-header.dat");
            CDataFile dataFile = new CDataFile("C:\\Users\\User\\Desktop\\laboratorium4\\src\\resource\\file-bad-double.dat");
            //CDataFile dataFile = new CDataFile("C:\Users\User\Desktop\laboratorium4\src\resource\\file-bad-int.dat");
            //CDataFile dataFile = new CDataFile("C:\Users\User\Desktop\laboratorium4\src\resource\\file-bad-range-int.dat");
            dataFile.readFile();
            //}catch (EParameterErrorRange| EDataFileNotFound ee) {
            //}catch (EParameterError | EDataFileNotFound ee) {
        }catch (EParameterError| EDataFileNotFound | EDataFileIncorrectHeader | EDataFileIncorrectFooter ee) {
            logger.info(ee.getMessage());
        }
        releaseLogger();
    }


}

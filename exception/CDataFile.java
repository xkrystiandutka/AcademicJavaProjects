package edu.lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CDataFile {
    protected int intValue = 0;
    protected double doubleValue = 0.0;
    protected String fileName = null;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) throws EParameterErrorRange{
        if(intValue<10)
            throw new EParameterErrorRange("INT", "Wartość poniżej min. (10)");
        if(intValue>99)
            throw new EParameterErrorRange("INT", "Wartość powyżej max. (99)");
        this.intValue = intValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) throws EParameterErrorRange {
        if(doubleValue< 2.85)
            throw new EParameterErrorRange("DOUBLE", "Wartość poniżej min. (2.85)");
        if(doubleValue< 4.45)
            throw new EParameterErrorRange("DOUBLE", "Wartość powyżej max. (4.45)");
        this.doubleValue = doubleValue;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) throws EDataFileNotFound {
        assignFile(fileName);
        this.fileName = fileName;
    }

    private static final Scanner assignFile(String fileName) throws EDataFileNotFound{
        try{
            Scanner fileScanner = new Scanner(new File(fileName));
            fileScanner.useLocale(Locale.US);
            return fileScanner;
        } catch (FileNotFoundException e) {
            throw new EDataFileNotFound("Brak pliku danych: "+fileName);
        }
    }

    public CDataFile(String fileName) throws EDataFileNotFound {
        this.fileName = fileName;
    }

    public void readFile() throws EDataFileNotFound, EDataFileIncorrectFooter, EDataFileIncorrectHeader,EParameterError{
        Scanner fs = assignFile(this.fileName);
        try{
            //header
            try{
                String line = fs.nextLine();
                if(!line.contains("HEADER"))
                    throw new EDataFileIncorrectHeader("Błędny nagłówek pliku " + this.fileName);
            }catch(NoSuchElementException | IllegalStateException ee){
                throw new EDataFileIncorrectHeader("Nieudany odczyt nagłówka pliku " +this.fileName, ee);
            }
            //footer
            try{
                String line = fs.nextLine();
                if(!line.contains("Footer"))
                    throw new EDataFileIncorrectFooter("Błędna stopka pliku " + this.fileName);
            }catch(NoSuchElementException | IllegalStateException ee){
                throw new EDataFileIncorrectFooter("Nieudany odczyt stopki pliku " +this.fileName, ee);
            }
            // intValue
            try{
                int val = fs.nextInt();
                this.setIntValue(val);
                fs.nextLine();
            }catch(InputMismatchException ee){
                throw new EParameterError("INT", "Błędna wartość parametru.", ee);
            }catch(NoSuchElementException | IllegalStateException ee){
                throw new EParameterError("INT","Nieudany odczyt parametru.",ee);
            }
            //doubleValue
            try{
                double val = fs.nextDouble();
                this.setDoubleValue(val);
                fs.nextLine();
            }catch(InputMismatchException ee){
                throw new EParameterError("DOUBLE", "Błędna wartość parametru.", ee);
            }catch(NoSuchElementException | IllegalStateException ee){
                throw new EParameterError("DOUBLE","Nieudany odczyt parametru.",ee);
            }

        }finally{
            fs.close();
        }
    }

    public static int readIntValue(String fileName) throws EDataFileNotFound{
        try(Scanner fs = assignFile(fileName)){
            fs.nextLine();
            int val = fs.nextInt();
            return val;
        }catch (InputMismatchException ee){
            throw new EParameterError("INT", "Błędna wartośćw readInt().", ee);
        }catch(NoSuchElementException | IllegalStateException ee){
            throw new EParameterError("INT", "Nieudany odczyt, readInt().",ee);

        }
    }
}

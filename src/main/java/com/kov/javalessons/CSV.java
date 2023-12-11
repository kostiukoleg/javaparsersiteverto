package com.kov.javalessons;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    
    private static String csvFilePath = "example.csv";
    private static char customDelimiter = ';';
    private static Charset encoding = Charset.forName("windows-1251");

    /**
    * Constructs a new CSV object.
    * This constructor initializes the CSV object with default values or performs any necessary setup.
    * 
    * Example usage:
    * ```
    * CSV csvReader = new CSV();
    * ```
    * 
    * Note: Additional configuration methods may be called on the created object to customize its behavior.
    */
    public CSV() {
    }
    /**
    * Constructs a new CSV object with specified parameters.
    * This constructor initializes the CSV object with the provided CSV file path, character set name,
    * and custom delimiter.
    * 
    * @param argsCsvFilePath The file path to the CSV file.
    * @param argsCustomDelimiter The custom delimiter used in the CSV file.
    * 
    * Example usage:
    * ```
    * CSV csvReader = new CSV("path/to/file.csv", "UTF-8", ';');
    * ```
    * 
    * Note: Ensure that the provided CSV file path and character set name are valid.
    */
    public CSV(String argsCsvFilePath, String argsCharsetName, char argsCustomDelimiter) {
        csvFilePath = argsCsvFilePath;
        customDelimiter = argsCustomDelimiter;
        encoding = Charset.forName(argsCharsetName);
    }
    
    /**
     *
     * @param data List of String Array to write in the CSV file
     * @author olegk
     */
    public static void createCsvFile(List<String[]> data) {
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(csvFilePath, encoding), customDelimiter,
                                CSVWriter.NO_QUOTE_CHARACTER,
                                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                                CSVWriter.DEFAULT_LINE_END);
            writer.writeAll(data);
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Charset not found: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Can't close Stream: " + e.getMessage());
                }
            }
        }
    }
    /**
     *
     * @return List<String[]> resultList
     * @author olegk
     */
    public static List<String[]> readCsvFile() {

        List<String[]> resultList = new ArrayList<>();
        List<String[]> existingData;
        CSVReader reader = null;

        try {
            reader = new CSVReader(new FileReader(csvFilePath, encoding));
            existingData = reader.readAll();
            for (String[] item : existingData){
                String joinedString = String.join(",", item);
//                String newString = Parser.RegexReplaceAll(joinedString,"(?<!\\');", "");
//                resultList.add(newString.split(";(?!')"));
                resultList.add(joinedString.split(";"));
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Charset not found: " + e.getMessage());
        } catch (CsvException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Can't close Stream: " + e.getMessage());
                }
            }
        }
        return resultList;
    }
    public static String[] checkForSymbol(String[] data) {
        String[] res = {};
        for (String line : data) {
          res = Parser.pushArray(res, Parser.RegexReplaceAll(line,"(?<!\\');", ""));
        }
        return res;
    }
    /**
     *
     * @param newData Appending new data to the existing file
     * @author olegk
     */
    public static void updateCsvFile(String[] newData) {
        List<String[]> resultList;
        resultList = readCsvFile();       
        resultList.add(checkForSymbol(newData));
        createCsvFile(resultList);
    }
    /**
    * The main entry point of the Java program.
    * This method is automatically called when the program is executed.
    *
    * @param args Command-line arguments provided to the program.
    * These can be used to pass inputs to the program from the command line.
    * @author olegk
    */
    public static void main(String[] args) {
        List<String[]> resultList = new ArrayList<>();
        resultList.add(Data.productsData);
        createCsvFile(resultList);
        updateCsvFile(Data.productsData1);
    }
}
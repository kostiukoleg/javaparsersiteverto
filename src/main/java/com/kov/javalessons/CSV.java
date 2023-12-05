package com.kov.javalessons;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    
    private static String csvFilePath = "example.csv";
    private static String charsetName = "windows-1251";
    private static char customDelimiter = ';';
    
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
    * @param argsCharsetName The character set name for encoding and decoding CSV files.
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
        charsetName = argsCharsetName;
        customDelimiter = argsCustomDelimiter;
    }
    
    /**
     *
     * @param data
     * @throws java.io.IOException
     * @throws com.opencsv.exceptions.CsvException
     * @author olegk
     */
    public static void createCsvFile(List<String[]> data) throws IOException, CsvException {
        System.out.print(charsetName);
        Charset encoding = Charset.forName(charsetName);
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath, encoding), customDelimiter, 
                                    CSVWriter.NO_QUOTE_CHARACTER,
                                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                                    CSVWriter.DEFAULT_LINE_END)) {
            writer.writeAll(data);
        }
    }
    /**
     *
     * @return List<String[]> resultList
     * @throws java.io.IOException
     * @throws com.opencsv.exceptions.CsvException
     * @author olegk
     */
    public static List<String[]>readCsvFile() throws IOException, CsvException {
        List<String[]> resultList = new ArrayList<>();
        List<String[]> existingData;
        Charset encoding = Charset.forName(charsetName);
    
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath, encoding))) {
            existingData = reader.readAll();
        }
        for (String[] item : existingData){
            String joinedString = String.join(",", item);   
            resultList.add(joinedString.split(";"));    
        }
        return resultList;
    }
    /**
     *
     * @param newData
     * @throws java.io.IOException
     * @throws com.opencsv.exceptions.CsvException
     * @author olegk
     */
    public static void updateCsvFile(String[] newData) throws IOException, CsvException {
        List<String[]> resultList;
        resultList = readCsvFile();       
        resultList.add(newData);
        createCsvFile(resultList);
    }
    /**
    * The main entry point of the Java program.
    * This method is automatically called when the program is executed.
    *
    * @param args Command-line arguments provided to the program.
    * These can be used to pass inputs to the program from the command line.
    * @throws java.io.IOException
    * @throws com.opencsv.exceptions.CsvException
    * @author olegk
    */
    public static void main(String[] args) throws IOException, CsvException {
        List<String[]> resultList = new ArrayList<>();      
        resultList.add(Data.data1);
        resultList.add(Data.data2);
        createCsvFile(resultList);
        updateCsvFile(Data.newData);
    }
}
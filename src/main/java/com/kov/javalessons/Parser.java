package com.kov.javalessons;

import com.opencsv.exceptions.CsvException;
import org.jsoup.*; 
import org.jsoup.nodes.*; 
import java.io.IOException;
import java.util.List;
import java.util.regex.PatternSyntaxException;
/**
 * The `Parser` class serves as the main entry point for the application,
 * orchestrating the execution of various auxiliary functions.
 * 
 * Responsibilities:
 * - Acts as the central coordinator for parsing operations.
 * - Launches and manages auxiliary functions for processing input data.
 * 
 * Usage:
 * - Create an instance of the `Parser` class to initiate parsing tasks.
 * - Utilize the provided auxiliary functions to perform specific parsing actions.
 * 
 * Example:
 * ```
 * Parser.main();
 * ```
 * 
 * Note: Additional details about specific auxiliary functions can be found
 * within their respective method implementations in this class.
 */
public class Parser {
    public static String[] pushArray(String[] oldArray, String newVal){
        String[] newArray = new String[oldArray.length + 1];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        newArray[newArray.length - 1] = newVal;
        return newArray;
    }
    public static int[] pushArray(int[] oldArray, int newVal){
        int[] newArray = new int[oldArray.length + 1];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        newArray[newArray.length - 1] = newVal;
        return newArray;
    }
    /**
    * Converts a Cyrillic string to its Latin equivalent.
    *
    * @param cyrillic The input string in Cyrillic script to be converted.
    * @return A new string representing the Latin equivalent of the input Cyrillic string.
    * @throws NullPointerException if the input string is null.
    */
    public static String convertCyrillicToLatin(String cyrillic) {
         
        String[] cyrillicChars = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};
        String[] latinChars = {"a", "b", "v", "g", "d", "e", "yo", "zh", "z", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "kh", "ts", "ch", "sh", "shch", "", "y", "", "e", "yu", "ya"};
        try {
            for (int i = 0; i < cyrillicChars.length; i++) {
                cyrillic = cyrillic.replace(cyrillicChars[i], latinChars[i]);
                cyrillic = cyrillic.replace(cyrillicChars[i].toUpperCase(), latinChars[i].toUpperCase());
            } 
        } catch (NullPointerException e) {  // Catch any NullPointerException that might occur if the input string is null.
            throw new RuntimeException(e);  // If a NullPointerException occurs, it's wrapped in a RuntimeException and thrown.
        }
        return cyrillic;
    }
    /**
    * This function is named 'JsoupConnect' and it's a public and static method. 
    * It takes a String 'url' as an argument and returns a Document object.
    *
    * @param url The URL to connect to.
    * @return Document object after successfully connecting to the URL.
    * @throws RuntimeException if an IOException occurs during the connection process.
    */ 
    public static Document JsoupConnect(String url) {
        Document doc; 
        try {    
            doc = Jsoup.connect(url).get(); 
        } catch (IOException e) { 
            throw new RuntimeException(e); 
        }
        return doc;
    }
    /**
     * Replaces all occurrences of a specified regex pattern in a given string with a replacement string.
     *
     * @param data    The input string where replacements will be made.
     * @param regex   The regular expression pattern to find in the input string.
     * @param replace The string to replace each match of the regex pattern.
     * @return A new string resulting from replacing all occurrences of the regex pattern with the replacement string.
     * @throws PatternSyntaxException if the regular expression's syntax is invalid.
    */
    public static String RegexReplaceAll(String data, String regex, String replace){
        String res;
        try {
            res = data.replaceAll(regex,replace);
        } catch (PatternSyntaxException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public static void main(String[] args) throws IOException, CsvException {
        Category c = new Category();
        List<Category> categories = c.index(AppConfig.CATEGORY_SITE_URL);
        String[] data_c_Array = new String[17];
        String[] data_p_Array = new String[25];
        int catIdNumber = Integer.parseInt(Data.categoryData1[14]);
        int prodIdNumber = Integer.parseInt(Data.productsData1[17]);
        List<Products> products;
        Products ps = new Products();
        OneProduct p = new OneProduct();
        //Image image = new Image();
//        String[] folders = {"category"};
        String[] folders = {"products"};
        for(Category item_c: categories){
//           image.download(item.getImage(), folders);
            data_c_Array[0] = item_c.getName();
            data_c_Array[1] = convertCyrillicToLatin(item_c.getName()).toLowerCase();
            data_c_Array[2] = Data.newCategoryData[2];
            data_c_Array[3] = Data.newCategoryData[3];
            data_c_Array[4] = Data.newCategoryData[4];
            data_c_Array[5] =  "/uploads/"+Image.getFileNameFromUrl(item_c.getImage());
            data_c_Array[6] = Data.newCategoryData[6];
            data_c_Array[7] = Data.newCategoryData[7];
            data_c_Array[8] = Data.newCategoryData[8];
            data_c_Array[9] = Data.newCategoryData[9];
            data_c_Array[10] = Data.newCategoryData[10];
            data_c_Array[11] = Data.newCategoryData[11];
            data_c_Array[12] = Data.newCategoryData[12];
            data_c_Array[13] = Data.newCategoryData[13];
            data_c_Array[14] = String.valueOf(++catIdNumber);
            data_c_Array[15] = Data.newCategoryData[15];
            data_c_Array[16] = data_c_Array[14];
//           CSV.updateCsvFile(dataArray);
            products = ps.index(item_c.getUrl());
            for(Products item_p: products){
                OneProduct data_p = p.index(item_p.getUrl());
                //image.download(data_p.getImage(), folders);
                data_p_Array[0] = "Межкомнатные двери/Verto/"+item_c.getName();
                data_p_Array[1] = "mezhkomnatnye-dveri-vinnica/verto/"+convertCyrillicToLatin(item_c.getName()).toLowerCase();
                data_p_Array[2] = "Дверне полотно "+data_p.getName();
                data_p_Array[3] = Data.productsData1[3];
                data_p_Array[4] = data_p.getDescription();
                data_p_Array[5] = Data.productsData1[5];
                data_p_Array[6] = convertCyrillicToLatin(data_p_Array[2]).toLowerCase();
                data_p_Array[7] = "1.0-2-306x350.jpg[:param:][alt=Дверне полотно 1.0][title=Дверне полотно 1.0]";
            }
        }       
    }
}

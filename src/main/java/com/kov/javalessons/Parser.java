package com.kov.javalessons;

import com.opencsv.exceptions.CsvException;
import org.jsoup.*; 
import org.jsoup.nodes.*; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
     public static String convertCyrillicToLatin(String cyrillic) {
         
        String[] cyrillicChars = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};
        String[] latinChars = {"a", "b", "v", "g", "d", "e", "yo", "zh", "z", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "kh", "ts", "ch", "sh", "shch", "", "y", "", "e", "yu", "ya"};

        for (int i = 0; i < cyrillicChars.length; i++) {
            cyrillic = cyrillic.replace(cyrillicChars[i], latinChars[i]);
            cyrillic = cyrillic.replace(cyrillicChars[i].toUpperCase(), latinChars[i].toUpperCase());
        }

        return cyrillic;
    }
     
    public static Document JsoupConnect(String url) {
        Document doc; 
        try {    
            doc = Jsoup.connect(url).get(); 
        } catch (IOException e) { 
            throw new RuntimeException(e); 
        }
        return doc;
    }

    public static String RegexReplaceAll(String data, String regex, String replace){
        String res = data.replaceAll(regex,replace);
        return res;
    }

    public static void main(String[] args) throws IOException, CsvException {
        Category c = new Category();
        Image image = new Image();
        String[] folders = {"category"};
        List<Category> resultList = c.index(AppConfig.CATEGORY_SITE_URL_SELECTOR);
        String[] dataArray = new String[17];
        int idNumber = Integer.parseInt(Data.newData[14]);
        for(Category item: resultList){
           image.download(item.getImage(), folders);
           dataArray[0] = item.getName();
           dataArray[1] = convertCyrillicToLatin(item.getName()).toLowerCase();
           dataArray[2] = Data.newData[2];
           dataArray[3] = Data.newData[3];
           dataArray[4] = Data.newData[4];
           dataArray[5] =  "/uploads/"+image.getFileNameFromUrl(item.getImage());
           dataArray[6] = Data.newData[6];
           dataArray[7] = Data.newData[7];
           dataArray[8] = Data.newData[8];
           dataArray[9] = Data.newData[9];
           dataArray[10] = Data.newData[10];
           dataArray[11] = Data.newData[11];
           dataArray[12] = Data.newData[12];
           dataArray[13] = Data.newData[13];
           idNumber = ++idNumber;
           dataArray[14] = String.valueOf(idNumber);
           dataArray[15] = Data.newData[15];
           dataArray[16] = dataArray[14];
           CSV.updateCsvFile(dataArray);
        }
        
        Products p = new Products();
        System.out.println(p.index("https://verto-doors.com/ru/product-category/doors/%d0%ba%d0%bb%d0%b0%d1%81%d1%81%d0%b8%d0%ba/").get(0));
    }
}

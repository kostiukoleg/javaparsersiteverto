package com.kov.javalessons;

import org.jsoup.*; 
import org.jsoup.nodes.*; 
import java.io.IOException;
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

    public static void main(String[] args) {
        Category c = new Category();
        System.out.println(c.index("https://verto-doors.com/ru/product-category/doors/"));
        OneProduct p = new OneProduct();
        System.out.println(p.index("https://verto-doors.com/ru/product/%d1%81%d1%82%d0%b0%d0%bd%d0%b4%d0%b0%d1%80%d1%82-1a/"));
    }
}

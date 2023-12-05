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
        System.out.println(c.index(AppConfig.CATEGORY_SITE_URL_SELECTOR));
        OneProduct p = new OneProduct();
        System.out.println(p.index(AppConfig.PRODUCT_SITE_URL_SELECTOR));
    }
}

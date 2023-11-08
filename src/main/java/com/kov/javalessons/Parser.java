package com.kov.javalessons;

import org.jsoup.*; 
import org.jsoup.nodes.*; 
import java.io.IOException;
/**
 *
 * @author olegk
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

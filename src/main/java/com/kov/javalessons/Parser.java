package com.kov.javalessons;

import org.jsoup.*; 
import org.jsoup.nodes.*; 
import java.io.IOException;
import java.util.List;
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
        List<Category> res = c.index();
        System.out.println(res);
    }
}

package com.kov.javalessons;

import static com.kov.javalessons.Parser.JsoupConnect;

import java.util.HashMap;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class OneProduct {
    private String url;
    private String image;
    private String name;
    private String description;
    private static OneProduct singleInstance;

    private OneProduct() {}

    public OneProduct (String url, String image, String name, String description) {
        this.url = url;
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public static OneProduct getInstance() {
        // Write code that allows us to create only one object
        if (singleInstance == null) {
            singleInstance = new OneProduct();
            System.out.println("Creating One Product");
        }
        return singleInstance;
    }
    
    public OneProduct GetProduct(Document doc, HashMap<String, String> selector){
        String sel = selector.get("main");
        Element item = doc.selectFirst(sel);
        OneProduct product = null;
        if (item != null){
            String prodURL = item.select(selector.get("url")).attr("content");
            String prodIMG = item.select(selector.get("image")).attr("src");
            String clearName = item.select(selector.get("name")).text(); 
            String prodDescription = item.select(selector.get("description")).outerHtml();
            product = new OneProduct(prodURL, prodIMG, clearName,prodDescription);
        }
        return product;
    }
    
     public String getUrl() {
        return url;
    }
    
    public String getImage() {
        return image;
    }
    
    public String getName() {
        return name;
    }  
    public String getDescription() {
        return description;
    } 
    @Override
    public String toString(){
        return "{ \"url\":\""+url+"\", "
        +"\"image\":\""+image+"\", "
        +"\"name\":\""+name+"\","
        +"\"description\":\""+description+"\" }";
    }
    public OneProduct index(String url) {
        HashMap<String,String> selector = new HashMap<>();
        selector.put("main", AppConfig.PRODUCT_MAIN_SELECTOR);
        selector.put("url", AppConfig.PRODUCT_URL_SELECTOR);
        selector.put("image", AppConfig.PRODUCT_IMAGE_SELECTOR);
        selector.put("name", AppConfig.PRODUCT_NAME_SELECTOR);
        selector.put("description", AppConfig.PRODUCT_DESCRIPTION_SELECTOR);
        Document doc = JsoupConnect(url);
        return this.GetProduct(doc,selector);
    }
}

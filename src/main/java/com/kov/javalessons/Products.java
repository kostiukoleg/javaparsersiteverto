package com.kov.javalessons;

import static com.kov.javalessons.Parser.JsoupConnect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Products {
    private String url;
    private String image;
    private String name;
    private static Products singleInstance;

    private Products() {}

    public Products (String url, String image, String name) {
        this.url = url;
        this.image = image;
        this.name = name;
    }

    public static Products getInstance() {
        if (singleInstance == null) {
            singleInstance = new Products();
            System.out.println("Creating Products");
        }
        return singleInstance;
    }
    
    public List<Products> GetListProducts(Document doc, HashMap<String, String> selector){
        String sel = selector.get("url");
        Elements items = doc.select(sel);
        List<Products> products = new ArrayList<>();
        for (Element item : items){
            String prodURL = item.attr("href");
            String prodIMG = item.select("img").attr("src");
            String clearName = item.select("h3").text(); 
            Products product = new Products(prodURL, prodIMG, clearName);
            products.add(product);
        }
        return products;
    }
    
    public String getUrl() {
        return url;
    }
    
    public String getImage() { return image; }
    
    public String getName() {
        return name;
    }  
    
    @Override
    public String toString(){
        return "{ \"url\":\""+url+"\", "
        +"\"image\":\""+image+"\", "
        +"\"name\":\""+name+"\" }";
    }

    public List<Products> index(String url) {
        HashMap<String,String> selector = new HashMap<>();
        selector.put("url", AppConfig.PRODUCTS_URL_SELECTOR);
        selector.put("image", AppConfig.PRODUCTS_IMAGE_SELECTOR);
        selector.put("name", AppConfig.PRODUCTS_NAME_SELECTOR);
        Document doc = JsoupConnect(url);
        return this.GetListProducts(doc,selector);
    }
}

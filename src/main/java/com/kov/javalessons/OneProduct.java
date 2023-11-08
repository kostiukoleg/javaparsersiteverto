package com.kov.javalessons;

import static com.kov.javalessons.Parser.JsoupConnect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OneProduct {
    private String url;
    private String image;
    private String name;
    private String description;
    private boolean INSTANCE = false;
    private List<OneProduct> oneProduct;
    
    public OneProduct () {
        if(this.INSTANCE == false){
            this.oneProduct = new ArrayList<>();
            System.out.println("Creating One Product");
        }
        this.INSTANCE = true;
    }
    public OneProduct (String url, String image, String name, String description) {
        this.url = url;
        this.image = image;
        this.name = name;
        this.description = description;
    }
     public List<OneProduct> GetProduct(Document doc, HashMap<String, String> selector){
        String sel = selector.get("main");
        Elements items = doc.select(sel);
        for (Element item : items){
            String prodURL = item.select(selector.get("url")).attr("content");
            String prodIMG = item.select(selector.get("image")).attr("src");
            String clearName = item.select(selector.get("name")).text(); 
            String prodDescription = item.select(selector.get("description")).outerHtml();
            OneProduct product = new OneProduct(prodURL, prodIMG, clearName,prodDescription);
            oneProduct.add(product);
        }
        return oneProduct;
    }
    @Override
    public String toString(){
        return "{ \"url\":\""+url+"\", "
        +"\"image\":\""+image+"\", "
        +"\"name\":\""+name+"\","
        +"\"description\":\""+description+"\" }";
    }
    List<OneProduct> index(String url) {
        HashMap<String,String> selector = new HashMap<>();
        selector.put("main", "div[role='main'] div.product");
        selector.put("url", "meta[itemprop='url']");
        selector.put("image", "div.images a img");
        selector.put("name", "h1[itemprop='name']");
        selector.put("description", "div[itemprop='description']");
        Document doc = JsoupConnect(url);
        List<OneProduct> res = this.GetProduct(doc,selector);
        return res;
    }
}

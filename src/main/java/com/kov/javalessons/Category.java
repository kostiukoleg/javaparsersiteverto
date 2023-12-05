package com.kov.javalessons;

import static com.kov.javalessons.Parser.JsoupConnect;
import static com.kov.javalessons.Parser.RegexReplaceAll;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Category {
    private String url;
    private String image;
    private String name;
    private boolean INSTANCE = false;
    private List<Category> categories;
    
    public Category () {
        if(this.INSTANCE == false){
            this.categories = new ArrayList<>();
            System.out.println("Creating Category");
        }
        this.INSTANCE = true;
    }
     
    public Category (String url, String image, String name) {
        this.url = url;
        this.image = image;
        this.name = name;
    }
      
    public List<Category> GetListCategories(Document doc, HashMap<String, String> selector){
        String sel = selector.get("url");
        Elements items = doc.select(sel);
        for (Element item : items){
            String catURL = item.attr("href");
            String catIMG = item.select("img").attr("src");
            String clearName = RegexReplaceAll(item.select("h3").html(),"\\s<mark class=\"count\">.+</mark>",""); 
            Category category = new Category(catURL, catIMG, clearName);
            categories.add(category);
        }
        return categories;
    }
   
    @Override
    public String toString(){
        return "{ \"url\":\""+url+"\", "
        +"\"image\":\""+image+"\", "
        +"\"name\":\""+name+"\" }";
    }

    List<Category> index(String url) {
        HashMap<String,String> selector = new HashMap<>();
        selector.put("url", AppConfig.CATEGORY_URL_SELECTOR);
        selector.put("image", AppConfig.CATEGORY_IMAGE_SELECTOR);
        selector.put("name", AppConfig.CATEGORY_NAME_SELECTOR);
        Document doc = JsoupConnect(url);
        List<Category> res = this.GetListCategories(doc,selector);
        return res;
    }
}

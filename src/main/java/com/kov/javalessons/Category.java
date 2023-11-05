package com.kov.javalessons;

import static com.kov.javalessons.Parser.JsoupConnect;
import static com.kov.javalessons.Parser.RegexReplaceAll;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author olegk
 */
public class Category {
   private String url;
   private String image;
   private String name;
   
   List<Category> categories = new ArrayList<>();
   
   public List<Category> GetText(Document doc, String selector){
        Elements items = doc.select(selector);
        for (Element item : items){
            Category category = new Category();
            category.setName(item.text());
            categories.add(category);
        }
        return categories;
    }
   
    public List<Category> GetHTML(Document doc, HashMap<String, String> selector){
        String sel = selector.get("url");
        Elements items = doc.select(sel);
        for (Element item : items){
            Category category = new Category();
            String catURL = item.attr("href");
            category.setURL(catURL);
            String catIMG = item.select("img").attr("src");
            category.setImage(catIMG);
            String clearName = RegexReplaceAll(item.select("h3").html(),"\s<mark class=\"count\">.+</mark>","");
            category.setName(clearName);
            categories.add(category);
        }
        return categories;
    }
   
    public String getURL(){
        return url;
    }
    
    public void setURL(String url){
        this.url = url;
    }
    
    public String getImage(){
        return image;
    }
    
    public void setImage(String image){
        this.image = image;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return "{ \"url\":\""+url+"\", "
        +"\"image\":\""+image+"\", "
        +"\"name\":\""+name+"\" }";
    }

    List<Category> index() {
        HashMap<String,String> selector = new HashMap<>();
        selector.put("url", "li.product-category a");
        selector.put("image", "li.product-category a img");
        selector.put("name", "li.product-category a h3");
        Document doc = JsoupConnect("https://verto-doors.com/ru/product-category/doors/");
        List<Category> res = this.GetHTML(doc,selector);
        return res;
    }
}

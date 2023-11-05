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
 
    public Category (String url, String image, String name) {
        this.url = url;
        this.image = image;
        this.name = name;
    }
    public Category () {
        if(this.INSTANCE == false){
            this.categories = new ArrayList<>();
            System.out.println("Creating Category");
        }
        this.INSTANCE = true;
    }
   
//    public List<Category> GetText(Document doc, String selector){
//        Elements items = doc.select(selector);
//        for (Element item : items){
//            Category category = new Category();
//            category.setName(item.text());
//            categories.add(category);
//        }
//        return categories;
//    }
   
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

    List<Category> index() {
        HashMap<String,String> selector = new HashMap<>();
        selector.put("url", "li.product-category a");
        selector.put("image", "li.product-category a img");
        selector.put("name", "li.product-category a h3");
        Document doc = JsoupConnect("https://verto-doors.com/ru/product-category/doors/");
        List<Category> res = this.GetListCategories(doc,selector);
        return res;
    }
}

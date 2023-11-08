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
    private boolean INSTANCE = false;
    private List<Products> products;
    
    public Products (String url, String image, String name) {
        this.url = url;
        this.image = image;
        this.name = name;
    }
    public Products () {
        if(this.INSTANCE == false){
            this.products = new ArrayList<>();
            System.out.println("Creating Products");
        }
        this.INSTANCE = true;
    }
    public List<Products> GetListProducts(Document doc, HashMap<String, String> selector){
        String sel = selector.get("url");
        Elements items = doc.select(sel);
        for (Element item : items){
            String prodURL = item.attr("href");
            String prodIMG = item.select("img").attr("src");
            String clearName = item.select("h3").text(); 
            Products product = new Products(prodURL, prodIMG, clearName);
            products.add(product);
        }
        return products;
    }
    @Override
    public String toString(){
        return "{ \"url\":\""+url+"\", "
        +"\"image\":\""+image+"\", "
        +"\"name\":\""+name+"\" }";
    }

    List<Products> index(String url) {
        HashMap<String,String> selector = new HashMap<>();
        selector.put("url", "ul.products li.product a.woocommerce-LoopProduct-link");
        selector.put("image", "ul.products li.product a.woocommerce-LoopProduct-link img");
        selector.put("name", "ul.products li.product a.woocommerce-LoopProduct-link h3");
        Document doc = JsoupConnect(url);
        List<Products> res = this.GetListProducts(doc,selector);
        return res;
    }
}

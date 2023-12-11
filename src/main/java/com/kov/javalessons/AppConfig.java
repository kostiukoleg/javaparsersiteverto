/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kov.javalessons;

/**
 *
 * @author olegk
 */
public class AppConfig {
    public static final String FOLDER_DELIMITER = "\\";
    public static final String PRODUCTS_SITE_URL = "https://verto-doors.com/ru/product-category/doors/%d0%ba%d0%bb%d0%b0%d1%81%d1%81%d0%b8%d0%ba/"; 
    public static final String PRODUCT_SITE_URL = "https://verto-doors.com/ru/product/%d1%81%d1%82%d0%b0%d0%bd%d0%b4%d0%b0%d1%80%d1%82-1a/";
    public static final String CATEGORY_SITE_URL = "https://verto-doors.com/ru/product-category/doors/";
    
    public static final String CATEGORY_URL_SELECTOR = "li.product-category a";
    public static final String CATEGORY_IMAGE_SELECTOR = "li.product-category a img";
    public static final String CATEGORY_NAME_SELECTOR = "li.product-category a h3";
    
    public static final String PRODUCTS_URL_SELECTOR = "ul.products li.product a.woocommerce-LoopProduct-link";
    public static final String PRODUCTS_IMAGE_SELECTOR = "ul.products li.product a.woocommerce-LoopProduct-link img";
    public static final String PRODUCTS_NAME_SELECTOR = "ul.products li.product a.woocommerce-LoopProduct-link h3";
    
    public static final String PRODUCT_URL_SELECTOR = "meta[itemprop='url']";
    public static final String PRODUCT_IMAGE_SELECTOR = "div.images a img";
    public static final String PRODUCT_NAME_SELECTOR = "h1[itemprop='name']";
    public static final String PRODUCT_DESCRIPTION_SELECTOR ="div[itemprop='description']";
    public static final String PRODUCT_MAIN_SELECTOR ="div[role='main'] div.product";
}

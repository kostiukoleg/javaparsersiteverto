/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kov.javalessons;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
/**
 *
 * @author olegk
 */
public class Image {
    private URL imageUrl;
    private Path destinationPath;
    private static final String FOLDER_PATH = "images";
    
    private Path imagePath(String imgUrl, String[] folders) {
        String subFolders = String.join("\\", folders);
        String destinationFolderPath = String.join("\\", System.getProperty("user.dir"), FOLDER_PATH, subFolders);
        destinationPath = Path.of(destinationFolderPath, getFileNameFromUrl(imgUrl));
        try {
            Files.createDirectories(destinationPath.getParent());
        } catch (IOException e) {
            System.err.println("Can't create folder: " + e.getMessage());
        }
        return destinationPath;
    }
    private Path imagePath(String imgUrl) {
        String destinationFolderPath = String.join("\\", System.getProperty("user.dir"), FOLDER_PATH);
        destinationPath = Path.of(destinationFolderPath, getFileNameFromUrl(imgUrl));
        try {
            Files.createDirectories(destinationPath.getParent());
        } catch (IOException e) {
            System.err.println("Can't create folder: " + e.getMessage());
        }
        return destinationPath;
    }
    private String getFileNameFromUrl(String url) {
        String[] parts = url.split("/");
        return parts[parts.length - 1];
    }
    public void download(String imgUrl, String[] folders) {
        try {
            imageUrl = new URL(imgUrl);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL: " + imageUrl, e);
        }        
        try (InputStream in = imageUrl.openStream()) {
            Files.copy(in, imagePath(imgUrl, folders), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image downloaded successfully to: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Error downloading image: " + e.getMessage());
        }
    }
    public void download(String imgUrl) {
        try {
            imageUrl = new URL(imgUrl);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL: " + imageUrl, e);
        }        
        try (InputStream in = imageUrl.openStream()) {
            Files.copy(in, imagePath(imgUrl), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image downloaded successfully to: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Error downloading image: " + e.getMessage());
        }
    }
//    public static void main(String[] args) {
//        String imageUrl = "https://verto-doors.com/wp-content/uploads/2021/08/стандарт-000-300x300.png";
//        Image image = new Image();
//        String[] folders = {"category"};
//        image.download(imageUrl);
//    }
}
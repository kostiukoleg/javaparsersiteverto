package com.kov.javalessons;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
/**
 *
 * @author olegk
 */
public class Image implements Runnable {
    private URI imageUrl;
    private static final String FOLDER_PATH = "images";
    private final Path destinationPath;
    private static final String destinationFolderPath = String.join(AppConfig.FOLDER_DELIMITER, System.getProperty("user.dir"), FOLDER_PATH);

    Image(String imgUrl) {
        try {
            this.imageUrl = new URI(imgUrl);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid URL: " + imageUrl, e);
        }
        this.destinationPath = Path.of(destinationFolderPath, getFileNameFromUrl(imgUrl));
        try {
            Files.createDirectories(destinationPath.getParent());
        } catch (IOException e) {
            System.err.println("Can't create folder: " + e.getMessage());
        }
    }
    Image(String imgUrl, String[] folders) {
        try {
            this.imageUrl = new URI(imgUrl);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid URL: " + imageUrl, e);
        }
        String destinationFP = String.join(AppConfig.FOLDER_DELIMITER, destinationFolderPath, String.join(AppConfig.FOLDER_DELIMITER, folders));
        this.destinationPath = Path.of(destinationFP, getFileNameFromUrl(imgUrl));
        try {
            Files.createDirectories(destinationPath.getParent());
        } catch (IOException e) {
            System.err.println("Can't create folder: " + e.getMessage());
        }
    }
    public static String getFileNameFromUrl(String url) {
        String[] parts = url.split("/");
        return Parser.convertCyrillicToLatin(parts[parts.length - 1]).toLowerCase();
    }
    public void download(String[] folders) {
        try {
            InputStream in = imageUrl.toURL().openStream();
            Files.copy(in, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image downloaded successfully to: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Error downloading image: " + e.getMessage());
        }
    }
    public void download() {
        try {
            InputStream in = imageUrl.toURL().openStream();
            Files.copy(in, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image downloaded successfully to: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Error downloading image: " + e.getMessage());
        }
    }
    @Override
    public void run() {
        try {
            InputStream in = imageUrl.toURL().openStream();
            Files.copy(in, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image downloaded successfully to: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Error downloading image: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String[] folders = {"category", "new"};
        Thread thread = new Thread(new Image("https://verto-doors.com/wp-content/uploads/2021/08/стандарт-000-300x300.png", folders));
        thread.start();
    }
}
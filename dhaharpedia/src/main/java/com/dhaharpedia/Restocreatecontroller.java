package com.dhaharpedia;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Restocreatecontroller {
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField nama;
    @FXML
    private TextField kategori;
    @FXML
    private TextField kontak;
    @FXML
    private TextArea alamat;
    @FXML
    private TextField rating;
    @FXML
    private TextField jumlahorang;

    @FXML
    public void Submit() throws IOException{
        // get data from form
        String nama1 = nama.getText();
        String kategori1 = kategori.getText();
        String kontak1 = kontak.getText();
        String alamat1 = alamat.getText();
        String rating1 = rating.getText();
        String jumlahorang1 = jumlahorang.getText();
        
        Restaurant restoran = new Restaurant(nama1, alamat1, kontak1, Float.parseFloat(rating1), kategori1, imageBytes, Integer.parseInt(jumlahorang1));
        
        // add to database
        homecontroller homecontoller = new homecontroller();
        homecontoller.data.addRestaurant(restoran);

        Scene currentScene = back.getScene();
        
        // Modify the size of the window
        Stage currentStage = (Stage) currentScene.getWindow();
        currentStage.setWidth(1200); // Set the width
        currentStage.setHeight(1000); // Set the height
        
        // Switch to the "restocreate" page
        App.setRoot("home");
        

       
    }
    private byte[] imageBytes;

    @FXML
    public void Upload(){
        FileChooser fileChooser = new FileChooser();
        // upload image
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                // Read the image file as bytes
                imageBytes = Files.readAllBytes(selectedFile.toPath());
                System.out.println(imageBytes);
                String fileName = selectedFile.getName();
                // Perform further operations with the imageBytes array
                listView.getItems().add(fileName);
                // For example, you can store it in a database or process it in some way

                System.out.println("Image selected: " + selectedFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }
    @FXML
    private Button back;

    @FXML
    public void Back() throws IOException{
         // Get the current scene
         Scene currentScene = back.getScene();
        
         // Modify the size of the window
         Stage currentStage = (Stage) currentScene.getWindow();
         currentStage.setWidth(1200); // Set the width
         currentStage.setHeight(1000); // Set the height
         
         // Switch to the "restocreate" page
         App.setRoot("home");
     
    }   

}


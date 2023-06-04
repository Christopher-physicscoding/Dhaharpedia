package com.dhaharpedia;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import javafx.scene.control.ListView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import java.net.URL;    
import java.util.ResourceBundle;

public class editmenu implements Initializable {
    @FXML
    private ListView<String> listView;
    private byte[] imageBytes;

    @FXML
    private TextField nama;
    @FXML
    private TextField kategori;
    @FXML
    private TextField harga;
    @FXML
    private TextArea deskripsi;
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
    public void initialize(URL location, ResourceBundle resources){
        detailrestorancontroller detailrestorancontroller = new detailrestorancontroller();
        String foodstate = detailrestorancontroller.foodstate;
        Makanan makanan = detailrestorancontroller.makanan;
        System.out.println(foodstate);
        System.out.println(makanan.getName());
        nama.setText(makanan.getName());
        kategori.setText(makanan.getCategory());
        harga.setText(String.valueOf(makanan.getPrice()));
        deskripsi.setText(makanan.getDescription());
    
    }

   
    @FXML
    public void Submit() throws IOException {
        // get data from form
        String nama1 = nama.getText();
        String kategori1 = kategori.getText();
        String harga1 = harga.getText();
        String deskripsi1 = deskripsi.getText();
        String foodstate = detailrestorancontroller.foodstate;

        Makanan makanan = new Makanan(nama1, deskripsi1, Double.parseDouble(harga1), kategori1, imageBytes);
        homecontroller homecontroller = new homecontroller();
        homecontroller.data.getRestaurantByName(homecontroller.state).editMenu(makanan, foodstate);
        
        
        Scene currentScene = back.getScene();
        //Modify the size of the window
        Stage currentStage = (Stage) currentScene.getWindow();
        currentStage.setWidth(900); // Set the width
        currentStage.setHeight(800); // Set the height
        // Switch to the "restocreate" page
        App.setRoot("detailrestoran");

        
    }

    @FXML
    private Button back;

    @FXML
    public void Back() throws IOException{
         // Get the current scene
         Scene currentScene = back.getScene();
        
         // Modify the size of the window
         Stage currentStage = (Stage) currentScene.getWindow();
         currentStage.setWidth(900); // Set the width
         currentStage.setHeight(800); // Set the height
         
         // Switch to the "restocreate" page
         App.setRoot("detailrestoran");
     
    }   
    
    
    
}

package com.dhaharpedia;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import javafx.scene.control.ListView;

public class editmenu {
    @FXML
    private ListView<String> listView;
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
    private TextField nama;
    @FXML
    private TextField kategori;
    @FXML
    private TextField harga;
    @FXML
    private TextArea deskripsi;
    @FXML
    public void Submit(){
        // get data from form
        String nama1 = nama.getText();
        String kategori1 = kategori.getText();
        String harga1 = harga.getText();
        String deskripsi1 = deskripsi.getText();

        Makanan makanan = new Makanan(nama1, deskripsi1, Double.parseDouble(harga1), kategori1, imageBytes);
        // print all
        System.out.println(nama1);
        System.out.println(kategori1);
        System.out.println(harga1);
        System.out.println(deskripsi1);
        System.out.println(imageBytes);

       
    }
    
}

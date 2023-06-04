package com.dhaharpedia;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class detailrestorancontroller implements Initializable {
    @FXML
    private Label labelNama;

    @FXML
    private Label labelAlamat;

    @FXML
    private Label labelKontak;

    @FXML
    private Label labelRating;

    @FXML
    private Label labelKategori;

    @FXML
    private ImageView imageView;

    @FXML
    private Button back;

    @FXML
    private VBox menu;

    private String nama;

    public static String foodstate;

    public static Makanan makanan;



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        homecontroller homecontroller = new homecontroller();

        Restaurant restoran = homecontroller.data.getRestaurantByName(homecontroller.state);
        labelNama.setText("Nama: "+ restoran.getNama());
        labelAlamat.setText("Alamat: "+restoran.getAlamat());
        labelKontak.setText("Kontak: "+ restoran.getNoHp());
        labelRating.setText("Rating: " + Float.toString(restoran.getRating()));
        labelKategori.setText("Kategori: "+restoran.getKategory());
        nama = restoran.getNama();

        // set image if exist
        if (restoran.getGambar() != null) {
            byte[] image = restoran.getGambar();    
            ByteArrayInputStream inputStream = new ByteArrayInputStream(image);
            Image images = new Image(inputStream);
            //set image
            imageView.setImage(images);
            
        }

        //get menu
        ArrayList<Makanan> menu = restoran.getMenu();
        System.out.println("ukuran menu "+ menu.size());
        for (Makanan makanan : menu) {
            // create new label
            Label nama = new Label();
            nama.setText("nama"+ makanan.getName());
            Label harga = new Label();
            harga.setText("harga" + Double.toString(makanan.getPrice()));
            Label deskripsi = new Label();
            deskripsi.setText("deskripsi " +makanan.getDescription());
            Label kategori = new Label();
            kategori.setText("kategori :"+makanan.getCategory());
            //print all
            

            ImageView menuView = new ImageView();
            // create new imageview if exist
            if (makanan.getGambar() != null){
                byte[] imagemakanan = makanan.getGambar();    
                ByteArrayInputStream inputStream = new ByteArrayInputStream(imagemakanan);
                Image imagesmakanan = new Image(inputStream);
                menuView.setImage(imagesmakanan);
            } else {
                menuView.setImage(new Image("https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg"));
            }
            menuView.setFitWidth(200);
            menuView.setFitHeight(150);

          
            // create button new behavior
            Button button = new Button();
            button.setText("Edit");
            Label penopang = new Label();
            penopang.setText(" ");
            button.setOnAction(e -> {
                foodstate = makanan.getName();
                Restaurant restoran1 = homecontroller.data.getRestaurantByName(homecontroller.state);
                this.makanan = restoran1.getMenuByName(foodstate);

                System.out.println(this.makanan.getName());
                //print the state
                System.out.println(foodstate);
                User user = homecontroller.user;
                if (user != null && user.getRole().equals("admin")) {
                    try {
                        Scene currentScene = back.getScene();
        
                        // Modify the size of the window
                        Stage currentStage = (Stage) currentScene.getWindow();
                        currentStage.setWidth(1200); // Set the width
                        currentStage.setHeight(800); // Set the height
                        App.setRoot("editmenu");
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                
            });
            Button button2 = new Button();
            button2.setText("Delete");
            button2.setOnAction(e -> {
                //check if user
                foodstate = makanan.getName();
                User user = homecontroller.user;
                //check if user is admin
                if (user != null && user.getRole().equals("admin")) {
                    //delete the food
                    homecontroller.data.getRestaurantByName(homecontroller.state).removeMenu(foodstate);
                    try {
                        App.setRoot("detailrestoran");
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            });

          

            //create vbox name button bar
            VBox bottonbar = new VBox();
            // move button to vbox
            bottonbar.getChildren().addAll(button, penopang ,button2);

           
            


            //create vbox name menu 
            VBox menuvbox = new VBox();
            // move label to vbox
            menuvbox.getChildren().addAll(nama, harga, deskripsi, kategori);
            

            //create hbox
            HBox hbox = new HBox();
            // move image vbox to hbox
            hbox.getChildren().addAll(menuView, menuvbox, bottonbar);

           
            // move hbox to vbox
            this.menu.getChildren().addAll(hbox);
            System.out.println(makanan.getName());
            System.out.println(makanan.getPrice());
            System.out.println(makanan.getDescription());
            System.out.println(makanan.getCategory());




        

    




            
        }
    }
    @FXML
    private void delete() throws IOException{
        homecontroller homecontroller = new homecontroller();
        User user = homecontroller.user;
        // Get the current scene
        if (user != null && user.getRole().equals("admin")) {
            homecontroller.data.removeRestaurantByName(nama);
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
    @FXML
    private void back() throws IOException {
        // Get the current scene
        Scene currentScene = back.getScene();
        
        // Modify the size of the window
        Stage currentStage = (Stage) currentScene.getWindow();
        currentStage.setWidth(1200); // Set the width
        currentStage.setHeight(1000); // Set the height
        
        // Switch to the "restocreate" page
        App.setRoot("home");
    }
    @FXML
    private void edit() throws IOException {
        homecontroller homecontroller = new homecontroller();
        User user = homecontroller.user;
        // Get the current scene
        if (user != null && user.getRole().equals("admin")) {
            
            Scene currentScene = back.getScene();
            
            // Modify the size of the window
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.setWidth(1200); // Set the width
            currentStage.setHeight(800); // Set the height
            
            // Switch to the "restocreate" page
            App.setRoot("edit");
        }
    }
    @FXML
    private void formMenu() throws IOException{
        homecontroller  homecontroller = new homecontroller();
        User user = homecontroller.user;
        if (user != null && user.getRole().equals("admin")) {
            
            Scene currentScene = back.getScene();
            
            // Modify the size of the window
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.setWidth(1200); // Set the width
            currentStage.setHeight(800); // Set the height
            
            // Switch to the "restocreate" page
            App.setRoot("tambahmenu");
        }
    }
    
}

package com.dhaharpedia;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;

public class homecontroller  implements Initializable  {
    public static Database data = new Database();
    public static  String state;
    @FXML
    private FlowPane flowPane;
    // add global variabel from login controller
    @FXML
    private Button switchToCreateFormButton;
    
    @FXML
    private void switchToCreateForm() throws IOException {
        // Get the current scene
        Scene currentScene = switchToCreateFormButton.getScene();
        
        // Modify the size of the window
        Stage currentStage = (Stage) currentScene.getWindow();
        currentStage.setWidth(1200); // Set the width
        currentStage.setHeight(800); // Set the height
        
        // Switch to the "restocreate" page
        App.setRoot("restocreate");
    }    
 
    @FXML
    private void switchToLogin() throws IOException{
        // Get the current scene
        Scene currentScene = switchToCreateFormButton.getScene();
        
        // Modify the size of the window
        Stage currentStage = (Stage) currentScene.getWindow();
        currentStage.setWidth(600); // Set the width
        currentStage.setHeight(500); // Set the height
        
        // Switch to the "login" page
        App.setRoot("login");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Event logic to be executed on load
        // add flowpane child
        data.getListRestaurant();
        //print data
        System.out.println(data.toString());
        //looping data
        for (int i = 0; i < data.getListRestaurant().size(); i++) {
            //get data
            String nama = data.getListRestaurant().get(i).getNama();
            String alamat = data.getListRestaurant().get(i).getAlamat();
            String kontak = data.getListRestaurant().get(i).getNoHp();
            Float rating = data.getListRestaurant().get(i).getRating();
            int jumlahorang = data.getListRestaurant().get(i).getJumlahorang();
            String kategori = data.getListRestaurant().get(i).getKategory();
            byte[] image = data.getListRestaurant().get(i).getGambar();
            System.out.println(nama + " " + alamat + " " + kontak + " " + rating + " " + jumlahorang + " " + kategori);
            
            
            Button button = new Button();
            VBox vbox = new VBox();
            //set size vbox pre width 200 preheight 100
            vbox.setPrefSize(200, 100);

            //create image
            ImageView imageView = new ImageView();
            //set image if image exist
            if(image != null){
                imageView.setImage(new Image("data:image/png;base64," + java.util.Base64.getEncoder().encodeToString(image)));
            } else {
                //if else add null image
                imageView.setImage(new Image("https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg"));
            }


            Label label = new Label();
            label.setText(nama);
            // add bold
            label.setStyle("-fx-font-weight: bold;");
            Label rate = new Label();
            rate.setText("Rating:" + rating.toString());
            Label Category = new Label();
            Category.setText(kategori);
            //aligment center
            label.setStyle("-fx-alignment: center;");
            rate.setStyle("-fx-alignment: center;");
            Category.setStyle("-fx-alignment: center;");
            //content display center
            label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
            rate.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
            Category.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);

            //set prewidth 16 and preheight 205
            imageView.setFitWidth(16);
            imageView.setFitHeight(150);
            //set prewidth 200 and preheight 100
            label.setPrefSize(200, 16);
            rate.setPrefSize(200, 16);
            Category.setPrefSize(200, 16);


            // add all in vbox 
            vbox.getChildren().add(imageView);
            vbox.getChildren().add(label);
            vbox.getChildren().add(rate);
            vbox.getChildren().add(Category);
            // add vbox in button
            button.setGraphic(vbox);


            //button.setText(nama);
            //set size
            button.setPrefSize(200, 200);
            flowPane.getChildren();
            //add child
            //flowPane.getChildren().add(imageView);
            flowPane.getChildren().add(button);
            //add event
            // button.setOnAction(e -> {
            //     // Get the current scene
            //     Scene currentScene = button.getScene();
                
            //     // Modify the size of the window
            //     Stage currentStage = (Stage) currentScene.getWindow();
            //     currentStage.setWidth(900); // Set the width
            //     currentStage.setHeight(800); // Set the height
                
            //     // Switch to the "restocreate" page
            //     try {
            //         App.setRoot("restodetail");
            //     } catch (IOException e1) {
            //         // TODO Auto-generated catch block
            //         e1.printStackTrace();
            //     }
            // });
        }
    }

    @FXML
    public void ratesorting() throws IOException{
        // clear all flowpane child
        flowPane.getChildren().clear();
        data.sortRestaurant();
        // get sorting data from data
        for (int i = 0; i < data.getListRestaurant().size(); i++) {
            //get data
            String nama = data.getListRestaurant().get(i).getNama();
            String alamat = data.getListRestaurant().get(i).getAlamat();
            String kontak = data.getListRestaurant().get(i).getNoHp();
            Float rating = data.getListRestaurant().get(i).getRating();
            int jumlahorang = data.getListRestaurant().get(i).getJumlahorang();
            String kategori = data.getListRestaurant().get(i).getKategory();
            byte[] image = data.getListRestaurant().get(i).getGambar();
            System.out.println(nama + " " + alamat + " " + kontak + " " + rating + " " + jumlahorang + " " + kategori);
            
            
            Button button = new Button();
            VBox vbox = new VBox();
            //set size vbox pre width 200 preheight 100
            vbox.setPrefSize(200, 100);

            //create image
            ImageView imageView = new ImageView();
            //set image if image exist
            if(image != null){
                imageView.setImage(new Image("data:image/png;base64," + java.util.Base64.getEncoder().encodeToString(image)));
            } else {
                //if else add null image
                imageView.setImage(new Image("https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg"));
            }


            Label label = new Label();
            label.setText(nama);
            // add bold
            label.setStyle("-fx-font-weight: bold;");
            Label rate = new Label();
            rate.setText("Rating:" + rating.toString());
            Label Category = new Label();
            Category.setText(kategori);
            //aligment center
            label.setStyle("-fx-alignment: center;");
            rate.setStyle("-fx-alignment: center;");
            Category.setStyle("-fx-alignment: center;");
            //content display center
            label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
            rate.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
            Category.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);

            //set prewidth 16 and preheight 205
            imageView.setFitWidth(16);
            imageView.setFitHeight(150);
            //set prewidth 200 and preheight 100
            label.setPrefSize(200, 16);
            rate.setPrefSize(200, 16);
            Category.setPrefSize(200, 16);


            // add all in vbox 
            vbox.getChildren().add(imageView);
            vbox.getChildren().add(label);
            vbox.getChildren().add(rate);
            vbox.getChildren().add(Category);
            // add vbox in button
            button.setGraphic(vbox);


            //button.setText(nama);
            //set size
            button.setPrefSize(200, 200);
            flowPane.getChildren();
            //add child
            //flowPane.getChildren().add(imageView);
            flowPane.getChildren().add(button);
            //add event
            // button.setOnAction(e -> {
            //     // Get the current scene
            //     Scene currentScene = button.getScene();
                
            //     // Modify the size of the window
            //     Stage currentStage = (Stage) currentScene.getWindow();
            //     currentStage.setWidth(900); // Set the width
            //     currentStage.setHeight(800); // Set the height
                
            //     // Switch to the "restocreate" page
            //     try {
            //         App.setRoot("restodetail");
            //     } catch (IOException e1) {
            //         // TODO Auto-generated catch block
            //         e1.printStackTrace();
            //     }
            // });

        }
    }
    @FXML
    private TextField kategori;

    @FXML
    public void categorysorting() throws IOException{
        // clear all flowpane child
        flowPane.getChildren().clear();
        System.out.println(kategori.getText());
        

    }   
}

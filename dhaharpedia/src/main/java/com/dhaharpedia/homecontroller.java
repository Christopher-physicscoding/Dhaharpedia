package com.dhaharpedia;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
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
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class homecontroller  implements Initializable  {
    public static Database data = new Database();
    public static String state;
    public static User user;
    @FXML
    private FlowPane flowPane;
    // add global variabel from login controller
    @FXML
    private Button switchToCreateFormButton;
    
    @FXML
    private void switchToCreateForm() throws IOException {
        if (user != null && user.getRole().equals("admin")) {
        // Get the current scene
            Scene currentScene = switchToCreateFormButton.getScene();
            
            // Modify the size of the window
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.setWidth(1200); // Set the width
            currentStage.setHeight(800); // Set the height
            
            // Switch to the "restocreate" page
            App.setRoot("restocreate");} else {
                displayLogin();
            }
    }    
 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Event logic to be executed on load
        // add flowpane child
        data.getListRestaurant();
        //print data
        System.out.println(data.toString());
        //looping data
        ArrayList<Restaurant> listRestaurant = data.getListRestaurant();
        for (int i = 0; i < listRestaurant.size(); i++) {
            Restaurant restaurant = listRestaurant.get(i);
            String nama = restaurant.getNama();
            Float rating = restaurant.getRating();
            String kategori = restaurant.getKategory();
            byte[] image = restaurant.getGambar();
            
            Button button = new Button();
            VBox vbox = new VBox();
            //set size vbox pre width 200 preheight 100
            vbox.setPrefSize(200, 100);

            //create image
            ImageView imageView = new ImageView();
            //set image if image exist
            if(image != null){
               ByteArrayInputStream inputStream = new ByteArrayInputStream(image);
               Image images = new Image(inputStream);
               imageView.setImage(images);
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
            imageView.setFitWidth(200);
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
            
            //add event
            button.setOnAction(e -> {
                // Get the current scene
                System.out.print(nama);
                this.state = nama;
                System.out.println("hello world "+ nama);
                Scene currentScene = button.getScene();
                
                // Modify the size of the window
                Stage currentStage = (Stage) currentScene.getWindow();
                currentStage.setWidth(900); // Set the width
                currentStage.setHeight(800); // Set the height
                
                //Switch to the "restocreate" page
                try {
                     App.setRoot("detailrestoran");
                } catch (IOException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                 }
            });

            flowPane.getChildren().add(button);
        }
    }

    @FXML
    public void ratesorting() throws IOException{
        // clear all flowpane child
        flowPane.getChildren().clear();
        data.sortRestaurant();
        // get sorting data from data
        ArrayList<Restaurant> listRestaurant = data.getListRestaurant();
        // if size not 10 pop


        for (int i = 0; i < 10; i++) {
            Restaurant restaurant = listRestaurant.get((listRestaurant.size() - (listRestaurant.size() - 10))- i-1);
            String nama = restaurant.getNama();
            Float rating = restaurant.getRating();
            String kategori = restaurant.getKategory();
            byte[] image = restaurant.getGambar();
                
            Button button = new Button();
            VBox vbox = new VBox();
            //set size vbox pre width 200 preheight 100
            vbox.setPrefSize(200, 100);

            //create image
            ImageView imageView = new ImageView();
            //set image if image exist
            if(image != null){
                ByteArrayInputStream inputStream = new ByteArrayInputStream(image);
                Image images = new Image(inputStream);
                imageView.setImage(images);
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
            imageView.setFitWidth(200);
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
           
            //add event
            button.setOnAction(e -> {
                //Get the current scene
                System.out.print(nama);
                Scene currentScene = button.getScene();
                this.state = nama;
                // Modify the size of the window
                Stage currentStage = (Stage) currentScene.getWindow();
                currentStage.setWidth(900); // Set the width
                currentStage.setHeight(800); // Set the height
                
                // Switch to the "restocreate" page
                try {
                    App.setRoot("detailrestoran");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });

            flowPane.getChildren().add(button);

        }
    }
    @FXML
    private TextField kategori;

    @FXML
    public void categorysorting() throws IOException{
        // clear all flowpane child
        flowPane.getChildren().clear();
        System.out.println(kategori.getText());
        String namecategory = kategori.getText();
        ArrayList<Restaurant> categorysorting = data.getRestaurantByCategory(namecategory);

        for (int i = 0; i < categorysorting.size(); i++) {
            //get data
            String nama = categorysorting.get(i).getNama();
            Float rating = categorysorting.get(i).getRating();
            String kategori = categorysorting.get(i).getKategory();
            byte[] image = categorysorting.get(i).getGambar();
           
            
            Button button = new Button();
            VBox vbox = new VBox();
            //set size vbox pre width 200 preheight 100
            vbox.setPrefSize(200, 100);

            //create image
            ImageView imageView = new ImageView();
            //set image if image exist
            if(image != null){
                ByteArrayInputStream inputStream = new ByteArrayInputStream(image);
                Image images = new Image(inputStream);
                imageView.setImage(images);
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
            imageView.setFitWidth(200);
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
           
            //add event
            button.setOnAction(e -> {
                //Get the current scene
                System.out.print(nama);
                Scene currentScene = button.getScene();
                this.state = nama;
                // Modify the size of the window
                Stage currentStage = (Stage) currentScene.getWindow();
                currentStage.setWidth(900); // Set the width
                currentStage.setHeight(800); // Set the height
                
                // Switch to the "restocreate" page
                try {
                    App.setRoot("detailrestoran");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });

            flowPane.getChildren().add(button);

        }
    }   
    @FXML
    public void search() throws IOException{
        // clear all flowpane child
        flowPane.getChildren().clear();
        System.out.println(kategori.getText());
        String nameSearch = kategori.getText();
        Restaurant Search = data.getRestaurantByName(nameSearch);
        // get atributes
        String nama = Search.getNama();
        Float rating = Search.getRating();
        String kategori = Search.getKategory();
        byte[] image = Search.getGambar();

        Button button = new Button();
        VBox vbox = new VBox();
        //set size vbox pre width 200 preheight 100
        vbox.setPrefSize(200, 100);

        //create image
        ImageView imageView = new ImageView();
        //set image if image exist
        if(image != null){
            ByteArrayInputStream inputStream = new ByteArrayInputStream(image);
            Image images = new Image(inputStream);
            imageView.setImage(images);
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
        imageView.setFitWidth(200);
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
       
        //add event
        button.setOnAction(e -> {
            //Get the current scene
            System.out.print(nama);
            Scene currentScene = button.getScene();
            this.state = nama;
            // Modify the size of the window
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.setWidth(900); // Set the width
            currentStage.setHeight(800); // Set the height
            
            // Switch to the "restocreate" page
            try {
                App.setRoot("detailrestoran");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        flowPane.getChildren().add(button);

    }



    @FXML
    public void displayLogin () {
        // if user not null and user role = admin

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(homecontroller.class.getResource("login.fxml"));
        try {
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root, 700, 500);
            stage.setScene(scene);
            ((Button) root.lookup("#back")).setOnAction(e -> {
                stage.close();
            });
            ((Button) root.lookup("#check")).setOnAction(e -> {
                String username = ((TextField) root.lookup("#usernameField")).getText();
                System.out.println(username);
                //getpassfield
                String password = ((TextField) root.lookup("#passwordField")).getText();
                System.out.println(password);

                User user1 = this.data.getUser(username);
                if (user1 != null) {
                    if (user1.getPassword().equals(password)) {
                            this.user = user1;
                            stage.close();
                        } 
                }
            });
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



}

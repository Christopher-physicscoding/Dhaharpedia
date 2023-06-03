package com.dhaharpedia;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ratingcontroller {
    
    @FXML
    private TextField rating;
    @FXML
    private TextArea review;

    @FXML
    //submit rating
    public void Submit(){
        // get data from form
        String rating1 = rating.getText();
        String review1 = review.getText();

        // print all
        System.out.println(rating1);
        System.out.println(review1);
    }
}

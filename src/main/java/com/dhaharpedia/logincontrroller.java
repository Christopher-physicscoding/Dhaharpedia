package com.dhaharpedia;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;

public class logincontrroller {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button signInButton;
    @FXML
    private void check() throws IOException{
        String username = usernameField.getText();
        System.out.println(username);
        //password check
        String password = passwordField.getText();
        System.out.println(password);
        // call get user from database
        Database user = new Database();
        User user1 = user.getUser(username);

        if (user1 != null) {
            if (user1.getPassword().equals(password)) {
                if (user1.getRole().equals("admin")) {
                    System.out.println("admin");
                } else {
                    App.setRoot("secondary");
                }
            }
        }

    }

}


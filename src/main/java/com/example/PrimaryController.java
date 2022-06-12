package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label error;

    @FXML
    public void Login() {
        if (username.getText().equals("admin") && password.getText().equals("admin")) {
            try {
                App.setRoot("Secondary");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            error.setText("Invalid username or password");
        }
    }

}

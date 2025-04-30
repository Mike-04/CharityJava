package com;

import com.Service;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    private Service service;


    @FXML
    TextField loginUsername;
    @FXML
    PasswordField loginPassword;
    @FXML
    Button loginButton;
    @FXML
    Button registerButton;
    @FXML
    TextField registerUsername;
    @FXML
    PasswordField registerPassword;
    @FXML
    PasswordField registerPasswordConfirm;
    @FXML
    Label warningLabel;


    public LoginController() {}

    public void setService(Service service) {
        this.service = service;
    }

    public void logIn() throws IOException {
        String username = loginUsername.getText();
        String password = loginPassword.getText();
        if(service.checkUser(username, password)){
            warningLabel.setText("Login successful");
            // open new loggedIn window
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/loggedIn.fxml"));
            // create a new stage
            Stage stage = new Stage();
            // set the scene
            Scene scene = new Scene(loader.load());
            LoggedInController controller = loader.getController();
            controller.setStuff(service, service.findByUsername(username));
            stage.setTitle("Logged in as: " + username);
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);

        } else {
            warningLabel.setText("Login failed");
        }

    }

    public void register(){
        String username = registerUsername.getText();
        String password = registerPassword.getText();
        String passwordConfirm = registerPasswordConfirm.getText();
        if(password.equals(passwordConfirm)){
            service.addUser(username, password);
            warningLabel.setText("User registered");
        } else {
            warningLabel.setText("Passwords do not match");
        }
    }

    public void checkUsername(){
        // print debug message
        System.out.println("Checking username");
        String username = registerUsername.getText();
        if(service.findByUsername(username) != null){
            warningLabel.setText("Username already taken");
        } else {
            warningLabel.setText("Username available");
        }
    }



}

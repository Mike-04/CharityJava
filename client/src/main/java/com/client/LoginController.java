package com.client;


import com.domain.User;
import com.service.IAppService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class LoginController {

    private IAppService service;


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

    public void setService(IAppService service) {
        this.service = service;
    }

    public void logIn() throws IOException {

//            // open new loggedIn window
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/loggedIn.fxml"));
//            // create a new stage
//            Stage stage = new Stage();
//            // set the scene
//            Scene scene = new Scene(loader.load());
//            LoggedInController controller = loader.getController();
//            controller.setStuff(service, service.findByUsername(username));
//            stage.setTitle("Logged in as: " + username);
//            stage.setScene(scene);
//            stage.show();
//            stage.setResizable(false);


        try {
            String username = loginUsername.getText();
            String password = hashPassword(username, loginPassword.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/loggedIn.fxml"));

            // create a new stage
            Stage stage = new Stage();
            // set the scene
            Scene scene = new Scene(loader.load());
            LoggedInController controller = loader.getController();

            User user = service.login(username, password, controller);
            controller.setStuff(service, user);
            warningLabel.setText("Login successful");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            // close the current window
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            currentStage.close();

        } catch (Exception ex) {
        warningLabel.setText(ex.getMessage());
        }

    }

    public void register(){
    }

    public void checkUsername(){
    }

    public static String hashPassword(String username, String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String saltedPassword = username + password; // Use username as salt
            byte[] hash = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }


}

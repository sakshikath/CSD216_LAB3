package src.controller;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginPage {
    public Scene getScene(Stage stage) {
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Label title = new Label("HR Management - Login");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            stage.setScene(new DashboardPage().getScene(stage, emailField.getText()));
        });

        layout.getChildren().addAll(title, emailField, passwordField, loginButton);
        return new Scene(layout, 400, 300);
    }
}

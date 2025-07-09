package src.controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class DashboardPage {
    public Scene getScene(Stage stage, String username) {
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Label welcome = new Label("Welcome, " + username);
        Label dateLabel = new Label("Date: " + LocalDate.now());

        Button adminBtn = new Button("Admin");
        Button employeeBtn = new Button("Employee");
        Button logoutBtn = new Button("Logout");
        Button exitBtn = new Button("Exit");

        adminBtn.setOnAction(e -> stage.setScene(new AdminPage().getScene(stage)));
        employeeBtn.setOnAction(e -> stage.setScene(new EmployeePage().getScene(stage)));
        logoutBtn.setOnAction(e -> stage.setScene(new LoginPage().getScene(stage)));
        exitBtn.setOnAction(e -> stage.close());

        layout.getChildren().addAll(welcome, dateLabel, adminBtn, employeeBtn, logoutBtn, exitBtn);
        return new Scene(layout, 400, 400);
    }
}

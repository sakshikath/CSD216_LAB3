package src.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmployeePage {
    public Scene getScene(Stage stage) {
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        TableView<String> table = new TableView<>();
        TableColumn<String, String> column = new TableColumn<>("Employee Info");
        table.getColumns().add(column);

        ObservableList<String> data = FXCollections.observableArrayList("Emp1", "Emp2");
        table.setItems(data);

        Button createBtn = new Button("Create");
        Button updateBtn = new Button("Update");
        Button deleteBtn = new Button("Delete");
        Button viewBtn = new Button("View");
        Button backBtn = new Button("Back");

        backBtn.setOnAction(e -> stage.setScene(new DashboardPage().getScene(stage, "Employee")));

        layout.getChildren().addAll(new Label("Employee Panel"), table, createBtn, updateBtn, deleteBtn, viewBtn, backBtn);
        return new Scene(layout, 500, 400);
    }
}


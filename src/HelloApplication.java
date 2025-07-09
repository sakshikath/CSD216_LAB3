package src;

import javafx.application.Application;
import javafx.stage.Stage;
import src.controller.LoginPage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        LoginPage loginPage = new LoginPage();
        stage.setScene(loginPage.getScene(stage));
        stage.setTitle("HR Management - Sakshi");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

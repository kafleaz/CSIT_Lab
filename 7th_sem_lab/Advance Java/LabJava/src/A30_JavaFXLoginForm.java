// Task 30: Create a simple login form using JavaFX.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class A30_JavaFXLoginForm extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create labels and text fields for username and password
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        // Create a login button
        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        // Set the button action
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Simple validation
            if (username.equals("admin") && password.equals("password")) {
                messageLabel.setText("Login successful!");
            } else {
                messageLabel.setText("Invalid credentials. Try again.");
            }
        });

        // Create a GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add components to the grid
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 1, 2);
        gridPane.add(messageLabel, 1, 3);

        // Set up the scene and stage
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setTitle("JavaFX Login Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

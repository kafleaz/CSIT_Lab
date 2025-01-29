// Task 33: Create a form with Label, TextField, Button, and CheckBox.
// Display the entered data on a button click.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class A33_JavaFXForm extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Horizontal gap
        gridPane.setVgap(10); // Vertical gap
        gridPane.setStyle("-fx-padding: 10;"); // Add padding around the grid

        // Create form components
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        CheckBox termsCheckBox = new CheckBox("I agree to the terms and conditions");

        Button submitButton = new Button("Submit");
        Label outputLabel = new Label();

        // Add components to the grid
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(emailLabel, 0, 1);
        gridPane.add(emailField, 1, 1);
        gridPane.add(termsCheckBox, 1, 2);
        gridPane.add(submitButton, 1, 3);
        gridPane.add(outputLabel, 1, 4);

        // Set button action
        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String email = emailField.getText();
            boolean termsAccepted = termsCheckBox.isSelected();

            if (name.isEmpty() || email.isEmpty()) {
                outputLabel.setText("Please fill out all fields.");
            } else if (!termsAccepted) {
                outputLabel.setText("You must agree to the terms and conditions.");
            } else {
                outputLabel.setText("Name: " + name + "\nEmail: " + email);
            }
        });

        // Set up the scene and stage
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Form Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Define the URL mapping for the servlet
    @WebServlet("/hello")
    public static class A34_HelloWorldServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            // Set the content type
            response.setContentType("text/html");

            // Write the response
            response.getWriter().println("<h1>Hello, World!</h1>");
        }
    }
}

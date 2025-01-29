// Task 32: Design a calculator interface using a GridPane layout.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class A32_JavaFXCalculator extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Horizontal gap between components
        gridPane.setVgap(10); // Vertical gap between components
        gridPane.setStyle("-fx-padding: 10;"); // Add padding around the grid

        // Create a TextField for the display
        TextField display = new TextField();
        display.setEditable(false); // Make it read-only
        display.setPrefHeight(50); // Set height for the display
        gridPane.add(display, 0, 0, 4, 1); // Span across 4 columns

        // Create calculator buttons
        Button[] buttons = new Button[16];
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        // Add buttons to the GridPane
        int index = 0;
        for (int row = 1; row <= 4; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[index] = new Button(buttonLabels[index]);
                buttons[index].setPrefSize(50, 50); // Set button size
                gridPane.add(buttons[index], col, row);
                index++;
            }
        }

        // Add button functionality (example for "C" to clear display)
        for (Button button : buttons) {
            button.setOnAction(event -> {
                String buttonText = button.getText();
                if (buttonText.equals("C")) {
                    display.clear();
                } else if (buttonText.equals("=")) {
                    try {
                        // Evaluate the expression in the display
                        String result = evaluateExpression(display.getText());
                        display.setText(result);
                    } catch (Exception e) {
                        display.setText("Error");
                    }
                } else {
                    display.appendText(buttonText);
                }
            });
        }

        // Set up the scene and stage
        Scene scene = new Scene(gridPane, 250, 300);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to evaluate simple mathematical expressions
    // Method to evaluate simple mathematical expressions
    private String evaluateExpression(String expression) {
        try {
            // Use Java's built-in ScriptEngine to evaluate the expression
            return String.valueOf(new javax.script.ScriptEngineManager()
                    .getEngineByName("JavaScript").eval(expression));
        } catch (javax.script.ScriptException e) {
            // Handle exception and return an error message
            return "Error";
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

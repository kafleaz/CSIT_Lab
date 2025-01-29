// Task 31: Design a GUI with a FlowPane to arrange buttons and a BorderPane to place
// a menu bar at the top and buttons at the center.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class A31_JavaFXFlowAndBorderPane extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a BorderPane
        BorderPane borderPane = new BorderPane();

        // Create a MenuBar and menus
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(openItem, saveItem, new SeparatorMenuItem(), exitItem);

        Menu editMenu = new Menu("Edit");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        editMenu.getItems().addAll(copyItem, pasteItem);

        menuBar.getMenus().addAll(fileMenu, editMenu);

        // Add the MenuBar to the top of the BorderPane
        borderPane.setTop(menuBar);

        // Create a FlowPane to arrange buttons
        FlowPane flowPane = new FlowPane(10, 10); // Horizontal and vertical gaps
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");

        flowPane.getChildren().addAll(button1, button2, button3, button4);

        // Add the FlowPane to the center of the BorderPane
        borderPane.setCenter(flowPane);

        // Set up the scene and stage
        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setTitle("FlowPane and BorderPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

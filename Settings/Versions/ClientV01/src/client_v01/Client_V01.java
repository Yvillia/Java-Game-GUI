
package client_v01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Client_V01 extends Application {
    
    private static Stage currentStage = new Stage();
    private static final TextArea TEXTAREA = new TextArea();
    private GridPane pane = new GridPane();

    @Override
    public void start(Stage primaryStage) {
        
        primaryStage = currentStage;
        TEXTAREA.setPrefWidth(600);
        TEXTAREA.setPrefHeight(400);
        pane.getChildren().add(TEXTAREA);
        Scene currentScene = new Scene(pane, 600, 400);
        
        currentStage.setTitle("Main Text Area");
        currentStage.setScene(currentScene);
        currentStage.show();
        eventListenerKeyEvents();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private void eventListenerKeyEvents()
    {
        TEXTAREA.setOnKeyPressed(e -> {
            
            switch(e.getCode())
            {
                case ESCAPE:
                            Settings settings = new Settings(currentStage);
                            break;
            }
            
        });
    }
    
}

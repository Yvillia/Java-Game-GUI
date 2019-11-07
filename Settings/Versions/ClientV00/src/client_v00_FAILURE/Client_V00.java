//Created By: Daniel Johnston & Noah Rogers
//Date of Starting: 26 April 2019
//Date of Completion: 
//Project Name: MUD Client
//Purpose: This client is made to talk to our server which handles all talking with
//out data base.

package client_v00_FAILURE;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Client_V00 extends Application {
    
    private static final TextArea textArea = new TextArea();
    private static final Stage currentStage = new Stage();
    
    
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.getChildren().add(textArea);
        Scene scene = new Scene(pane);
        primaryStage = currentStage;
        currentStage.setScene(scene);
        currentStage.setTitle("Text Area");
        currentStage.show();
        
        eventHandlerKeyEventListenersLoginScreen();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private static void eventHandlerKeyEventListenersLoginScreen()
    {
        textArea.setOnKeyPressed((new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e)  
                {
                    switch(e.getCode()) 
                    {
                        case ESCAPE: Settings settingsStage = new Settings();
                    }    
                }
        }));
    }
}

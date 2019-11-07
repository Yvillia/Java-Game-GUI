package client_v00_FAILURE;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import java.util.HashMap;
import java.util.Map;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

class Settings{
    
    // Initialization of Settings Scene Contents
    final GridPane SETTINGSGRID =  new GridPane();
    final VBox APPEARANCE = new VBox();
    final VBox ABOUT = new VBox();
    
    // Initialization of Settings Scene Properties
    private static final double SETTINGSWIDTH = 400;
    private static final double SETTINGSHEIGHT = 180;
    
    //Initialization of Settings Pane Contents
    private static final TextArea textArea = new TextArea();
    
    //Initialization of Back Arrow Map
    static final Map STAGEMAP = new HashMap();
    
    //Initialization of Settings Stage
    static final Stage SETTINGS = new Stage();
    
    //Initialization of Settings Pane Buttons
    static final SettingsButton appearanceButton = new SettingsButton("Appearance", SETTINGS.getScene());
    static final SettingsButton aboutButton = new SettingsButton("About", SETTINGS.getScene());
    static final SettingsButton RESOLUTION = new SettingsButton("Resolution", SETTINGS.getScene());
    static final SettingsButton CLIENTTHEME = new SettingsButton("Theme", SETTINGS.getScene());
    static final BackButton ABOUTBACKBUTTON = new BackButton(SETTINGS.getScene());
    static final BackButton APPEARANCEBACKBUTTON = new BackButton(SETTINGS.getScene());
    
    //Initialization of Settings Scene
     final Scene settingsScene = new Scene(SETTINGSGRID, SETTINGSWIDTH, SETTINGSHEIGHT);
    
    //Builds a Settings Stage Instance
    Settings(){
        
        //STAGEMAP Initialization
        STAGEMAP.put("Settings", 0);
        STAGEMAP.put("Appearance", 1);
        STAGEMAP.put("About", 2);
        STAGEMAP.put("Resolution", 3);
        STAGEMAP.put("Theme", 4);
        STAGEMAP.put("Back", 5);
       
        //Adds Buttons to VBoxes
        APPEARANCE.getChildren().add(appearanceButton.SETTINGSBUTTON);
        ABOUT.getChildren().add(aboutButton.SETTINGSBUTTON);
        
        //Adds VBoxes to Grid
        SETTINGSGRID.addRow(0, APPEARANCE);
        SETTINGSGRID.addRow(1, ABOUT);
        
        //Change VBox Style
        APPEARANCE.setPadding(new Insets(10, 10, 10, 10));
        ABOUT.setPadding(new Insets(10, 10, 10, 10));
        
        //Change Grid Style
        SETTINGSGRID.setAlignment(Pos.CENTER);
        
        //Builds Settings Stage
        SETTINGS.setScene(settingsScene);
        SETTINGS.setMinWidth(SETTINGSWIDTH);
        SETTINGS.setMinHeight(SETTINGSHEIGHT);
        SETTINGS.setResizable(false);
        SETTINGS.setTitle("Settings");
        SETTINGS.show();
        
    }
    
}

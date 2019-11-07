package client_v00_FAILURE;

import javafx.stage.Stage;
import java.util.Map;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

class SettingsButton{
    
    //Button Stylings
    private static final int MAXWIDTH = 250;
    private static final String STYLE = "-fx-padding: 10 10 10 10;";
    
    //Initialization of Main Buttons in Settings
    final Button SETTINGSBUTTON = new Button();
    
    //Initialization of Pane Width and Height
    private static final double SETTINGSHEIGHT = 300;
    private static final double SETTINGSWIDTH = 300;
    
    
    
    //Builds a SettingsButton Instance
    SettingsButton(String Name, Scene scene)
    {
        SETTINGSBUTTON.setText(Name);
        SETTINGSBUTTON.setMaxWidth(MAXWIDTH);
        SETTINGSBUTTON.setFont(Font.font(null, FontWeight.MEDIUM, 15));
        SETTINGSBUTTON.setStyle(STYLE);    
        eventHandlerKeyEventButtonClick(SETTINGSBUTTON, Settings.STAGEMAP, Settings.SETTINGS, scene);
    }
    
    static Scene appearance(SettingsButton RESOLUTION, SettingsButton CLIENTTHEME){
        //Initializes Visual Elements
        final GridPane APPEARANCEGRID =  new GridPane();
        final VBox APPEARANCEPANE = new VBox();
        final GridPane BACKBUTTONPANE = new GridPane();
        
        //BackButton Container Build
        BACKBUTTONPANE.addRow(0, Settings.APPEARANCEBACKBUTTON.BACKBUTTON);
        BACKBUTTONPANE.setAlignment(Pos.TOP_LEFT);
        BACKBUTTONPANE.setPadding(new Insets(10, 10, 10, 10));
        
        //Appearance Grid Build
        APPEARANCEGRID.addRow(0, RESOLUTION.SETTINGSBUTTON);
        APPEARANCEGRID.addRow(1, CLIENTTHEME.SETTINGSBUTTON);
        
        //Appearance Grid Adjustment
        APPEARANCEGRID.setAlignment(Pos.CENTER);
        APPEARANCEGRID.setVgap(10);
        
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!FIGURE OUT HOW TO MAKE THIS BETTER THAN JUST MANUAL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//
        APPEARANCEGRID.setPadding(new Insets(50, 0, 0, 0));
        
        //Appearance Pane Additions
        APPEARANCEPANE.getChildren().add(BACKBUTTONPANE);
        APPEARANCEPANE.getChildren().add(APPEARANCEGRID);
        
        //Scene Build and Return
        return new Scene(APPEARANCEPANE, SETTINGSWIDTH, SETTINGSHEIGHT);
        
    }
    
    static Scene about(){
        //Initialization of Visual Items
        final GridPane ABOUTGRID =  new GridPane();
        final StackPane ABOUTPANE = new StackPane();
        final TextArea ABOUTTEXT = new TextArea();
        
        //Initialization of About Text
        ABOUTTEXT.setText("THIS IS OUR ABOUT PAGE WITH ALL INFORMATION ABOUT US AND THE COMPANY BALALALLALALALALALLA");
        ABOUTTEXT.setWrapText(true);
        ABOUTTEXT.setEditable(false);
        ABOUTTEXT.setStyle("-fx-focus-color: transparent; -fx-padding: 20; -fx-background-color: rgba(0, 0, 0, 0.0); -fx-highlight-fill: #ffffff; -fx-highlight-text-fill: #000000;");
        
        //Grid and Pane Adjustment
        ABOUTGRID.addRow(0, Settings.ABOUTBACKBUTTON.BACKBUTTON);
        ABOUTGRID.setPadding(new Insets(10, 10, 10, 10));
        ABOUTGRID.addRow(1, ABOUTTEXT);
        ABOUTPANE.getChildren().add(ABOUTGRID);
        
        //Builds and Returns Scene
        return new Scene(ABOUTPANE, SETTINGSWIDTH, SETTINGSHEIGHT);
        
    }
    
     //Builds an Event Listener for Button Clicks
    static void eventHandlerKeyEventButtonClick(Button button, Map STAGEMAP, Stage SETTINGS, Scene settingsScene)
    {
        button.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) 
            { 
                if(STAGEMAP.containsKey(button.getText()))
                //Switch to Decide What Button Function is Enacted
                switch((int)STAGEMAP.get(button.getText()))
                {
                    //If the Appearance Button is Pressed
                    case 1:
                            SETTINGS.setScene(appearance(Settings.RESOLUTION, Settings.CLIENTTHEME));
                            SETTINGS.setTitle("Appearance");
                            break;
                    //If the About Button is Pressed
                    case 2: 
                            SETTINGS.setScene(SettingsButton.about());
                            SETTINGS.setTitle("About");
                            break;
                    //If the Back Button is Pressed
                    case 5: 
                            BackButton.eventHandlerKeyEventBackArrow(settingsScene);
                            break;
                }      
            }
        }));
    }    
}
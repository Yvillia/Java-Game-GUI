
package client_v00_FAILURE;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;

class BackButton{
        
      //Initialization of the BackButton
      final Button BACKBUTTON = new Button();
      static int counter = 1;
      int buttonID;
        
      //Builds a BackButton Instance
      BackButton(Scene scene)
      {  
        //Identifies Separate BackButtons(MIGHT DELETE LATER)!!!!!!!!
        this.buttonID = counter;
        counter++;
        
        //Initialization of Back Button Properties
        BACKBUTTON.setText("Back");
        BACKBUTTON.setMaxWidth(100);
        BACKBUTTON.setFont(Font.font(null, FontWeight.MEDIUM, 15));
        BACKBUTTON.setStyle("-fx-padding: 0 10 0 10");
        SettingsButton.eventHandlerKeyEventButtonClick(BACKBUTTON, Settings.STAGEMAP, Settings.SETTINGS, scene);
      }   
      
      //Handles the BackButton's Actions Depending on the StageTitle
    static void eventHandlerKeyEventBackArrow(Scene settingsScene)
    {
        
        //Ensure Map Actually Has the Key First
        if(Settings.STAGEMAP.containsKey(Settings.SETTINGS.getTitle()))
        {
            //If Map Has Key, Check Which Number Matches the Key
            switch((int)Settings.STAGEMAP.get(Settings.SETTINGS.getTitle()))
            {
                //Returns to the Settings Scene From the Appearance Scene
                case 1: 
                    Settings.SETTINGS.setScene(settingsScene);
                    Settings.SETTINGS.setTitle("Settings");
                break;
                
                //Returns to the Settings Scene From the About Scene
                case 2: 
                    Settings.SETTINGS.setScene(settingsScene);
                    Settings.SETTINGS.setTitle("Settings");
                break;
                
                //Returns to the Appearance Scene From the Resolution Scene
                case 3: 
                    Settings.SETTINGS.setScene(SettingsButton.appearance(Settings.RESOLUTION, Settings.CLIENTTHEME));
                    Settings.SETTINGS.setTitle("Appearance");
                break;
                
                //Returns to the Appearance Scene From the Theme Scene
                case 4: 
                    Settings.SETTINGS.setScene(SettingsButton.appearance(Settings.RESOLUTION, Settings.CLIENTTHEME));
                    Settings.SETTINGS.setTitle("Appearance");
                break;
           }
         
       }
    }
 
    }


package client_v01;

//EventHandler and Lambda Action Events
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

//Observable List Import For ComboBox Events
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

//Imports for Maps for Organization
import java.util.Map;
import java.util.HashMap;

//Imports for JavaFX Stage and Scene Setup
import javafx.scene.layout.HBox;
import javafx.geometry.Side;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.ColorPicker;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;

//Import for JavaIO File Reading Events
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
public class Settings {
    
    //SETTINGS CONDITIONS
            
    //MAPS
        //Stage Map Initialization
        private static final Map SCENEMAP = new HashMap();
    
    //STAGES
        //Settings Stage Initialization
        private final Stage SETTINGS = new Stage();
    
    //TABS
        //Major Tab Initializations
        private final Tab APPEARANCE = new Tab("Appearance");
        private final Tab AUDIO = new Tab("Audio");
        private final Tab CHAT = new Tab("Chat");
        private final Tab ABOUT = new Tab("About");
    
    //BUTTONS
        //Major Tab Content Initialization About
        private final Button TERMS = new Button("TERMS AND AGREEMENTS");
        private final Button ABOUTUS = new Button("ABOUT US");
        
        //Major Tab Content Initialization Appearance
        private final Button THEME = new Button("THEME");
        private final Button RESOLUTION = new Button("RESOLUTION");
        
        //BackButton If Necessary
        private static final Button BACKBUTTON = new Button("BACK");
    
    //PANES
        //BorderPane Initializations
        private final BorderPane MAJORPANE = new BorderPane();

        //InnerBorderPane GridPane Initialization Appearance
        private final GridPane APPEARANCEPANE = new GridPane();

        //InnerBorderPane GridPane Initialization About
        private final GridPane ABOUTPANE = new GridPane();

        //Settings Tab Panes
        private final TabPane MAJOR = new TabPane(APPEARANCE, AUDIO, CHAT, ABOUT);
    
    //SCENES
        //Settings Scene
        private final Scene SETTINGSSCENE = new Scene(MAJORPANE);
    
    //PROPERTIES
        //Stage Size
        private static final double WIDTH = 600;
        private static final double HEIGHT = 400;
        
    //STYLINGS
        //File Read In for Button
        private static String[] fileReadIn = new String[6];
        
        //Style for //BUTTONCOLOR//BUTTONHOVERCOLOR//BUTTONPREVIEW//BUTTONHOVERPREVIEW//
        private static final String[] BUTTONCOLORSCHEME = {"d4e2f7;", "ff7fc1;", "d4e2f7;", "ff7fc1;"};
        
        //Style for Read-in of //TEXTCOLOR//BUTTONCOLOR//PRIMARYCOLOR//ACCENTCOLOR
        private static String[] currentSetup = new String[4];
        private static String[] tempSetup = new String[4];
       
        /* Button Variables for Hexadecimal Colors
        private static String BUTTONCOLOR = "#d4e2f7";
        private static String BUTTONHOVERCOLOR = "#ff7fc1";
        private static String BUTTONPREVIEW = "#d4e2f7";
        private static String BUTTONHOVERPREVIEW = "#ff7fc1";
        
        
           /* //BUTTON UNHOVERED
            private static String BUTTONSTYLE = "-fx-padding: 10 10 10 10; -fx-background-color: " + BUTTONCOLOR + "; -fx-font-family: serif;"
                        + "-fx-border-radius: 18 18 18 18; -fx-font-size: large; -fx-vertical-align: middle; -fx-position: absolute;";
            
            //BUTTON HOVERED
            private static String BUTTONHOVERSTYLE = "-fx-background-color: " + BUTTONHOVERCOLOR + "; -fx-padding: 10 10 10 10; -fx-color: red; -fx-letter-spacing: 1;"
                        + "-fx-font-family: serif; -fx-border-radius: 18 18 18 18;  -fx-font-size: x-large; -fx-vertical-align: middle; "
                        + "-fx-border-style: solid; -fx-border-width: 4px; -fx-border-color: #ff7fa1; -fx-position: absolute;";
            
            //BACKBUTTON UNHOVERED
            private static String BACKBUTTONSTYLE = "-fx-background-color: " + BUTTONCOLOR + "; -fx-padding: 10 10 10 10; -fx-border-radius: 18 18 18 18; -fx-position: absolute;"
                        + "-fx-font-family: serif; -fx-font-size: medium; -fx-vertical-align: middle";
            
            //BACKBUTTON HOVERED
            private static String BACKBUTTONHOVERSTYLE = "-fx-background-color: " + BUTTONHOVERCOLOR + "; -fx-padding: 10 10 10 10; -fx-color: red; -fx-letter-spacing: 1;"
                        + "-fx-border-radius: 18 18 18 18; -fx-font-family: serif; -fx-font-size: large; -fx-vertical-align: middle; -fx-position: absolute;"
                        + "-fx-border-style: solid; -fx-border-width: 1px; -fx-border-color: #ff7fa1";
            
            //PREVIEW BUTTON UNHOVERED
            private static String BUTTONPREVIEWSTYLE = "-fx-padding: 10 10 10 10; -fx-background-color: " + BUTTONPREVIEW + "; -fx-font-family: serif;"
                        + "-fx-border-radius: 18 18 18 18; -fx-font-size: large; -fx-vertical-align: middle; -fx-position: absolute;";
            
            //PREVIEW BUTTON HOVERED
            private static String BUTTONPREVIEWHOVERSTYLE = "-fx-background-color: " + BUTTONHOVERPREVIEW + "; -fx-padding: 10 10 10 10; -fx-color: red; -fx-letter-spacing: 1;"
                        + "-fx-font-family: serif; -fx-border-radius: 18 18 18 18;  -fx-font-size: x-large; -fx-vertical-align: middle; "
                        + "-fx-border-style: solid; -fx-border-width: 4px; -fx-border-color: #ff7fa1; -fx-position: absolute;"; */
            
        //TEXT STYLES
            //ABOUT & TERMS AND AGREEMENT TEXT
            private static final String LEGALTEXT = "-fx-focus-color: transparent; -fx-padding: 20; -fx-background-color: rgba(0, 0, 0, 0.0); "
                    + "-fx-highlight-fill: #ffffff; -fx-highlight-text-fill: #000000; -fx-font-family: consolas; -fx-letter-spacing: 1;";
            
            //Change Later Used for Theme Style
            private static String TEXTCOLOR;
            
        //THEME
            //METHOD
            private static Stage affirmation = new Stage();
             
            //COMBOBOXES
            private static final String[] TEXTOPTIONS = {"TEXT FONT", "TEXT COLOR", "TEXT SIZE", "DIALOGUEBOX COLOR"};
            private static final String[] BUTTONOPTIONS = {"BACKGROUND COLOR", "TEXT COLOR", "TEXT FONT", "HOVER COLOR"};
            private static final String[] PRIMARYOPTIONS = {"PANE COLOR", "TAB COLOR", "WINDOW COLOR"};
            private static final String[] ACCENTOPTIONS = {"BORDER COLOR", "TAB CONTENTS COLOR"};
            
            private static final ObservableList<String> TEXTOBSERVABLE = FXCollections.observableArrayList(TEXTOPTIONS);
            private static final ObservableList<String> BUTTONOBSERVABLE = FXCollections.observableArrayList(BUTTONOPTIONS);
            private static final ObservableList<String> PRIMARYOBSERVABLE = FXCollections.observableArrayList(PRIMARYOPTIONS);
            private static final ObservableList<String> ACCENTOBSERVABLE = FXCollections.observableArrayList(ACCENTOPTIONS);
            
            //Will Remove Later? Change To Adjust Static Color Variables instead probs  
            private static PrintWriter THEMEPRINTER;
            
            //PANE STYLING
            private static String PRIMARYCOLOR;
            
    
    Settings(Stage CURRENTSTAGE){
        
        //SCENEMAP Initialization
        SCENEMAP.put("SETTINGS", 0);
        SCENEMAP.put("APPEARANCE", 1);
        SCENEMAP.put("ABOUT US", 2);
        SCENEMAP.put("RESOLUTION", 3);
        SCENEMAP.put("THEME", 4);
        SCENEMAP.put("BACK", 5);
        SCENEMAP.put("TERMS AND AGREEMENTS", 6);
 
        //Sets Major Scene Pane
        MAJORPANE.setLeft(MAJOR);
        MAJORPANE.setPrefSize(WIDTH, HEIGHT);
        MAJOR.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        MAJOR.setTabMinWidth(70);
        MAJOR.setSide(Side.TOP);
        
        //Adjust Tab Contents
            //APPEARANCE
            APPEARANCE.setContent(APPEARANCEPANE);
            APPEARANCEPANE.add(THEME, 0, 0);
            APPEARANCEPANE.add(RESOLUTION, 0, 1);
            APPEARANCEPANE.setAlignment(Pos.CENTER);
            APPEARANCEPANE.setVgap(50);
        
            //ABOUT
            ABOUTPANE.addRow(0, TERMS);
            ABOUTPANE.addRow(1, ABOUTUS);
            ABOUTPANE.setPrefSize(WIDTH, HEIGHT);
            ABOUTPANE.setAlignment(Pos.CENTER);
            ABOUTPANE.setVgap(50);
            ABOUT.setContent(ABOUTPANE);
        
        //Button Styler
        
                       //************************************************STRING ORDER************************************************//
            //BUTTONSTYLE[0], BUTTONHOVERSTYLE[1], BACKBUTTONSTYLE[2], BACKBUTTONHOVERSTYLE[3], BUTTONPREVIEWSTYLE[4], BUTTONPREVIEWHOVERSTYLE[5]//
            
        //String to Hold Entire Text Document Content
        String textTotal = "";
        
        //File Read In for Stylings
        try
        {
            //FileInputStream for Stylings Text Document
            FileInputStream systemFile = new FileInputStream("D:\\Summer Project\\TextDocx\\Current Settings.txt");
            
            //Holds Each Char
            int systemText;
            
            //Adds Every Char into the String textTotal
            while((systemText = systemFile.read()) != -1)
            {
                    textTotal += Character.toString((char)systemText);  
            }
            systemFile.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
        //File was Set Up to Have "&" to Split Each Styling, This Splits the fileReadIn Array into 6 Different Stylings
        fileReadIn = textTotal.split("&");
        
        
                //************************************************STRING ORDER************************************************//
                                        //TEXTCOLOR[0], BUTTONCOLOR[1], PRIMARYCOLOR[2], ACCENTCOLOR[3]]//
        
        //Re-initalizes textTotal to Become a Blank String                           
        textTotal = "";
        
        //File Read-in for currentSetup Array
        try
        {          
            //FileInputStream for Color Changing Text Document
            FileInputStream systemFile = new FileInputStream("D:\\Summer Project\\TextDocx\\Current Setup.txt");
            
            //Holds Chars
            int systemText;
            
            //Adds Every Char into the textTotal String
            while((systemText = systemFile.read()) != -1)
            {
                textTotal += Character.toString((char)systemText);
            }
            systemFile.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }     
        
        //Split the Text Document By Ampersands
        currentSetup = textTotal.split("&");
        
        //Sets Up the Button Stylings Based Off the fileReadIn Array Content and Static Color Variables
        BACKBUTTON.setStyle(fileReadIn[2] + BUTTONCOLORSCHEME[0]);
        TERMS.setStyle(fileReadIn[0] + BUTTONCOLORSCHEME[0]);
        ABOUTUS.setStyle(fileReadIn[0] + BUTTONCOLORSCHEME[0]);
        THEME.setStyle(fileReadIn[0] + BUTTONCOLORSCHEME[0]);
        RESOLUTION.setStyle(fileReadIn[0] + BUTTONCOLORSCHEME[0]);
        
        //Adjusts Button Widths
        TERMS.setMinWidth(300);
        ABOUTUS.setMinWidth(300);
        THEME.setMinWidth(300);
        RESOLUTION.setMinWidth(300);
                
        //Initializes Stage
        SETTINGS.setMaxWidth(WIDTH);
        SETTINGS.setMaxHeight(HEIGHT);
        SETTINGS.setScene(SETTINGSSCENE);
        SETTINGS.setResizable(false);
        SETTINGS.setTitle("SETTINGS");
        SETTINGS.initStyle(StageStyle.UTILITY);
        SETTINGS.initModality(Modality.APPLICATION_MODAL);
        SETTINGS.show();    
        
        //Builds Event Handlers for Each Button
        eventHandlerKeyEventButtonPress(ABOUTUS);
        eventHandlerKeyEventButtonPress(TERMS); 
        eventHandlerKeyEventButtonPress(THEME);
        eventHandlerKeyEventButtonPress(BACKBUTTON);
        eventHandlerKeyEventButtonPress(RESOLUTION);
        eventHandlerKeyEventExit(CURRENTSTAGE);
               
    }
    
    // Terms and Agreements Scene Build Method
    private void terms(){
        //Initialization of Visual Items
        final GridPane TERMSGRID =  new GridPane();
        final TextArea TERMSTEXT = new TextArea();
        String TERMSSTRING = "";
        
        //Terms and Agreements Text File Read-in
        try{
            FileInputStream TERMSTXT;
            TERMSTXT = new FileInputStream("D:\\Summer Project\\TextDocx\\Terms and Agreements.txt");
            int fileTxt;
            
            while((fileTxt = TERMSTXT.read()) != -1)
                TERMSSTRING += Character.toString((char)fileTxt);
            
            TERMSTXT.close();
         }
         catch(IOException e){
             System.out.println(e);
         }
        
        //Initialization of Terms and Agreements Text
        TERMSTEXT.setText(TERMSSTRING);
        TERMSTEXT.setWrapText(true);
        TERMSTEXT.setEditable(false);
        TERMSTEXT.setStyle(LEGALTEXT);
        TERMSTEXT.setPrefSize(WIDTH-40, HEIGHT-130);
        
        //Label for Terms Text Box
        final Label TERMSLABEL = new Label("TERMS AND AGREEMENTS", TERMSTEXT);
        TERMSLABEL.setContentDisplay(ContentDisplay.BOTTOM);
        TERMSLABEL.setAlignment(Pos.CENTER);
        
        //Grid and Pane Adjustment
        TERMSGRID.addRow(0, BACKBUTTON);
        TERMSGRID.setPadding(new Insets(10, 10, 10, 10));
        TERMSGRID.addRow(1, TERMSLABEL);
        
        //Builds and Returns Scene
        SETTINGS.setScene(new Scene(TERMSGRID, WIDTH, HEIGHT));
        SETTINGS.setTitle("TERMS AND AGREEMENTS");
        SETTINGS.show();
    }
    
    //About Us Scene Build Method
    private void about(){
        //Initialization of Visual Items
        final GridPane ABOUTGRID =  new GridPane();
        final TextArea ABOUTTEXT = new TextArea();
        String ABOUTSTRING = "";
        
        //About Text File Read-in
        try{
            FileInputStream ABOUTTXT;
            ABOUTTXT = new FileInputStream("D:\\Summer Project\\TextDocx\\About Section.txt");
            int fileTxt;
            
            while((fileTxt = ABOUTTXT.read()) != -1)
                ABOUTSTRING += Character.toString((char)fileTxt);
            
            ABOUTTXT.close();
         }
         catch(IOException e){
             System.out.println(e);
         }
        
        //Initialization of About Text
        ABOUTTEXT.setText(ABOUTSTRING);
        ABOUTTEXT.setWrapText(true);
        ABOUTTEXT.setEditable(false);
        ABOUTTEXT.setStyle(LEGALTEXT);
        ABOUTTEXT.setPrefSize(WIDTH-40, HEIGHT-130);
        
        //Label for Terms Text Box
        final Label ABOUTLABEL = new Label("ABOUT US", ABOUTTEXT);
        ABOUTLABEL.setContentDisplay(ContentDisplay.BOTTOM);
        ABOUTLABEL.setAlignment(Pos.CENTER);
        
        //Grid and Pane Adjustment
        ABOUTGRID.addRow(0, BACKBUTTON);
        ABOUTGRID.setPadding(new Insets(10, 10, 10, 10));
        ABOUTGRID.addRow(1, ABOUTLABEL);
        
        //Builds and Returns Scene
        SETTINGS.setScene(new Scene(ABOUTGRID, WIDTH, HEIGHT));
        SETTINGS.setTitle("ABOUT US");
        SETTINGS.show();
        
    }
    
    //Theme Scene Builder Method
    private void theme()
    {
        //Theme Pane Initialization
        final VBox THEMEFULL = new VBox();
        final GridPane THEMEGRID = new GridPane();
        final VBox TEXTPLUSPREVIEW = new VBox();
        final VBox BUTTONPLUSPREVIEW = new VBox();
        final VBox PRIMARYPLUSPREVIEW = new VBox();
        final VBox ACCENTPLUSPREVIEW = new VBox();
        
        //ComboBox Initialzation
            //TEXT
            final ComboBox TEXTCOMBO = new ComboBox();
            final Label TEXTLABEL = new Label("Text Color: ", TEXTCOMBO);
            TEXTLABEL.setContentDisplay(ContentDisplay.RIGHT);
        
            //BUTTON
            final ComboBox BUTTONCOMBO = new ComboBox();
            final Label BUTTONLABEL = new Label("Button Primary Color: ", BUTTONCOMBO);
            BUTTONLABEL.setContentDisplay(ContentDisplay.RIGHT);
        
            //PRIMARY COLOR
            final ComboBox PRIMARYCOMBO = new ComboBox();
            final Label PRIMARYLABEL = new Label("Primary Client Color: ", PRIMARYCOMBO);
            PRIMARYLABEL.setContentDisplay(ContentDisplay.RIGHT);
        
            //ACCENT COLOR
            final ComboBox ACCENTCOMBO = new ComboBox();
            final Label ACCENTLABEL = new Label("Button Accent Color: ", ACCENTCOMBO);
            ACCENTLABEL.setContentDisplay(ContentDisplay.RIGHT);
        
        //Preview Features
            //TEXT
            final TextField TEXTPREVIEW = new TextField();
            TEXTPREVIEW.setText("This is a TEXT PREVIEW");
            TEXTPREVIEW.setEditable(false);
        
            //BUTTON
            final Button PREVIEWBUTTON = new Button("PREVIEW");
        
            //PRIMARY PANE
            final Pane PRIMARYPREVIEW = new Pane();
        
            //ACCENT
            final Button ACCENTPREVIEW = new Button("PREVIEW");
        
        
        //Initialization of TextColor Combo Box Contents
            
            //Adds Items to ComboBox From TEXTOBSERVABLE Observable ArrayList
            TEXTCOMBO.getItems().addAll(TEXTOBSERVABLE);
            
            //Lambda On Action Event For Picking Items From a Combo Box
            TEXTCOMBO.setOnAction(e -> {
               themeMethod(TEXTOBSERVABLE.indexOf(TEXTCOMBO.getValue()), 1); 
            });
        
        //Initialization of ButtonColor Combo Box Contents
            
            //Adds Items to ComboBox From BUTTONOBSERVABLE Observable ArrayList
            BUTTONCOMBO.getItems().addAll(BUTTONOBSERVABLE);   
            
            //Lambda On Action Event For Picking Items From a Combo Box
            BUTTONCOMBO.setOnAction(e -> {
            //Try-Catch For Any IO Errors Thtat May Occur in themeMethod    
            //try {
                themeMethod(BUTTONOBSERVABLE.indexOf(BUTTONCOMBO.getValue()), 2);
            /*} catch (IOException ex) {
                System.out.println(ex);
            } */
        });
        
        //Initialization of PrimaryColor Combo Box Contents
        
            //Adds Items to ComboBox From PRIMARYOBSERVABLE Observable ArrayList
            PRIMARYCOMBO.getItems().addAll(PRIMARYOBSERVABLE);
            
            //Lambda On Action Event For Picking Items From a Combo Box
            PRIMARYCOMBO.setOnAction(e -> {
                themeMethod(PRIMARYOBSERVABLE.indexOf(PRIMARYCOMBO.getValue()), 3);
            });
        
        //Initialization of AccentColor Combo Box Contents
        
            //Adds Items to ComboBox From ACCENTOBSERVABLE Observable ArrayList
            ACCENTCOMBO.getItems().addAll(ACCENTOBSERVABLE);
            
            //Lambda On Action Event For Picking Items From a Combo Box
            ACCENTCOMBO.setOnAction(e -> {
                themeMethod(ACCENTOBSERVABLE.indexOf(ACCENTCOMBO.getValue()), 4);
            });
        
        //Initialization of the VBoxes
            //TEXT PREVIEW
            TEXTPLUSPREVIEW.getChildren().addAll(TEXTLABEL, TEXTPREVIEW);
            TEXTPLUSPREVIEW.setSpacing(20);
            
            //BUTTON PREIVEW
            BUTTONPLUSPREVIEW.getChildren().addAll(BUTTONLABEL, PREVIEWBUTTON);
            BUTTONPLUSPREVIEW.setSpacing(20);
        
            //PRIMARY PREVIEW
            PRIMARYPLUSPREVIEW.getChildren().addAll(PRIMARYLABEL, PRIMARYPREVIEW);
            PRIMARYPLUSPREVIEW.setSpacing(20);
            
            //ACCENT PREVIEW
            ACCENTPLUSPREVIEW.getChildren().addAll(ACCENTLABEL, ACCENTPREVIEW);
            ACCENTPLUSPREVIEW.setSpacing(20);
        
        //Initialization of the Scene Layout
        THEMEGRID.add(TEXTPLUSPREVIEW, 0, 0);
        THEMEGRID.add(BUTTONPLUSPREVIEW, 0, 1);
        THEMEGRID.add(PRIMARYPLUSPREVIEW, 1, 0);
        THEMEGRID.add(ACCENTPLUSPREVIEW, 1, 1);
        THEMEGRID.setAlignment(Pos.BOTTOM_CENTER);
        THEMEGRID.setHgap(100);
        THEMEGRID.setVgap(100);
        
        //Initialization of THEMEFULL VBox
        THEMEFULL.getChildren().addAll(BACKBUTTON, THEMEGRID);
        THEMEFULL.setPadding(new Insets(10, 10, 10, 10));
        
        //Scene Builder
        SETTINGS.setScene(new Scene(THEMEFULL, 600, 400));
        SETTINGS.setTitle("THEME");
        SETTINGS.show();
    
    }
    
    //Button Press Action Event Handler
    private void eventHandlerKeyEventButtonPress(Button button)
    {
        //Regular Action for Button Hover Event
        if(!button.getText().equalsIgnoreCase("BACK"))
            button.setOnMouseEntered(e ->
            {
                button.setStyle(fileReadIn[1] + BUTTONCOLORSCHEME[1]);
            
            });
        
        //Specific Action for the BackButton Hover
        else if(button.getText().equalsIgnoreCase("BACK"))
            button.setOnMouseEntered(e ->
            {
                button.setStyle(fileReadIn[3] + BUTTONCOLORSCHEME[1]);
            });
        
        //Regular Action for Button UnHover Event
        if(!button.getText().equalsIgnoreCase("BACK"))
            button.setOnMouseExited(e ->
            {
                button.setStyle(fileReadIn[0] + BUTTONCOLORSCHEME[0]);
            
            });
        
        //Specific Action for BackButton UnHover Event
        else if(button.getText().equalsIgnoreCase("BACK"))
            button.setOnMouseExited(e ->
            {
                button.setStyle(fileReadIn[2] + BUTTONCOLORSCHEME[0]);
            });
        
        //Button Click Action Based Off SceneMap
        button.setOnMouseClicked(e -> 
        {
            //Switch That Will Retrieve A Scene Based Off the Buttons Name (I.E. ABOUT BUTTON CLICK WILL RETURN ABOUT SCENE USING THE "about()" METHOD)
            switch((int)SCENEMAP.get(button.getText()))
            {
                case 2:
                        about();
                        break;
                
                case 4:
                        theme();
                        break;
                
                case 6:
                        terms();
                        break;
                        
                case 5:
                        eventHandlerKeyEventBackArrow();
                        break;
            }
        });
        
    }
    
    //Handles the BackButton's Actions Depending on the StageTitle
    private void eventHandlerKeyEventBackArrow()
    {
        
        //Ensure Map Actually Has the Key First
        if(SCENEMAP.containsKey(SETTINGS.getTitle()))
        {
            //If Map Has Key, Check Which Number Matches the Key
            switch((int)SCENEMAP.get(SETTINGS.getTitle()))
            {
                //Returns to the Settings Scene From the Appearance Scene
                case 1: 
                    SETTINGS.setScene(SETTINGSSCENE);
                    SETTINGS.setTitle("SETTINGS");
                    SETTINGS.show();
                break;
                
                //Returns to the Settings Scene From the About Scene
                case 2: 
                    SETTINGS.setScene(SETTINGSSCENE);
                    SETTINGS.setTitle("SETTINGS");
                    SETTINGS.show();
                break;
                
                //Returns to the Settings Scene From the Theme Scene
                case 4:
                    try{
                        affirmationTheme();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    
                    SETTINGS.setScene(SETTINGSSCENE);
                    SETTINGS.setTitle("SETTINGS");
                    SETTINGS.show();
                break;
                
                //Returns to the Settings Scene From the Terms Scene
                case 6:
                    SETTINGS.setScene(SETTINGSSCENE);
                    SETTINGS.setTitle("SETTINGS");
                    SETTINGS.show();
                break;              
           }          
       }
    } 
    
    private void eventHandlerKeyEventExit(Stage CURRENTSTAGE)
    {
        SETTINGS.setOnCloseRequest(e ->
        {
          SETTINGS.hide();
        });
    }
    
    //This Will Handle Switching the Colors Somehow...
    private String[] themeMethod(int itemIndex, int themeSection)
    {   
        //CHANGES TEXTCOLOR
        if(themeSection == 1)  
        {
            //Copies currentSetup to A Temporary Setup
            tempSetup[0] = currentSetup[0];
            
            //Changes currentSetup to a Different Color Using HEXAMAP *********************RETURNS NULL ALWAYS, DEFINITELY DOING IT WRONG
            //currentSetup[0] = HEXAMAP.get((String)COLOR[itemIndex]);
        }
        
        //CHANGES BUTTONCOLOR
        if(themeSection == 2)
        {
            //Copies currentSetup to A Temporary Setup
            tempSetup[1] = currentSetup[1];
            
            //Changes currentSetup to a Different Color Using HEXAMAP *********************RETURNS NULL ALWAYS, DEFINITELY DOING IT WRONG
            //currentSetup[1] = HEXAMAP.get((String)COLOR[itemIndex]);
        }
       
        //CHANGES PRIMARYCOLOR
        if(themeSection == 3)
        {
            //Copies currentSetup to A Temporary Setup
            tempSetup[2] = currentSetup[2];
            
            //Changes currentSetup to a Different Color Using HEXAMAP *********************RETURNS NULL ALWAYS, DEFINITELY DOING IT WRONG
            //currentSetup[2] = HEXAMAP.get((String)COLOR[itemIndex]);
        }
            
        //CHANGES ACCENTCOLOR
        if(themeSection == 4)
        {
            //Copies currentSetup to A Temporary Setup
            tempSetup[3] = currentSetup[3];
            
            //Changes currentSetup to a Different Color Using HEXAMAP *********************RETURNS NULL ALWAYS, DEFINITELY DOING IT WRONG
            //currentSetup[3] = HEXAMAP.get((String)COLOR[itemIndex]);
        }
      
        //Returns tempSetup to Finalize Changes???????????????????????
        return tempSetup;
    }
    
    //This Will Be the Confirmation that Will Trigger On Leaving the THEME Scene
    private void affirmationTheme()
    {   
        
        //Initializes the Affirmation Scene Panes, Buttons, and Text
        VBox pane = new VBox();
        HBox buttonPane = new HBox();
        Button yes = new Button("Yes");
        Button no = new Button("No");
        Text question = new Text();
        question.setText("Would You Like to Accept These Changes?");
        
        //Adds Buttons to A HBox buttonPane
        buttonPane.getChildren().addAll(yes, no);
        buttonPane.setSpacing(60);
        buttonPane.setAlignment(Pos.CENTER);
        
        //Styles the Yes and No Buttons Similar to the Preview 
               
        
                    //  *****************WILL ADJUST LATER THIS DOESN'T WORK PROPERLY RIGHT NOW**********************  //
              
                
        yes.setStyle(fileReadIn[4] + tempSetup[0]);
        no.setStyle(fileReadIn[4] + tempSetup[0]);
        
        //Adds All Panes and Text to the Overall VBox Pane
        pane.getChildren().addAll(question, buttonPane);
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(60);
   
        //Lambda Events for OnMouseClick Events for the Yes and No Buttons
        yes.setOnMouseClicked(e ->
        {  
            //Since currentSetup has Already Been Changed, Close the affirmation Stage to Retain the Information
            affirmation.close();
        });
        no.setOnMouseClicked(e ->
        {
           //Change Setup Back to Original Setup that Was Saved Into the tempSetup Array
           changeSetup();
           
           //Then Close affirmation Stage
           affirmation.close();
        });

        //Builds Stage, Sets Scene, and Waits Until User Input Arrives
        affirmation.setScene(new Scene(pane, 300, 200));         
        affirmation.showAndWait();
    }
    
    //Changes the Static Array currentSetup By Rewriting the Files they Are Derived From (HAVE TO DO THIS WITH THE "YES" OPTION STILL)
    private static void changeSetup()
    {
        try{
            //Overwrites the Current File Known as Current Setup.txt
            THEMEPRINTER = new PrintWriter("D:\\Summer Project\\TextDocs\\Current Setup.txt");
            THEMEPRINTER.write(tempSetup[0] + "&" + tempSetup[1] + "&" + tempSetup[2] + "&" + tempSetup[3]);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    private static void colorChanger()
    {
        ColorPicker color = new ColorPicker();
        Button confirm = new Button("Confirm");
        Stage colorStage = new Stage();
        HBox colorHBox = new HBox(color, confirm);
        Scene colorScene = new Scene(colorHBox);
        
        colorStage.setScene(colorScene);
        colorStage.setTitle("Color Change");
        colorStage.showAndWait();
    }

}

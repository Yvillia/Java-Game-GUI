package client_v02_abridged;

//EventHandler and Lambda Action Events
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

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
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.scene.control.Slider;

//Import for JavaIO File Reading Events
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedInputStream;

public class Settings {
    
    //SETTINGS CONDITIONS
            
    //MAPS
        //Stage Map Initialization
        private static final Map SCENEMAP = new HashMap();
        private static final Map FONTMAP = new HashMap();
    
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

        //Inner GridPane Initialization Appearance
        private final GridPane APPEARANCEPANE = new GridPane();
        
        //Inner HBox Initialization Audio
        private final HBox AUDIOPANE = new HBox();
        
        //Inner GridPane Initialization 
        private final GridPane CHATPANE = new GridPane();
        
        //Inner GridPane Initialization About
        private final GridPane ABOUTPANE = new GridPane();

        //Settings Tab Panes
        private final TabPane MAJOR = new TabPane(APPEARANCE, AUDIO, CHAT, ABOUT);
    
    //SLIDERS
        //AUDIO SLIDERS
        private static final Slider MASTER = new Slider();
        private static final Slider GAMEPLAYFX = new Slider();
        private static final Slider CHATFX = new Slider();
        
        //SLIDER LABELS
        private static final Text GAMEPLAYFXTEXT = new Text("Gameplay: ");
        private static final Text CHATFXTEXT = new Text("Chat: ");
        private static final Text MASTERTEXT = new Text("Master: ");
        
        //VBOXES
        private static final VBox SLIDERVBOX = new VBox(MASTER, GAMEPLAYFX, CHATFX);
        private static final VBox LABELVBOX = new VBox(MASTERTEXT, GAMEPLAYFXTEXT, CHATFXTEXT);
   
        //SLIDER PROPERTIES
        private static final int SLIDERWIDTH = 400;
        private static final int SLIDERHEIGHT = 140;
        
    //SCENES
        //Settings Scene
        private final Scene SETTINGSSCENE = new Scene(MAJORPANE);
    
    //PROPERTIES
        //Stage Size
        private static final double WIDTH = 600;
        private static final double HEIGHT = 400;
        
    //STYLINGS
        //File Read In for Button
        private static String[] staticButtonSettings = new String[6];
        
        //Style for //BUTTONCOLOR//BUTTONHOVERCOLOR//BUTTONPREVIEW//BUTTONHOVERPREVIEW//
        private static final String[] BUTTONCOLORSCHEME = {"d4e2f7;", "ff7fc1;", "d4e2f7;", "ff7fc1;"};
        
        //Style for Read-in of //TEXT//BUTTON//PRIMARY//PRESET
            //Style
            private static String[][] styleSetup = new String[3][];
            private static String[][] tempStyleSetup = new String[styleSetup.length][];           
            
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
            private static final String[] BUTTONOPTIONS = {"BACKGROUND COLOR", "TEXT COLOR", "HOVER COLOR"};
            private static final String[] PRIMARYOPTIONS = {"PANE COLOR", "TAB COLOR", "WINDOW COLOR", "BORDER COLOR", "TAB CONTENTS COLOR"};
            private static final String[] PRESETOPTIONS = {"STANDARD", "DARK THEME", "WARM", "OCEAN"};
            
            //Observable Lists for ComboBoxes
            private static final ObservableList<String> TEXTOBSERVABLE = FXCollections.observableArrayList(TEXTOPTIONS);
            private static final ObservableList<String> BUTTONOBSERVABLE = FXCollections.observableArrayList(BUTTONOPTIONS);
            private static final ObservableList<String> PRIMARYOBSERVABLE = FXCollections.observableArrayList(PRIMARYOPTIONS);
            private static final ObservableList<String> PRESETOBSERVABLE = FXCollections.observableArrayList(PRESETOPTIONS);
            
            //Printer that Writes to the Files
            private PrintWriter THEMEPRINTER;
            
            //File Load-ins for Theme Presets
            private static final File STANDARD = new File("D:\\Summer Project\\TextDocx\\STANDARD.preset");
            private static final File DARKTHEME = new File("D:\\Summer Project\\TextDocx\\DARKTHEME.preset");
            private static final File WARM = new File("D:\\Summer Project\\TextDocx\\WARM.preset");
            private static final File OCEAN = new File("D:\\Summer Project\\TextDocx\\OCEAN.preset");
            private static final File BUTTONSETTINGS = new File("D:\\Summer Project\\TextDocx\\Button Settings V02.carrot");
            private static File CURRENT = new File("D:\\Summer Project\\TextDocx\\Current Style Setup V02.carrot");
            
            //File Load-ins for Terms and About
            private static final File ABOUTFILE = new File("D:\\Summer Project\\TextDocx\\About Section.carrot");
            private static final File TERMSFILE = new File("D:\\Summer Project\\TextDocx\\Terms and Agreements.carrot");
            
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
            APPEARANCEPANE.add(THEME, 0, 0);
            APPEARANCEPANE.add(RESOLUTION, 0, 1);
            APPEARANCEPANE.setAlignment(Pos.CENTER);
            APPEARANCEPANE.setVgap(50);
            APPEARANCE.setContent(APPEARANCEPANE);
            
            //ABOUT
            ABOUTPANE.addRow(0, TERMS);
            ABOUTPANE.addRow(1, ABOUTUS);
            ABOUTPANE.setPrefSize(WIDTH, HEIGHT);
            ABOUTPANE.setAlignment(Pos.CENTER);
            ABOUTPANE.setVgap(50);
            ABOUT.setContent(ABOUTPANE);
            
            //AUDIO
                //Master Slider Adjustment
                AUDIOPANE.getChildren().addAll(LABELVBOX, SLIDERVBOX);
                
                
                //VBox Adjustment
                LABELVBOX.setSpacing(70);
                SLIDERVBOX.setSpacing(50);
                LABELVBOX.setPadding(new Insets(30, 0, 0, 0));
                SLIDERVBOX.setPadding(new Insets(30, 0, 0, 0));
                SLIDERVBOX.setPrefWidth(WIDTH-150);
                LABELVBOX.setPrefWidth(50);
                
                //Master Slider Adjustment
                MASTER.setMin(0);
                MASTER.setMax(100);
                MASTER.setMinorTickCount(23);
                MASTER.setMajorTickUnit(25);
                MASTER.setShowTickMarks(false);
                MASTER.setShowTickLabels(true);
                MASTER.snapToTicksProperty().set(false);   
                MASTER.setBlockIncrement(WIDTH);
                MASTER.setPrefWidth(WIDTH-150);
                
                //GameplayFX Slider Adjustment
                GAMEPLAYFX.setMin(0);
                GAMEPLAYFX.setMax(100);
                GAMEPLAYFX.setMinorTickCount(24);
                GAMEPLAYFX.setMajorTickUnit(25);
                GAMEPLAYFX.setShowTickMarks(false);
                GAMEPLAYFX.setShowTickLabels(true);
                GAMEPLAYFX.snapToTicksProperty().set(false);
                GAMEPLAYFX.setBlockIncrement(1000);
                GAMEPLAYFX.setPrefWidth(WIDTH-150);
            
                //ChatFX Slider Adjustment
                CHATFX.setMin(0);
                CHATFX.setMax(100);
                CHATFX.setMinorTickCount(24);
                CHATFX.setMajorTickUnit(25);
                CHATFX.setShowTickMarks(false);
                CHATFX.setShowTickLabels(true);
                CHATFX.showTickMarksProperty().set(false);
                CHATFX.snapToTicksProperty();
                CHATFX.setPrefWidth(WIDTH-150);
            
                //General Pane Adjustment
                AUDIOPANE.setSpacing(30);
                AUDIOPANE.setPadding(new Insets(20, 0, 0, 0));
                AUDIOPANE.setPrefSize(WIDTH, HEIGHT);
                AUDIOPANE.setAlignment(Pos.CENTER);
                AUDIO.setContent(AUDIOPANE);
        
        //Button Styler
        
                       //************************************************STRING ORDER************************************************//
            //BUTTONSTYLE[0], BUTTONHOVERSTYLE[1], BACKBUTTONSTYLE[2], BACKBUTTONHOVERSTYLE[3], BUTTONPREVIEWSTYLE[4], BUTTONPREVIEWHOVERSTYLE[5]//
            
        //String to Hold Entire Text Document Content
        String textTotal = "";
        
        //File Read In for Stylings
        try
        {
            //FileInputStream for Stylings Text Document
            FileInputStream inputStream = new FileInputStream(BUTTONSETTINGS);
            BufferedInputStream systemFile = new BufferedInputStream(inputStream);
            
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
        staticButtonSettings = textTotal.split("&");
        
        
                //************************************************STRING ORDER************************************************//
                        //styleSetup[0 -> TEXT][-> 0 = TEXT FONT, 1 = TEXT COLOR, 2 = TEXT SIZE, 3 = DIALOGUEBOX COLOR]
                        //styleSetup[1 -> BUTTON][-> 0 = BACKGROUND COLOR, 1 = TEXT COLOR, 2 = HOVER COLOR]
                        //styleSetup[2 -> PRIMARY][-> 0 = PANE COLOR, 1 = TAB COLOR, 2 = WINDOW COLOR, 3 = BORDER COLOR, 4 = TAB CONTENTS COLOR]
        
        //Re-initalizes textTotal to Become a Blank String                           
        textTotal = "";
        
        //File Read-in for currentSetup Array
        try
        {          
            //FileInputStream for Color Changing Text Document
            FileInputStream inputStream = new FileInputStream(CURRENT);
            BufferedInputStream systemFile = new BufferedInputStream(inputStream);
            
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
        
        //Creates a Temporary String that will be read into the Style Strings As it is Split
        String[] tempString = textTotal.split("%");
        
        for(int i = 0; i < tempString.length; i++)
        {
            styleSetup[i] = tempString[i].split("&");
        }                   
        
        //Sets Up the Button Stylings Based Off the fileReadIn Array Content and Static Color Variables
        BACKBUTTON.setStyle(staticButtonSettings[2] + styleSetup[1][0] + styleSetup[1][1]);
        TERMS.setStyle(staticButtonSettings[0] + styleSetup[1][0] + styleSetup[1][1]);
        ABOUTUS.setStyle(staticButtonSettings[0] + styleSetup[1][0] + styleSetup[1][1]);
        THEME.setStyle(staticButtonSettings[0] + styleSetup[1][0] + styleSetup[1][1]);
        RESOLUTION.setStyle(staticButtonSettings[0] + styleSetup[1][0] + styleSetup[1][1]);
        
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
        quickEscape(SETTINGS);
                     
    }
    
    // Terms and Agreements Scene Build Method
    private void terms()
    {    
        //Initialization of Visual Items
        final GridPane TERMSGRID =  new GridPane();
        final TextArea TERMSTEXT = new TextArea();
        String TERMSSTRING = "";
        
        //Terms and Agreements Text File Read-in
        try{
            FileInputStream inputStream;
            inputStream = new FileInputStream(TERMSFILE);
            BufferedInputStream TERMSTXT = new BufferedInputStream(inputStream);
            
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
    private void about()
    {    
        //Initialization of Visual Items
        final GridPane ABOUTGRID =  new GridPane();
        final TextArea ABOUTTEXT = new TextArea();
        String ABOUTSTRING = "";
        
        //About Text File Read-in
        try{
            FileInputStream inputStream;
            inputStream = new FileInputStream(ABOUTFILE);
            BufferedInputStream ABOUTTXT = new BufferedInputStream(inputStream);
           
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
        final VBox PRESETPLUSPREVIEW = new VBox();
        
        //ComboBox Initialzation
            //TEXT
            final ComboBox TEXTCOMBO = new ComboBox();
            final Label TEXTLABEL = new Label("Text Style: ", TEXTCOMBO);
            TEXTLABEL.setContentDisplay(ContentDisplay.RIGHT);
        
            //BUTTON
            final ComboBox BUTTONCOMBO = new ComboBox();
            final Label BUTTONLABEL = new Label("Button Style: ", BUTTONCOMBO);
            BUTTONLABEL.setContentDisplay(ContentDisplay.RIGHT);
        
            //PRIMARY COLOR
            final ComboBox PRIMARYCOMBO = new ComboBox();
            final Label PRIMARYLABEL = new Label("Client Style: ", PRIMARYCOMBO);
            PRIMARYLABEL.setContentDisplay(ContentDisplay.RIGHT);
        
            //PRESET COLOR
            final ComboBox PRESETCOMBO = new ComboBox();
            final Label PRESETLABEL = new Label("Theme Presets: ", PRESETCOMBO);
            PRESETLABEL.setContentDisplay(ContentDisplay.RIGHT);
        
        //Preview Features
            //TEXT
            final TextField TEXTPREVIEW = new TextField();
            TEXTPREVIEW.setText("This is a TEXT PREVIEW");
            TEXTPREVIEW.setEditable(false);
        
            //BUTTON
            final Button PREVIEWBUTTON = new Button("PREVIEW");
               
        //Setup for Copying of the Style and Changing the Theme
        tempStyleSetup = styleSetup.clone();
            
        //Initialization of TextColor Combo Box Contents
            
            //Adds Items to ComboBox From TEXTOBSERVABLE Observable ArrayList
            TEXTCOMBO.getItems().addAll(TEXTOBSERVABLE);
            
            //Lambda On Action Event For Picking Items From a Combo Box
            TEXTCOMBO.setOnAction(e -> {
               comboHandler(TEXTOBSERVABLE.indexOf(TEXTCOMBO.getValue()), 0); 
            });
        
        //Initialization of ButtonColor Combo Box Contents
            
            //Adds Items to ComboBox From BUTTONOBSERVABLE Observable ArrayList
            BUTTONCOMBO.getItems().addAll(BUTTONOBSERVABLE);   
            
            //Lambda On Action Event For Picking Items From a Combo Box
            BUTTONCOMBO.setOnAction(e -> {
        
               comboHandler(BUTTONOBSERVABLE.indexOf(BUTTONCOMBO.getValue()), 1);
        });
        
        //Initialization of PrimaryColor Combo Box Contents
        
            //Adds Items to ComboBox From PRIMARYOBSERVABLE Observable ArrayList
            PRIMARYCOMBO.getItems().addAll(PRIMARYOBSERVABLE);
            
            //Lambda On Action Event For Picking Items From a Combo Box
            PRIMARYCOMBO.setOnAction(e -> {
                comboHandler(PRIMARYOBSERVABLE.indexOf(PRIMARYCOMBO.getValue()), 2);
            });
        
        //Initialization of PresetColor Combo Box Contents
        
            //Adds Items to ComboBox From PRESETOBSERVABLE Observable ArrayList
            PRESETCOMBO.getItems().addAll(PRESETOBSERVABLE);
            
            //Lambda On Action Event For Picking Items From a Combo Box
            PRESETCOMBO.setOnAction(e -> {
            presetChanger(PRESETOBSERVABLE.indexOf(PRESETCOMBO.getValue()));
            });
        
        //Initialization of the VBoxes
            //TEXT PREVIEW
            TEXTPLUSPREVIEW.getChildren().addAll(TEXTLABEL, TEXTPREVIEW);
            TEXTPLUSPREVIEW.setSpacing(20);
            
            //BUTTON PREIVEW
            BUTTONPLUSPREVIEW.getChildren().addAll(BUTTONLABEL, PREVIEWBUTTON);
            BUTTONPLUSPREVIEW.setSpacing(20);
        
            //PRIMARY PREVIEW
            PRIMARYPLUSPREVIEW.getChildren().addAll(PRIMARYLABEL);
            PRIMARYPLUSPREVIEW.setSpacing(20);
            
            //PRESET PREVIEW
            PRESETPLUSPREVIEW.getChildren().addAll(PRESETLABEL);
            PRESETPLUSPREVIEW.setSpacing(20);
        
        //Initialization of the Scene Layout
        THEMEGRID.add(TEXTPLUSPREVIEW, 0, 0);
        THEMEGRID.add(BUTTONPLUSPREVIEW, 0, 1);
        THEMEGRID.add(PRIMARYPLUSPREVIEW, 1, 0);
        THEMEGRID.add(PRESETPLUSPREVIEW, 1, 1);
        THEMEGRID.setAlignment(Pos.BOTTOM_CENTER);
        THEMEGRID.setHgap(60);
        THEMEGRID.setVgap(100);
        
        //Initialization of THEMEFULL VBox
        THEMEFULL.getChildren().addAll(BACKBUTTON, THEMEGRID);
        THEMEFULL.setSpacing(50);
        THEMEFULL.setPadding(new Insets(10, 10, 10, 10));
        
        //Scene Builder
        SETTINGS.setScene(new Scene(THEMEFULL, 600, 400));
        SETTINGS.setTitle("THEME");
        SETTINGS.show();
    
    }
    
    //Button Press Action Event Handler
    private void eventHandlerKeyEventButtonPress(Button button)
    {
        //Regular Action for Generic Button Hover Event
        if(!button.getText().equalsIgnoreCase("BACK"))
            button.setOnMouseEntered(e ->
            {
                button.setStyle(staticButtonSettings[1] + styleSetup[1][2]);
            
            });
        
        //Specific Action for the BackButton Hover
        else if(button.getText().equalsIgnoreCase("BACK"))
            button.setOnMouseEntered(e ->
            {
                button.setStyle(staticButtonSettings[3] + styleSetup[1][2]);
            });
        
        //Regular Action for Generic Button UnHover Event
            button.setOnMouseExited(e ->
            {
                button.setStyle(staticButtonSettings[0] + styleSetup[1][0]);
            
            });
        
        //Specific Action for BackButton UnHover Event
            button.setOnMouseExited(e ->
            {
                button.setStyle(staticButtonSettings[2] + styleSetup[1][0]);
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
    
    //This Will Be the Confirmation that Will Trigger On Leaving the THEME Scene
    private void affirmationTheme()
    {   
        
        //Initializes the Affirmation Scene Panes, Buttons, and Text
        VBox pane = new VBox();
        HBox buttonPane = new HBox();
        Button yes = new Button("Yes");
        Button no = new Button("No");
        Text question = new Text();
        question.setText("Would You Like to Accept These Changes? \n\t(Reload the Game for the Settings to Apply)");
        
        //Adds Buttons to A HBox buttonPane
        buttonPane.getChildren().addAll(yes, no);
        buttonPane.setSpacing(60);
        buttonPane.setAlignment(Pos.CENTER);
        
        //Adds All Panes and Text to the Overall VBox Pane
        pane.getChildren().addAll(question, buttonPane);
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(60);
        
        //Stage is Called "affirmation" Setting Title for Stage Here
        affirmation.setTitle("Confirmation");
   
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
    
    //Changes the Static Array currentSetup By Rewriting the Files they Are Derived From 
    
    private void changeSetup()
    {
            //This Will Return the File Back to the Original Setup If the User doesn't want to Change the Current Theme
            try{
                //Makes a New PrintWriter for the File
                THEMEPRINTER = new PrintWriter(CURRENT, "UTF-8");
                
                //New String to Hold the All of the Array Contents
                String completeString = "";
                
                //Nested For-Loops to Read Through the tempStyleSetup Array
                for(int itemReference = 0; itemReference < tempStyleSetup.length; itemReference++)
                {
                    for(int itemIndex = 0; itemIndex < tempStyleSetup[itemReference].length; itemIndex++)
                    {
                        //Condition for the Sake of Formatting (Each Index in Needs to Be Separated by & and Each Reference needs to Be Separated by %)
                        if(itemIndex == tempStyleSetup[itemReference].length - 1)
                            completeString += tempStyleSetup[itemReference][itemIndex];
                        else
                            completeString += tempStyleSetup[itemReference][itemIndex] + "&";
                    }
                    if(itemReference != tempStyleSetup.length-1)
                        completeString += "%";
                }

                //Prints the String to the File in its Entirety
                THEMEPRINTER.print(completeString);
                
                //Closes the File and PrintWriter to Save it
                THEMEPRINTER.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    }
    
    //Not Being Used Until After the File System is Setup
    private void comboHandler(int itemIndex, int itemReference)
    {
        //Ignore the If Statements they are for Formatting the File (styleSetup[0][0] and styleSetup[0][2] Do not Require a Color Change
        if(itemReference == 0 && (itemIndex == 0 || itemIndex == 2))
        {
            //This Will Account for the differences in changing of the text
            textChanger();
            
            //Prevents the ColorPicker for Being Produced since it was not needed and Exits the Method
            return;
        }
        
        //Creates a ColorPicker that is Used for Each Color Changing Setting
        ColorPicker color = new ColorPicker();
        
        //Creates a Confirm Button that will Either Save or Exit the colorScene Below
        Button confirm = new Button("Confirm");
        
        //Creates a New Stage to Hold the ColorPicker and Button
        Stage colorStage = new Stage();
        
        //Creates an HBox to Hold the Button and ColorPicker
        HBox colorHBox = new HBox(color, confirm);
        
        //Adjusts the HBox Properties
        colorHBox.setSpacing(30);
        colorHBox.setAlignment(Pos.CENTER);
        colorHBox.setPrefSize(WIDTH/2, HEIGHT/3);
        
        //Adjusts Button Style to Match
        confirm.setStyle(staticButtonSettings[0]);
        
        //Builds New Scene that Holds the HBox
        Scene colorScene = new Scene(colorHBox);
        
        //Sets Stage and Stage Title
        colorStage.setScene(colorScene);
        colorStage.setTitle("Color Change");
        
        //Lambda Event to Handle What the Confirm Button Does when Clicked (Currently Only Closes the Stage)
        confirm.setOnMouseClicked(e -> 
        {
            //Conditionals to Ensure that the "-fx-..." Are Correct for Each Section in the File. 
        //Look Up Top Where the styleSetup Array Contents Are Written to See What is Happening
        if((itemReference == 0 && itemIndex == 1) || (itemReference == 1 && itemIndex == 2))
            styleSetup[itemReference][itemIndex] = "-fx-text-color: #" + color.getValue().toString().substring(2, 8) + ";";
        
        else if(itemReference == 2 && itemIndex == 3)
            styleSetup[itemReference][itemIndex] = "-fx-border-color: #" + color.getValue().toString().substring(2, 8) + ";";
                
        else
            styleSetup[itemReference][itemIndex] = "-fx-background-color: #" + color.getValue().toString().substring(2, 8) + ";";
        
            colorStage.close();
        });
         
        //Opens the colorStage and waits until the User Performs an Action to Close
        colorStage.showAndWait();   
        
        //fileWriter() Simply Saves the newly Made styleSetup to the file
        fileWriter();
        
       }
    
    //This Will Do Something Different (Might Remove Later)
    private void textChanger()
    {
        
    }
    
    //This Method will handle a file change in the preset settings in the combobox
    private void presetChanger(int itemIndex)
    {
        //ItemIndex indicates Which Item in the Observable List is Chosen to be Changed
        switch(itemIndex)
        {
             //If Preset is needed to be Changed This will Write the Change to the File from styleSetup[3][0]
             case 0:
                 try{
                     THEMEPRINTER = new PrintWriter(CURRENT, "UTF-8");
                     FileInputStream systemFile = new FileInputStream(STANDARD);
                     
                     int systemInt;
                     
                     String fileString = "";
                     
                     while((systemInt = systemFile.read()) != -1)
                     {
                         fileString += (char)systemInt;
                     }
                     
                     THEMEPRINTER.print(fileString);
                     
                     systemFile.close();
                     THEMEPRINTER.close();
                     SETTINGS.show();
                 }
                 catch(Exception e)
                 {
                     System.out.println(e);
                 }
                    
                    break;
                    
             //If Preset is needed to be Changed This will Write the Change to the File from styleSetup[3][1]
             case 1:
                 
                  try{
                     THEMEPRINTER = new PrintWriter(CURRENT, "UTF-8");
                     FileInputStream systemFile = new FileInputStream(DARKTHEME);
                     
                     int systemInt;
                     
                     String fileString = "";
                     
                     while((systemInt = systemFile.read()) != -1)
                     {
                         fileString += (char)systemInt;
                     }
                     
                     THEMEPRINTER.print(fileString);
                     
                     systemFile.close();
                     THEMEPRINTER.close();
                 }
                 catch(Exception e)
                 {
                     System.out.println(e);
                 }
                    
                    break;
             
             //If Preset is needed to be Changed This will Write the Change to the File from styleSetup[3][2]
             case 2:
                 try{
                     THEMEPRINTER = new PrintWriter(CURRENT, "UTF-8");
                     FileInputStream systemFile = new FileInputStream(WARM);
                     
                     int systemInt;
                     
                     String fileString = "";
                     
                     while((systemInt = systemFile.read()) != -1)
                     {
                         fileString += (char)systemInt;
                     }
                     
                     THEMEPRINTER.print(fileString);
                     
                     systemFile.close();
                     THEMEPRINTER.close();
                 }
                 catch(Exception e)
                 {
                     System.out.println(e);
                 }
                    
                    break;
             
             //If Preset is needed to be Changed This will Write the Change to the File from styleSetup[3][3]       
             case 3:
                 try{
                     THEMEPRINTER = new PrintWriter(CURRENT, "UTF-8");
                     FileInputStream systemFile = new FileInputStream(OCEAN);
                     
                     int systemInt;
                     
                     String fileString = "";
                     
                     while((systemInt = systemFile.read()) != -1)
                     {
                         fileString += (char)systemInt;
                     }
                     
                     THEMEPRINTER.print(fileString);
                     
                     systemFile.close();
                     THEMEPRINTER.close();
                 }
                 catch(Exception e)
                 {
                     System.out.println(e);
                 }
                    
                    break;
                    
        }
    }

    //This will rewrite the file at the end of whatever method to ensure that it does not delete itself. File Printing Scheme is the Exact Same as Everywhere Else
    private void fileWriter()
    {
         try{
                     THEMEPRINTER = new PrintWriter(CURRENT, "UTF-8");
                     
                     String tempString = "";
                     
                     for(int itemReference = 0; itemReference < styleSetup.length; itemReference++)
                     {
                         for(int itemIndex = 0; itemIndex < styleSetup[itemReference].length; itemIndex++)
                         {
                            if(itemIndex == styleSetup[itemReference].length - 1)
                                tempString += styleSetup[itemReference][itemIndex];
                            else
                                tempString += styleSetup[itemReference][itemIndex] + "&";
                            
                         }
                         
                         if(itemReference != styleSetup.length - 1)
                             tempString += "%";
                     }
                     
                     THEMEPRINTER.print(tempString);
                     THEMEPRINTER.close();
                 }
                 catch(Exception e)
                 {
                     System.out.println(e);
                 }
                
    }
    
    //This Should Allow for the User to Exit Settings at Anytime by Pressing the Escape Key, if the User is in Theme then 
    //affirmationTheme() will Run to Change the Saved Appearance Before the Settings Closes
    private void quickEscape(Stage CURRENTSTAGE)
    {
        CURRENTSTAGE.getScene().setOnKeyPressed(e ->
        {
                switch(e.getCode())
                {
                    case ESCAPE: 
                                if(CURRENTSTAGE.getTitle().equalsIgnoreCase("THEME"))
                                {
                                    affirmationTheme();
                                    CURRENTSTAGE.close();
                                }
                                else
                                    CURRENTSTAGE.close();
                                break;
                }
        });    
    }
                
    
}

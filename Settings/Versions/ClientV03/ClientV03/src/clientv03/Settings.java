package clientv03;

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
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

//Import for JavaIO File Reading Events
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedInputStream;

public class Settings {
    
            /**************************************************************************************************************************************/
            //  Section 0: VARIABLE/CONSTANT DECLARATION AND INITIALIZATION                                                                       //
            //      1. MAPS                     6. SLIDERS                                                                                        //
            //      2. STAGES                   7. SCENES                                                                                         //
            //      3. TABS                     8. PROPERTIES                                                                                     //               
            //      4. BUTTONS                  9. STYLE                                                                                          //      
            //      5. PANES                                                                                                                      //
            //                                                                                                                                    //
            /**************************************************************************************************************************************/
    
    //SETTINGS CONDITIONS
            
    // 1. MAPS
        //Stage Map Initialization
        private static final Map SCENEMAP = new HashMap();
    
    // 2. STAGES
        //Settings Stage Initialization
        private final Stage SETTINGS = new Stage();
    
    // 3. TABS
        //Major Tab Initializations
        private final Tab APPEARANCE = new Tab("Appearance");
        private final Tab AUDIO = new Tab("Audio");
        private final Tab CHAT = new Tab("Chat");
        private final Tab ABOUT = new Tab("About");
    
    // 4. BUTTONS
        //Major Tab Content Initialization About
        private final Button TERMS = new Button("TERMS AND AGREEMENTS");
        private final Button ABOUTUS = new Button("ABOUT US");
        
        //Major Tab Content Initialization Appearance
        private final Button THEME = new Button("THEME");
        private final Button RESOLUTION = new Button("RESOLUTION");
        
        //BackButton If Necessary
        private static final Button BACKBUTTON = new Button("BACK");
    
    // 5. PANES
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
    
    // 6. SLIDERS
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
        
    // 7. SCENES
        //Settings Scene
        private final Scene SETTINGSSCENE = new Scene(MAJORPANE);
    
    // 8. PROPERTIES
        //Stage Size
        private static int WIDTH = 600;
        private static int HEIGHT = 400;
        
        //GameScreen Size
        private static int GAMEWIDTH = 1200;
        private static int GAMEHEIGHT = 600;
        
    // 9. STYLE
        //TEXT STYLES
            //ABOUT & TERMS AND AGREEMENT TEXT
            private static final String LEGALTEXT = "-fx-padding: 20; -fx-font-size: large; "
                    + "-fx-highlight-fill: #ffffff; -fx-highlight-text-fill: #000000; -fx-font-family: consolas; -fx-letter-spacing: 2;";
            
        //THEME
            //METHOD
            private Stage affirmation = new Stage();
             
            //COMBOBOXES
            private static final String[] TEXTOPTIONS = {"TEXT FONT", "TEXT COLOR", "TEXT SIZE", "DIALOGUEBOX COLOR"};
            private static final String[] BUTTONOPTIONS = {"BACKGROUND COLOR", "TEXT COLOR", "HOVER COLOR"};
            private static final String[] PRIMARYOPTIONS = {"PANE COLOR", "TAB COLOR", "WINDOW COLOR", "BORDER COLOR", "TAB CONTENTS COLOR"};
            private static final String[] PRESETOPTIONS = {"STANDARD", "DARK THEME", "WARM", "OCEAN"};
            
            //PRESETHANDLER
            private boolean presetChosen;
            
            //Observable Lists for ComboBoxes
            private static final ObservableList<String> TEXTOBSERVABLE = FXCollections.observableArrayList(TEXTOPTIONS);
            private static final ObservableList<String> BUTTONOBSERVABLE = FXCollections.observableArrayList(BUTTONOPTIONS);
            private static final ObservableList<String> PRIMARYOBSERVABLE = FXCollections.observableArrayList(PRIMARYOPTIONS);
            private static final ObservableList<String> PRESETOBSERVABLE = FXCollections.observableArrayList(PRESETOPTIONS);
            
            //Printer that Writes to the Files
            private PrintWriter THEMEPRINTER;
            
            //CSS Array to Hold Each Individual CSS Setting
            private static String[][] styleSetup = new String[4][5];
            private static String prevStyleSetup; 
            
            //File Load-ins for Theme Presets
            private static final File STANDARDCSS = new File("D:\\SummerProject\\TextDocx\\STANDARDCSS.preset");
            private static final File DARKTHEMECSS = new File("D:\\SummerProject\\TextDocx\\DARKTHEMECSS.preset");
            private static final File WARMCSS = new File("D:\\SummerProject\\TextDocx\\WARMCSS.preset");
            private static final File OCEANCSS = new File("D:\\SummerProject\\TextDocx\\OCEANCSS.preset");
            public static File CSS = new File("D:\\SummerProject\\Versions\\ClientV03\\src\\clientv03\\SettingsCSS.css");
            
            //File Load-ins for Terms and About
            private static final File ABOUTFILE = new File("D:\\SummerProject\\TextDocx\\About Section.carrot");
            private static final File TERMSFILE = new File("D:\\SummerProject\\TextDocx\\Terms and Agreements.carrot");
    
            /**************************************************************************************************************************************/
            //  Section 1: SETTINGS CONSTRUCTOR                                                                                                   //
            //      Settings(Stage CURRENTSTAGE);                                                                                                 //
            //                                                                                                                                    //            
            //                                                                                                                                    //      
            /**************************************************************************************************************************************/
            
    Settings(Stage CURRENTSTAGE){
        
        //BUTTON CSS StyleSheet
        THEME.getStyleClass().add("Button");
        TERMS.getStyleClass().add("Button");
        ABOUTUS.getStyleClass().add("Button");
        RESOLUTION.getStyleClass().add("Button");
        BACKBUTTON.getStyleClass().add("BackButton");
        
        
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
        
        //Affirmation Style Override
        affirmation.initStyle(StageStyle.UNDECORATED);
        
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
        
        //Adjusts Button Widths
        TERMS.setMinWidth(300);
        ABOUTUS.setMinWidth(300);
        THEME.setMinWidth(300);
        RESOLUTION.setMinWidth(300);
        
        
        //*********************************************************STYLESETUP STRING ORDER*********************************************************//
        //             styleSetup[0 -> TEXT][-> 0 = TEXT FONT, 1 = TEXT COLOR, 2 = TEXT SIZE, 3 = DIALOGUEBOX COLOR]                               //
        //             styleSetup[1 -> BUTTON][-> 0 = BACKGROUND COLOR, 1 = TEXT COLOR, 2 = HOVER COLOR]                                           //
        //             styleSetup[2 -> PRIMARY][-> 0 = PANE COLOR, 1 = TAB COLOR, 2 = WINDOW COLOR, 3 = BORDER COLOR, 4 = TAB CONTENTS COLOR]      //
        //*****************************************************************************************************************************************//
        
        //Initializes textTotal to Become a Blank String                           
        String textTotal = "";
        
        //File Read-in for currentSetup Array
        try
        {          
            //FileInputStream for Color Changing Text Document
            FileInputStream inputStream = new FileInputStream(CSS);
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
        
        //Creates a String that Holds the Previous CSS Setup
        prevStyleSetup = textTotal;           
          
        //Initializes Stage
        SETTINGS.setMaxWidth(WIDTH);
        SETTINGS.setMaxHeight(HEIGHT);
        SETTINGS.setScene(SETTINGSSCENE);
        SETTINGS.setResizable(false);
        SETTINGS.setTitle("SETTINGS");
        SETTINGS.initStyle(StageStyle.UTILITY);
        SETTINGS.initModality(Modality.APPLICATION_MODAL);
        SETTINGS.getScene().getStylesheets().add("file:///" + CSS.getAbsolutePath().replace("\\", "/"));
        SETTINGS.show();    
        
        //Builds Event Handlers for Each Button and Pane
        eventHandlerKeyEventButtonPress(ABOUTUS);
        eventHandlerKeyEventButtonPress(TERMS); 
        eventHandlerKeyEventButtonPress(THEME);   
        eventHandlerKeyEventButtonPress(RESOLUTION);
        eventHandlerKeyEventButtonPress(BACKBUTTON);
        quickEscape(SETTINGS);                 
    }
    
            /**************************************************************************************************************************************/
            //  Section 2: BUTTON METHODS                                                                                                         //
            //      private void terms();                                                                                                         //
            //      private void about();                                                                                                         //               
            //      private void theme();                                                                                                         //
            //      private void resolution();                                                                                                    //
            //                                                                                                                                    //
            /**************************************************************************************************************************************/
    
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
              
            inputStream.close();
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
        SETTINGS.getScene().getStylesheets().add("file:///" + CSS.getAbsolutePath().replace("\\", "/"));
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
            
            inputStream.close();
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
        SETTINGS.getScene().getStylesheets().add("file:///" + CSS.getAbsolutePath().replace("\\", "/"));
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
            TEXTCOMBO.setPrefSize(120, 20);
            final Label TEXTLABEL = new Label("Text Style: ", TEXTCOMBO);
            TEXTLABEL.setContentDisplay(ContentDisplay.RIGHT);
            TEXTLABEL.setStyle("-fx-text-fill: #b3adaa; -fx-font-size: large;");
            TEXTLABEL.setAlignment(Pos.CENTER);
        
            //BUTTON
            final ComboBox BUTTONCOMBO = new ComboBox();
            BUTTONCOMBO.setPrefSize(120, 20);
            final Label BUTTONLABEL = new Label("Button Style: ", BUTTONCOMBO);
            BUTTONLABEL.setContentDisplay(ContentDisplay.RIGHT);
            BUTTONLABEL.setStyle("-fx-text-fill: #b3adaa; -fx-font-size: large;");
            BUTTONLABEL.setAlignment(Pos.CENTER);
        
            //PRIMARY COLOR
            final ComboBox PRIMARYCOMBO = new ComboBox();
            PRIMARYCOMBO.setPrefSize(120, 20);
            final Label PRIMARYLABEL = new Label("Client Style: ", PRIMARYCOMBO);
            PRIMARYLABEL.setContentDisplay(ContentDisplay.RIGHT);
            PRIMARYLABEL.setStyle("-fx-text-fill: #b3adaa; -fx-font-size: large;");
            PRIMARYLABEL.setAlignment(Pos.CENTER);
        
            //PRESET COLOR
            final ComboBox PRESETCOMBO = new ComboBox();
            PRESETCOMBO.setPrefSize(120, 20);
            final Label PRESETLABEL = new Label("Theme Presets: ", PRESETCOMBO);
            PRESETLABEL.setContentDisplay(ContentDisplay.RIGHT);
            PRESETLABEL.setStyle("-fx-text-fill: #b3adaa; -fx-font-size: large;");
            PRESETLABEL.setAlignment(Pos.CENTER);
        
        //Preview Features
            
            //TEXT
            final TextField TEXTPREVIEW = new TextField();
            TEXTPREVIEW.setText("This is a TEXT PREVIEW");
            TEXTPREVIEW.getStyleClass().add("Text");
            TEXTPREVIEW.setEditable(false);
        
            //BUTTON
            final Button PREVIEWBUTTON = new Button("PREVIEW");
            PREVIEWBUTTON.getStyleClass().add("Button");
            
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
        SETTINGS.getScene().getStylesheets().add("file:///" + CSS.getAbsolutePath().replace("\\", "/"));
        SETTINGS.setTitle("THEME");
        SETTINGS.show();
    
    }
    
    //Method for Building the Resolution Scene
    private void resolution()
    {
        //Array List to Build ObservableArrayList
        String[] dimensions = {"1280 X 720", "1280 X 1024", "1920 X 1080", "3840 X 2160"};
        
        //Observable Array List for ComboBox
        ObservableList RESOLUTIONOBSERVABLE = FXCollections.observableArrayList(dimensions);
        
        //ComboBox for Choosing Resolution
        ComboBox resolutionCombo = new ComboBox(RESOLUTIONOBSERVABLE);
        
        //Label for ComboBox and Label Configuration
        Label resolutionLabel = new Label("Screen Size: ", resolutionCombo);
        resolutionLabel.setContentDisplay(ContentDisplay.RIGHT);
        
        //VBox Container for the Entire Scene
        VBox outerContainer = new VBox();
        
        //HBox Container for the BackButton and Configuration of the BackButton and Its Container
        HBox backContainer = new HBox(BACKBUTTON);
        backContainer.setAlignment(Pos.TOP_LEFT);
        backContainer.setPadding(new Insets (10, 10, 10, 10));
        BACKBUTTON.getStyleClass().add("BackButton");
        backContainer.setPrefSize(100, 40);
        
        //GridPane to Hold ComboBox (and potentially a Confirm Button)
        GridPane resolutionPane = new GridPane(); 
        resolutionPane.add(resolutionLabel, 0, 0);
        resolutionPane.setAlignment(Pos.CENTER);
        resolutionPane.setPrefSize(WIDTH, HEIGHT - 75);
       
        //Adding Subcomponents to the Outer VBox
        outerContainer.getChildren().addAll(backContainer, resolutionPane);
        
        //Creates New Scene That Holds the VBox
        Scene resolutionScene = new Scene(outerContainer);
        
        //On ComboBox Value Set, Change the Values of Width and Height to Match the Resolution (Splits Based on the 'X' in "1920 X 1080")
        resolutionCombo.setOnAction(e ->
        {
            String[] resolutionSelect = resolutionCombo.getValue().toString().split("X");
            GAMEWIDTH = Integer.parseInt(resolutionSelect[0].trim());
            GAMEHEIGHT = Integer.parseInt(resolutionSelect[1].trim());
        });
    
        //Sets and Displays Scene
        SETTINGS.setScene(resolutionScene);
        SETTINGS.setTitle("RESOLUTION");
        SETTINGS.show();
    }
    
            /**************************************************************************************************************************************/
            // Section 3: CONFIRMATION                                                                                                            //
            //     private void affirmationTheme();                                                                                               //
            //                                                                                                                                    //      
            //                                                                                                                                    //
            /**************************************************************************************************************************************/
    
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
        
        //Styles the Buttons
        yes.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff");
        no.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff");
       
        //Hover Button Event Handlers For Yes and No Buttons on the Affirmation Theme
        yes.setOnMouseEntered(e->
        {
            yes.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000;");
        });
        
        yes.setOnMouseExited(e ->
        {
            yes.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff;");
        });
        
        no.setOnMouseEntered(e->
        {
           no.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000"); 
           
        });
        
        no.setOnMouseExited(e->
        {
           no.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff;"); 
        });
    
        
        //Adds Buttons to A HBox buttonPane
        buttonPane.getChildren().addAll(yes, no);
        buttonPane.setSpacing(60);
        buttonPane.setAlignment(Pos.CENTER);
        
        //Adds All Panes and Text to the Overall VBox Pane
        pane.getChildren().addAll(question, buttonPane);
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(60);
        pane.setStyle("-fx-background-color: #ffffff;");
        
        //Stage is Called "affirmation" Setting Title for Stage Here
        affirmation.setTitle("Confirmation");
   
        //Lambda Events for OnMouseClick Events for the Yes and No Buttons
        yes.setOnMouseClicked(e ->
        {   
            if(!presetChosen)
                //Writes new Information to the File
                fileWriter();
            
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
        Scene affirmationScene = new Scene(pane, 300, 200);
        affirmation.setScene(affirmationScene);   
        affirmation.showAndWait();
    }
     
            /**************************************************************************************************************************************/
            // Section 4: STYLE RESET METHOD                                                                                                      //
            //     private void changeSetup();                                                                                                    //             
            //                                                                                                                                    //      
            //                                                                                                                                    //
            /**************************************************************************************************************************************/
    
    //Changes the Static Array currentSetup By Rewriting the Files they Are Derived From 
    private void changeSetup()
    {
            //This Will Return the File Back to the Original Setup If the User doesn't want to Change the Current Theme
            try{
                //Makes a New PrintWriter for the File
                THEMEPRINTER = new PrintWriter(CSS, "UTF-8");
                
                //Prints the String that Saved the Previous Style When the Program Opened
                THEMEPRINTER.print(prevStyleSetup);
                
                //Closes the File and PrintWriter to Save it
                THEMEPRINTER.close();
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    }
    
            /**************************************************************************************************************************************/
            // Section 5: COMBOBOX HANDLING METHODS                                                                                               //
            //     private void comboHandler(int itemIndex, int itemReference);                                                                   //
            //     private void textChanger(int itemIndex);                                                                                       //               
            //     private void presetChanger(int itemIndex);                                                                                     //      
            //                                                                                                                                    //
            /**************************************************************************************************************************************/
    
    //Handler for ComboBox Events in the Theme Section
    private void comboHandler(int itemIndex, int itemReference)
    {
        //Diverts Font and FontSize to Another Method Since this Method Builds a ColorPicker Theme
        if(itemReference == 0 && (itemIndex == 0 || itemIndex ==2))
        {
            textChanger(itemIndex);
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
        confirm.getStyleClass().add("Button");
        
        //Builds New Scene that Holds the HBox
        Scene colorScene = new Scene(colorHBox);
        
        //Sets Stage and Stage Title
        colorStage.setScene(colorScene);
        colorStage.setTitle("Color Change");
        
        //Lambda Event to Handle What the Confirm Button Does when Clicked (Currently Only Closes the Stage)
        confirm.setOnMouseClicked(e -> 
        {
            //Item Reference -> 0 = Text, 1 = Button, 2 = Pane]
            switch(itemReference)
            {       
                case 0:
                    
                    //Item Index -> 0 = Font-Family, 1 = Text-color, 2 = Font-Size, 3 = DialogueBox Color
                    switch(itemIndex)
                    {
                        case 1:
                            styleSetup[3][1] = "-fx-text-fill: #" + color.getValue().toString().substring(2,8) + ";";
                            break;
                            
                        case 3:
                            styleSetup[3][3] = "-fx-background-color: #" + color.getValue().toString().substring(2,8) + ";";
                          
                    }
                
                case 1:
                    
                    //Item Index -> 0 = Button Color, 1 = Button Text Color, 2 = Button Hover Color
                    switch(itemIndex)
                    {
                        case 0: 
                            styleSetup[0][0] = "-fx-background-color: #" + color.getValue().toString().substring(2, 8) + ";";
                            break;
                            
                        case 1:
                            styleSetup[0][1] = "-fx-text-fill: #" + color.getValue().toString().substring(2, 8) + ";";
                            break;
                            
                        case 2:
                            styleSetup[1][2] = "-fx-background-color: #" + color.getValue().toString().substring(2, 8) + ";";
                            break;
                    }
                    break;
                    
                case 2:
                    
                    //Item Index -> 0 = Pane Color, 1 = Border Color, 2 = Window Color, 3 = Tab Color, 4 = Whatever's Left
                    switch(itemIndex)
                    {
                        case 3: 
                            styleSetup[2][1] = "-fx-border-color: #" + color.getValue().toString().substring(2, 8) + ";";
                            break;
                            
                        default:
                            styleSetup[2][itemIndex] = "-fx-background-color: #" + color.getValue().toString().substring(2, 8) + ";";                
                    }
                    break;      
            }
            
            //Closes ColorStage after User Makes Selection
            colorStage.close();
        });
        //Opens the colorStage and waits until the User Performs an Action to Close
        colorStage.showAndWait();   
        
        //fileWriter() Simply Saves the newly Made styleSetup to the file
        fileWriter();
       }
    
    //Method that Adjusts Text Font and Font Size
    private void textChanger(int itemIndex)
    {
        //Initialization of New Text Stage
        Stage textStage = new Stage();
        
        //GridPane to Hold Confirm Button and Text ComboBox Label
        GridPane textGrid = new GridPane();
        
        //Scene to Hold the GridPane
        Scene textScene = new Scene(textGrid, 400, 300);
        
        //Confirmation Button
        Button confirm = new Button("Confirm");
        
        //ComboBox For Choosing a Text Option
        ComboBox textCombo = new ComboBox();
        
        //Label Declaration
        Label textLabel;
        
        //Initializes the Label Based on Whether the Font is Being Changed (itemIndex = 0) or Font Size is Being Changed (itemIndex = 2)
        if(itemIndex == 0)
            textLabel = new Label("Text Font: ", textCombo);
        
        else
            textLabel = new Label("Text Size: ", textCombo);
        
        //Adjusts Label Positioning
        textLabel.setContentDisplay(ContentDisplay.RIGHT);
        
        //String Arrays for the ObservableArrayLists
        String[] FONTARRAY = {"Times New Roman", "Courier New", "Helvetica", "Arial Black", "Impact" };
        String[] SIZEARRAY = {"Small", "Medium", "Large", "X-Large"};
        
        //Observable Array Lists for ComboBox
        ObservableList FONTOBSERVABLE = FXCollections.observableArrayList(FONTARRAY);
        ObservableList SIZEOBSERVABLE = FXCollections.observableArrayList(SIZEARRAY);
        
        //Adds Observable Array Lists to the ComboBox Based on Whether Font is Being Changed or Font Size is Being Changed
        if(itemIndex == 0)
            textCombo.getItems().addAll(FONTOBSERVABLE);
        
        else if(itemIndex == 2)
            textCombo.getItems().addAll(SIZEOBSERVABLE);
        
        //Adjusts the textGrid Pane
        textGrid.addColumn(0, textLabel);
        textGrid.addColumn(1, confirm);
        textGrid.setPrefSize(400, 300);
        textGrid.setAlignment(Pos.CENTER);
        textGrid.setHgap(40);
        
        //Sets textStage Scene
        textStage.setScene(textScene);
        
        //Sets the textStage title based on whats changing
        if(itemIndex == 0)
            textStage.setTitle("Text Font");
        else
            textStage.setTitle("Text Size");
         
        //When Clicking the Confirm Button, the Information is saved to styleSetup
        confirm.setOnMouseClicked(e ->
        {
            if(itemIndex == 0)
            {
               styleSetup[3][0] = "-fx-font-family: " + textCombo.getValue() + ";";
               textStage.close();
            }
            
            else if(itemIndex == 2)
            {
                styleSetup[3][2] = "-fx-font-size: " + textCombo.getValue() + ";";
                textStage.close();
            }
        });
        
        //textStage stays up until User Inputs their Information
        textStage.showAndWait();
        
        //Writes the new styleSetup Changes to the CSS File
        fileWriter();   
    }
    
    //This Method will handle a file change in the preset settings in the combobox
    private void presetChanger(int itemIndex)
    {
        //Might Do Something With this? I think it was implemented already so idk
        presetChosen = true;
        
        //ItemIndex indicates Which Item in the Observable List is Chosen to be Changed
        switch(itemIndex)
        {
             //If Preset is needed to be Changed This will Write the Change to the File from styleSetup[3][0]
             case 0:
                 try{
                     THEMEPRINTER = new PrintWriter(CSS, "UTF-8");
                     
                     FileInputStream inputStream = new FileInputStream(STANDARDCSS);
                     BufferedInputStream systemFile = new BufferedInputStream(inputStream);
                     
                     int systemInt;
                     
                     String fileString = "";
                     
                     while((systemInt = systemFile.read()) != -1)
                     {
                         fileString += (char)systemInt;
                     }
                     
                     THEMEPRINTER.print(fileString);
                     THEMEPRINTER.close();
                     
                     SETTINGS.getScene().getStylesheets().clear();
                     SETTINGS.getScene().getStylesheets().add("file:///" + CSS.getAbsolutePath().replace("\\", "/"));
                 }
                 catch(Exception e)
                 {
                     System.out.println(e);
                 }
                    
                    break;
                    
             //If Preset is needed to be Changed This will Write the Change to the File from styleSetup[3][1]
             case 1:
                 
                  try{
                     THEMEPRINTER = new PrintWriter(CSS, "UTF-8");
                     
                     FileInputStream inputStream = new FileInputStream(DARKTHEMECSS);
                     BufferedInputStream systemFile = new BufferedInputStream(inputStream);
                     
                     int systemInt;
                     
                     String fileString = "";
                     
                     while((systemInt = systemFile.read()) != -1)
                     {
                         fileString += (char)systemInt;
                     }
                     
                     THEMEPRINTER.print(fileString);
                     THEMEPRINTER.close();
                     
                     SETTINGS.getScene().getStylesheets().clear();
                     SETTINGS.getScene().getStylesheets().add("file:///" + CSS.getAbsolutePath().replace("\\", "/"));
                 }
                 catch(Exception e)
                 {
                     System.out.println(e);
                 }
                    
                    break;
             
             //If Preset is needed to be Changed This will Write the Change to the File from styleSetup[3][2]
             case 2:
                 try{
                     THEMEPRINTER = new PrintWriter(CSS, "UTF-8");
                     
                     FileInputStream inputStream = new FileInputStream(WARMCSS);
                     BufferedInputStream systemFile = new BufferedInputStream(inputStream);
                     
                     int systemInt;
                     
                     String fileString = "";
                     
                     while((systemInt = systemFile.read()) != -1)
                     {
                         fileString += (char)systemInt;
                     }
                     
                     THEMEPRINTER.print(fileString);
                     THEMEPRINTER.close();
                     
                     SETTINGS.getScene().getStylesheets().clear();
                     SETTINGS.getScene().getStylesheets().add("file:///" + CSS.getAbsolutePath().replace("\\", "/"));
                 }
                 catch(Exception e)
                 {
                     System.out.println(e);
                 }
                    
                    break;
             
             //If Preset is needed to be Changed This will Write the Change to the File from styleSetup[3][3]       
             case 3:
                 try{
                     THEMEPRINTER = new PrintWriter(CSS, "UTF-8");
                     
                     FileInputStream inputStream = new FileInputStream(OCEANCSS);
                     BufferedInputStream systemFile = new BufferedInputStream(inputStream);
                     
                     int systemInt;
                     
                     String fileString = "";
                     
                     while((systemInt = systemFile.read()) != -1)
                     {
                         fileString += (char)systemInt;
                     }
                     
                     THEMEPRINTER.print(fileString); 
                     THEMEPRINTER.close();
                     
                     SETTINGS.getScene().getStylesheets().clear();
                     SETTINGS.getScene().getStylesheets().add("file:///" + CSS.getAbsolutePath().replace("\\", "/"));
                 }
                 catch(Exception e)
                 {
                     System.out.println(e);
                 }
                    
                    break;
                    
        }
    }

            /**************************************************************************************************************************************/
            // Section 6: FILE CHANGE METHODS                                                                                                     //
            //     private void fileWriter();                                                                                                     //
            //                                                                                                                                    //
            //                                                                                                                                    //
            /**************************************************************************************************************************************/
    
    //This will rewrite the file at the end of whatever method to ensure that it does not delete itself. 
    //File Printing Scheme is the Exact Same as Everywhere Else
    private void fileWriter()
    {
        try
        {
            //CSS Static File Contents
            String buttonString = "-fx-padding: 10 10 10 10; "
                                + "-fx-vertical-align: middle; "
                                + "-fx-position: absolute;";
                     
            String rootString = "";
            
            String buttonHoverString = "-fx-padding: 10 10 10 10; "
                                     + "-fx-letter-spacing: 2; "
                                     + "-fx-vertical-align: middle; "
                                     + "-fx-position: absolute;";
                     
            String backButtonString = ".BackButton"
                                    + "{\n "
                                    + "-fx-padding: 10 10 10 10; "
                                    + "-fx-position: absolute; "
                                    + "-fx-vertical-align: middle;";
                     
            String backHoverString = ".BackButton:hover"
                                   + "{\n "
                                   + "-fx-padding: 10 10 10 10; "
                                   + "-fx-letter-spacing: 2; "
                                   + "-fx-vertical-align: middle; "
                                   + "-fx-position: absolute; ";
           
            String textString = "";
            
             //Adds the the Final Theme Changes to the Strings that will be Printed to the CSS File If there is anything in them (i.e. if they aren't null)
            for(int row = 0; row < styleSetup.length; row++)
                for(int column = 0; column < styleSetup[row].length; column++)
                {
                    if(row == 0 && styleSetup[row][column] != null)
                        buttonString += styleSetup[row][column] + "\n";
            
                    else if(row == 1 && styleSetup[row][column] != null)
                        buttonHoverString += styleSetup[row][column] + "\n";
                    
                    else if(row == 2 && styleSetup[row][column] != null)
                        rootString += styleSetup[row][column] + "\n";
                    
                    else if(row == 3 && styleSetup[row][column] != null)
                        textString += styleSetup[row][column] + "\n";         
                }
           
            //PrintWriter for CSS file
            THEMEPRINTER = new PrintWriter(CSS, "UTF-8");

            //String that Will be Written to the File
            String totalString = prevStyleSetup;

            //Formats and Adds to the totalString to build the CSS File
            if(buttonString != null)
                totalString += ".Button{\n " + buttonString + "\n}\n";
            if(buttonHoverString != null)
                totalString += ".Button:hover{\n " + buttonHoverString + "\n}\n";
            if(rootString != null)
                totalString += ".root{\n" + rootString + "\n}\n";
            if(buttonString != null)
                totalString += backHoverString + "\n}\n";
            if(buttonString != null)
                totalString += backButtonString + "\n}\n";
            if(textString != null)
                totalString += ".Text{\n " + textString + "\n}\n";
            
            //Prints the totalString to the CSS File
            THEMEPRINTER.print(totalString);
            
            //Closes and Saves the File as Well as the PrintWriter
            THEMEPRINTER.close();            
    
            //Clears the Current Style Sheet Setup
            SETTINGS.getScene().getStylesheets().clear();
            
            //Implements the New Style Sheet From the Changed File
            SETTINGS.getScene().getStylesheets().add("file:///" + CSS.getAbsolutePath().replace("\\", "/"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
                
    }
    
            /**************************************************************************************************************************************/
            // Section 7: EVENTHANDLERS AND GLOBAL HOT KEYS                                                                                       //
            //     private void eventHandlerKeyEventButtonPress(Button button);                                                                   //
            //     private void eventHandlerKeyEventBackArrow();                                                                                  //               
            //     private void quickEscape(Stage CURRENTSTAGE);                                                                                  //      
            //                                                                                                                                    //
            /**************************************************************************************************************************************/
     //Button Press Action Event Handler
    private void eventHandlerKeyEventButtonPress(Button button)
    {   
        //Button Click Action Based Off SceneMap
        button.setOnMouseClicked(e -> 
        {
            //Switch That Will Retrieve A Scene Based Off the Buttons Name (I.E. ABOUT BUTTON CLICK WILL RETURN ABOUT SCENE USING THE "about()" METHOD)
            switch((int)SCENEMAP.get(button.getText()))
            {
                case 2:
                        about();
                        break;
                        
                case 3:
                        resolution();
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
                
                //Returns to the Settings Scene From the Resolution Scene
                case 3:
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
    
    //This Should Allow for the User to Exit Settings at Anytime by Pressing the Escape Key, if the User is in Theme then 
    //affirmationTheme() will Run to Change the Saved Appearance Before the Settings Closes
    private void quickEscape(Stage CURRENTSTAGE)
    {
        CURRENTSTAGE.getScene().setOnKeyPressed(e ->
        {
                switch(e.getCode())
                {
                    case ESCAPE: 
                                if(CURRENTSTAGE.getTitle().equalsIgnoreCase("THEME") || CURRENTSTAGE.getTitle().equalsIgnoreCase("RESOLUTION"))
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

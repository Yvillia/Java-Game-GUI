package clientv03;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login {
    
    //Initialization of TextField For User Input
    private static final TextField LOGINUSERNAME = new TextField ();
    private static final PasswordField LOGINPASSWORD = new PasswordField ();
    
    //Initialization of CurrentStage
    private static Stage current;
    
    //Initialization of Player's name
    private static String playerName;

    //Initialization of scene sizes
    private static final double LOGINSCREENWIDTH = 350;
    private static final double LOGINSCREENHEIGHT = 150;
    
   
    //Login Screen Constructor
    Login(Stage currentStage){
        
        current = currentStage;
        Scene LOGINSCREEN = loginScreen();
        current.setScene(LOGINSCREEN);
        current.show();
    }
    
    //This Method Initializes the entire login screen
    private static final Scene loginScreen()
    {
        //Initialization of Visual Items
        final GridPane LOGINGRID =  new GridPane();
        final SplitPane USERNAME = new SplitPane();
        final SplitPane PASSWORD = new SplitPane();
        final StackPane LOGINPANE = new StackPane();
        final Button LOGINBUTTON = new Button();
        final Text USERNAMETEXT = new Text();
        final Text PASSWORDTEXT = new Text();
        final Text LOGINERRORTEXT = new Text();
        
        //Initialization of constants
        final double HEIGHTMAININPUTAREA = 30;
        
        //Initialization of Login buttons
        LOGINBUTTON.setText("Login");
        LOGINBUTTON.setMaxWidth(100);
        LOGINBUTTON.prefWidthProperty().bind(LOGINPANE.widthProperty());
        LOGINBUTTON.setFont(Font.font(null, FontWeight.MEDIUM, 15));
        
        //Initialization of Username area of login
        LOGINUSERNAME.setPrefHeight(HEIGHTMAININPUTAREA);
        LOGINUSERNAME.setMaxWidth(250);
        LOGINUSERNAME.prefWidthProperty().bind(LOGINPANE.widthProperty());
        USERNAMETEXT.setText("Username ");
        USERNAMETEXT.setFont(Font.font(null, FontWeight.MEDIUM, 25));
        USERNAME.getItems().addAll(USERNAMETEXT, LOGINUSERNAME);
        USERNAME.setPadding((new Insets(0, 10, 0, 10)));
        
        //Initialization of Password area of login
        LOGINPASSWORD.setPrefHeight(HEIGHTMAININPUTAREA);
        LOGINPASSWORD.setMaxWidth(250);
        LOGINPASSWORD.prefWidthProperty().bind(LOGINPANE.widthProperty());
        PASSWORDTEXT.setText("Password  ");
        PASSWORDTEXT.setFont(Font.font(null, FontWeight.MEDIUM, 25));
        PASSWORD.getItems().addAll(PASSWORDTEXT, LOGINPASSWORD);
        PASSWORD.setPadding((new Insets(0, 10, 0, 10)));
        
        //Initialization of Login Error message
        LOGINERRORTEXT.setText(" ");
        LOGINERRORTEXT.setFont(Font.font(null, FontWeight.MEDIUM, 15));
        
        //Grid and Pane Build
        LOGINGRID.addRow(0, LOGINERRORTEXT);
        LOGINGRID.addRow(1, USERNAME);
        LOGINGRID.addRow(2, PASSWORD);
        LOGINGRID.addRow(4, LOGINBUTTON);
        LOGINGRID.setHalignment(LOGINERRORTEXT, HPos.CENTER);
        LOGINGRID.setHalignment(LOGINBUTTON, HPos.CENTER);
        LOGINGRID.setVgap(4);
        LOGINPANE.getChildren().add(LOGINGRID);
        
        //Event Handler for Buttons
        eventHandlerKeyEventListenersLoginScreen(LOGINBUTTON, LOGINERRORTEXT);
        
        return new Scene(LOGINPANE, LOGINSCREENWIDTH, LOGINSCREENHEIGHT);
        
    }
    
     //This method chances the login screen into the next scence once successful
    //login has occurred
    private static void login(Text errorText)
    {
        if(!(LOGINUSERNAME.getText().equalsIgnoreCase("")) && (!(LOGINPASSWORD.getText().equalsIgnoreCase(""))))
        {
            playerName = LOGINUSERNAME.getText();
            current.hide();
            GameInterface gameInterface = new GameInterface(current);

        }
        else
            errorText.setText("Username and Password Required");
    }
        
        
         //This Method Initializes All of The login screen Key Event Listeners
    private static void eventHandlerKeyEventListenersLoginScreen(Button button, Text errorText)
    {
        button.setOnMouseClicked(e->
        {
                if(button.getText().equalsIgnoreCase("Login")) 
                {
                    login(errorText);
                }
        });
        
        button.setOnKeyPressed(e->
        {
                if (e.getCode() == KeyCode.ENTER)
                {
                    login(errorText);
                }
        });
        
        LOGINUSERNAME.setOnKeyPressed(e->
        {
                if (e.getCode() == KeyCode.ENTER)
                {
                        LOGINPASSWORD.requestFocus();
                        LOGINPASSWORD.selectAll();
                }
        });
        
        LOGINPASSWORD.setOnKeyPressed(e->
        {
                if (e.getCode() == KeyCode.ENTER)
                {
                    login(errorText);
                }
        });
    }     
}    
    

package clientv04;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GameInterface {
       
    //Initialization of TextAreas For The Chat And Game
    private static final TextArea DIALOGUEAREA = new TextArea();
    private static final TextArea CHATAREA = new TextArea();
    
    //Initialization of TextField For User Input
    private static final TextField MAININPUTAREA =  new TextField ();

    //Initialization of tabs
    private static final TabPane TABPANE = new TabPane();
    
    //Initialization of VBoxes
    private static final VBox INVENTORY = new VBox();
    private static final VBox QUEST = new VBox();
    private static final VBox TARGET = new VBox();
    private static final VBox COOLDOWN = new VBox();
    private static final VBox FRIENDS = new VBox();
    private static final VBox GUILD = new VBox();
    private static final VBox MASTERIES = new VBox();
    
    //Intialization of Buttons
    private static final Button BUTTON1 =  new Button();
    private static final Button BUTTON2 =  new Button();
    private static final Button BUTTON3 =  new Button();
    private static final Button BUTTON4 =  new Button();
    private static final Button BUTTON5 =  new Button();
    private static final Button BUTTON6 =  new Button();
    private static final Button BUTTON7 =  new Button();
    private static final Button BUTTON8 =  new Button();
    private static final Button BUTTON9 =  new Button();
    private static final Button BUTTON10 =  new Button();
    
    //Initialization of Filler Text and Minimap
    private static final Text REGIONNAME = new Text();
    private static final Text CHARACTERNAME = new Text();
    private static final Text CHARCTERLEVEL = new Text();
    private static final Text CHARCTERRACE = new Text();
    private static final Text CHARCTERCLASS = new Text();
    private static final VBox MINIMAP = new VBox();
    private static final HBox BUFFS = new HBox();
    
    //Initialization of Health & Mana Bars
    private static final ProgressBar HEALTHBAR = new ProgressBar(1);
    private static final ProgressBar MANABAR = new ProgressBar(1);
    private static final ProgressBar EXPBAR = new ProgressBar(1);
    
    //Initialization of scene sizes
    private static final double GAMEINTERFACEHEIGHT = 500;
    private static final double GAMEINTERFACEWIDTH = 800;
    
    //Initialization of Player's name
    private static String playerName;
    
    //Text File Read-in 
    private static final String FONTSIZEGENERAL = "-fx-font-size: 18;";
    private static final String FONTSIZESMALL = "-fx-font-size: 10;";
    private static final String CHATSTYLE = "-fx-focus-color: transparent; -fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ffff";
    private static final String MAININPUTSTYLE = "-fx-focus-color: transparent; ";
    
    //Initialization of Past input
    private static String [] lastText = new String[0];
    private static int currentLastTextIndex = 0;
    private static boolean currentlyIndexing = false;        
    
    //Initialization of CurrentStage and Scene
    private static Stage current;
    private static final Scene CURRENTSCENE = gameInterface();
    
    GameInterface(Stage currentStage)
    {
        
        current = currentStage;
        current.setScene(CURRENTSCENE);
        current.setMinWidth(GAMEINTERFACEWIDTH);
        current.setMinHeight(GAMEINTERFACEHEIGHT);
        current.setResizable(true);
        current.show();
        eventHandlerKeyEventListenersGameInterface();
        
    }
    
     //This Method Initializes the entire game interface
    private static final Scene gameInterface()
    {
        //Initialization of Visual Items
        final GridPane grid =  new GridPane();
        final StackPane pane = new StackPane();
        final VBox rightSide = new VBox();
        final BorderPane borderPane = new BorderPane();
        final VBox upperLeft = new VBox();
        final VBox upperRight = new VBox();
        final VBox upperRightSide =  new VBox();
        final VBox targetAreaPane = new VBox();
        final VBox cooldownAreaPane = new VBox();
        final GridPane gridInner =  new GridPane();
        final VBox leftSide = new VBox();
        final SplitPane resourceSplit = new SplitPane();
        
        //Initialization of Constants
        final double MAXWIDTHBORDERPANE = 300;
        final double MAXHEIGHTCHATAREA = 400;
        final double HEIGHTMAININPUTAREA = 20;
        final double HEIGHTRESOURCEAREA = 20;
        final double SQUARENUMBER = 50;
        
        //Initialization Inventory Quest and Content
        Tab characterTab = new Tab();
        HBox character = new HBox();
        character.getChildren().add(characterGrid(character));
        character.setAlignment(Pos.TOP_CENTER);
        characterTab.setContent(character);
        characterTab.setStyle("-fx-focus-color: transparent; ");
        characterTab.setText("Character");
        TABPANE.getTabs().add(characterTab);
        characterTab.setClosable(false);
        
        //Initialization Inventory Tab and Content
        Tab inventoryTab = new Tab();
        INVENTORY.getChildren().add(new Label("Inventory"));
        INVENTORY.setAlignment(Pos.TOP_CENTER);
        inventoryTab.setContent(INVENTORY);
        inventoryTab.setStyle("-fx-focus-color: transparent; ");
        inventoryTab.setText("Inventory");
        TABPANE.getTabs().add(inventoryTab);
        inventoryTab.setClosable(false);
        
        //Initialization Inventory Quest and Content
        Tab questTab = new Tab();
        QUEST.getChildren().add(new Label("Quest"));
        QUEST.setAlignment(Pos.TOP_CENTER);
        questTab.setContent(QUEST);
        questTab.setStyle("-fx-focus-color: transparent; ");
        questTab.setText("Quest");
        TABPANE.getTabs().add(questTab);
        questTab.setClosable(false);
                
        //Initialization Inventory Quest and Content
        Tab masteriesTab = new Tab();
        MASTERIES.getChildren().add(new Label("Masteries"));
        MASTERIES.setAlignment(Pos.TOP_CENTER);
        masteriesTab.setContent(MASTERIES);
        masteriesTab.setStyle("-fx-focus-color: transparent; ");
        masteriesTab.setText("Masteries");
        TABPANE.getTabs().add(masteriesTab);
        masteriesTab.setClosable(false);
        
       //Initialization Social Tab and Content
        final Tab GuildTab = new Tab();
        final VBox social = new VBox();
        final Text friendsTitle = new Text("Friends List");
        final Text guildTitle = new Text("Guild");
        final VBox friendsFiller = new VBox();
        final VBox guildFiller = new VBox();
        friendsFiller.getChildren().add(new Label("No Friends"));
        guildFiller.getChildren().add(new Label("No Guild"));
        guildTitle.setStyle(FONTSIZEGENERAL);
        friendsTitle.setStyle(FONTSIZEGENERAL);
        friendsFiller.setStyle("-fx-border-style: solid none none none; -fx-border-width: 1; "
                + "-fx-border-insets: -2; -fx-border-radius: 5; -fx-border-color: black;");
        guildFiller.setStyle("-fx-border-style: solid none none none; -fx-border-width: 1; "
                + "-fx-border-insets: -2; -fx-border-radius: 5; -fx-border-color: black;");
        FRIENDS.setStyle("-fx-border-style: solid inside; -fx-border-width: 1; "
                + "-fx-border-insets: 1; -fx-border-radius: 5; -fx-border-color: black;");
        FRIENDS.prefHeightProperty().bind(social.heightProperty());
        FRIENDS.prefWidthProperty().bind(social.widthProperty());
        FRIENDS.getChildren().addAll(friendsTitle, friendsFiller);
        GUILD.setStyle("-fx-border-style: solid inside; -fx-border-width: 1; "
                + "-fx-border-insets: 1; -fx-border-radius: 5; -fx-border-color: black;");
        GUILD.prefHeightProperty().bind(social.heightProperty());
        GUILD.prefWidthProperty().bind(social.widthProperty());
        GUILD.getChildren().addAll(guildTitle, guildFiller);
        social.getChildren().addAll(FRIENDS, GUILD);
        social.setAlignment(Pos.TOP_CENTER);
        GuildTab.setContent(social);
        GuildTab.setStyle("-fx-focus-color: transparent; ");
        GuildTab.setText("Social");
        TABPANE.getTabs().add(GuildTab);
        GuildTab.setClosable(false);
              
        //Initialization Target Area
        Text targetArea = new Text("Target Area");
        TARGET.getChildren().add(new Label("Creature 1"));
        TARGET.getChildren().add(new Label("Creature 2"));
        TARGET.getChildren().add(new Label("Creature 3"));
        TARGET.getChildren().add(new Label("Player 1"));
        TARGET.getChildren().add(new Label("Player 2"));
        TARGET.getChildren().add(new Label("Player 3"));
        TARGET.setStyle("-fx-border-style: solid none none none; -fx-border-width: 1; "
                + "-fx-border-insets: -2; -fx-border-radius: 5; -fx-border-color: black;");
        TARGET.setAlignment(Pos.TOP_LEFT);
        targetArea.setStyle(FONTSIZEGENERAL);
        targetAreaPane.getChildren().addAll(targetArea,TARGET);
        targetAreaPane.setMinWidth(200);
        targetAreaPane.prefHeightProperty().bind(upperRight.heightProperty());
        targetAreaPane.prefWidthProperty().bind(upperRight.widthProperty());
        targetAreaPane.setStyle("-fx-border-style: solid inside;" +
                     "-fx-border-width: 1;" + "-fx-border-insets: 1;" + "-fx-border-radius: 5;" +
                     "-fx-border-color: black;");

        //Initialization Target Area
        Text cooldownArea = new Text("Cooldown Area");
        COOLDOWN.setAlignment(Pos.TOP_LEFT);
        COOLDOWN.getChildren().add(new Label("Skill 1 10 Seconds"));
        COOLDOWN.setStyle("-fx-border-style: solid none none none; -fx-border-width: 1; "
                + "-fx-border-insets: -2; -fx-border-radius: 5; -fx-border-color: black;");
        cooldownArea.setStyle(FONTSIZEGENERAL);
        cooldownArea.setTextAlignment(TextAlignment.CENTER);
        cooldownAreaPane.getChildren().addAll(cooldownArea,COOLDOWN);
        cooldownAreaPane.setMinWidth(200);
        cooldownAreaPane.prefHeightProperty().bind(upperRight.heightProperty());
        cooldownAreaPane.prefWidthProperty().bind(upperRight.widthProperty());
        cooldownAreaPane.setStyle("-fx-border-style: solid inside; -fx-border-width: 1; "
                + "-fx-border-insets: 1; -fx-border-radius: 5; -fx-border-color: black;");

        //Initialization skill hotbar
        HBox skillHotbar = new HBox();
        
        //Button Names
        BUTTON1.setText("1");
        BUTTON2.setText("2");
        BUTTON3.setText("3");
        BUTTON4.setText("4");
        BUTTON5.setText("5");
        BUTTON6.setText("6");
        BUTTON7.setText("7");
        BUTTON8.setText("8");
        BUTTON9.setText("9");
        BUTTON10.setText("10");
        
        //Button Size
        BUTTON1.setMaxWidth(SQUARENUMBER);
        BUTTON1.prefHeightProperty().bind(pane.heightProperty());
        BUTTON1.prefWidthProperty().bind(pane.widthProperty());
        BUTTON2.setMaxWidth(SQUARENUMBER);
        BUTTON2.prefHeightProperty().bind(pane.heightProperty());
        BUTTON2.prefWidthProperty().bind(pane.widthProperty());
        BUTTON3.setMaxWidth(SQUARENUMBER);
        BUTTON3.prefHeightProperty().bind(pane.heightProperty());
        BUTTON3.prefWidthProperty().bind(pane.widthProperty());
        BUTTON4.setMaxWidth(SQUARENUMBER);
        BUTTON4.prefHeightProperty().bind(pane.heightProperty());
        BUTTON4.prefWidthProperty().bind(pane.widthProperty());
        BUTTON5.setMaxWidth(SQUARENUMBER);
        BUTTON5.prefHeightProperty().bind(pane.heightProperty());
        BUTTON5.prefWidthProperty().bind(pane.widthProperty());
        BUTTON6.setMaxWidth(SQUARENUMBER);
        BUTTON6.prefHeightProperty().bind(pane.heightProperty());
        BUTTON6.prefWidthProperty().bind(pane.widthProperty());
        BUTTON7.setMaxWidth(SQUARENUMBER);
        BUTTON7.prefHeightProperty().bind(pane.heightProperty());
        BUTTON7.prefWidthProperty().bind(pane.widthProperty());
        BUTTON8.setMaxWidth(SQUARENUMBER);
        BUTTON8.prefHeightProperty().bind(pane.heightProperty());
        BUTTON8.prefWidthProperty().bind(pane.widthProperty());
        BUTTON9.setMaxWidth(SQUARENUMBER);
        BUTTON9.prefHeightProperty().bind(pane.heightProperty());
        BUTTON9.prefWidthProperty().bind(pane.widthProperty());
        BUTTON10.setMaxWidth(SQUARENUMBER);
        BUTTON10.prefHeightProperty().bind(pane.heightProperty());
        BUTTON10.prefWidthProperty().bind(pane.widthProperty());
        
        //Hotbar Size
        skillHotbar.setMaxHeight(SQUARENUMBER);
        skillHotbar.prefHeightProperty().bind(pane.heightProperty());
        skillHotbar.prefWidthProperty().bind(pane.widthProperty());
        skillHotbar.setAlignment(Pos.CENTER);
        skillHotbar.getChildren().addAll(BUTTON1, BUTTON2, BUTTON3, BUTTON4, BUTTON5, BUTTON6, BUTTON7, BUTTON8, BUTTON9, BUTTON10); 
        
        //Initialization of Entire Right Side of the Window
        borderPane.setCenter(TABPANE);
        borderPane.prefHeightProperty().bind(rightSide.heightProperty());
        borderPane.prefWidthProperty().bind(rightSide.widthProperty());
        borderPane.setMaxWidth(MAXWIDTHBORDERPANE);
        
        //Initialization of MiniMap and Region Name Visual Appearance
        REGIONNAME.setText("Region Name");
        REGIONNAME.setStyle(FONTSIZEGENERAL);
        MINIMAP.setStyle("-fx-border-style: solid inside; -fx-border-width: 1; "
                + "-fx-border-insets: 1; -fx-border-radius: 180; -fx-border-color: black;");
        MINIMAP.prefHeightProperty().bind(upperRightSide.heightProperty());
        MINIMAP.prefWidthProperty().bind(upperRightSide.widthProperty());
        MINIMAP.setMaxHeight(MAXWIDTHBORDERPANE/2);
        MINIMAP.setMaxWidth(MAXWIDTHBORDERPANE/2);
        
        //Implementation of Minimap and Region Name
        upperRightSide.setAlignment(Pos.CENTER);
        upperRightSide.getChildren().addAll(REGIONNAME, MINIMAP);
        upperRightSide.prefHeightProperty().bind(rightSide.heightProperty());
        upperRightSide.prefWidthProperty().bind(rightSide.widthProperty());
        upperRightSide.setMaxHeight(MAXWIDTHBORDERPANE);
        upperRightSide.setMaxWidth(MAXWIDTHBORDERPANE);
        upperRightSide.setStyle("-fx-border-style: solid inside; -fx-border-width: 1; "
                + "-fx-border-insets: 1; -fx-border-radius: 0; -fx-border-color: black;");
        
        //Initialization of Health Bar
        HEALTHBAR.prefHeight(HEIGHTRESOURCEAREA);
        HEALTHBAR.prefWidthProperty().bind(pane.widthProperty());
        HEALTHBAR.setStyle("-fx-accent: red;");
        
        //Initialization of Exp Bar
        EXPBAR.prefHeight(HEIGHTRESOURCEAREA);
        EXPBAR.prefWidthProperty().bind(pane.widthProperty());
        EXPBAR.setStyle("-fx-accent: yellow;");
        
        //Initialization of Mana Bar
        MANABAR.setPrefHeight(HEIGHTRESOURCEAREA);
        MANABAR.prefWidthProperty().bind(pane.widthProperty());
        
        //Initialization of Main Text Area For Game Information To Be Output
        DIALOGUEAREA.prefHeightProperty().bind(pane.heightProperty());
        DIALOGUEAREA.prefWidthProperty().bind(pane.widthProperty());
        DIALOGUEAREA.setWrapText(true);
        DIALOGUEAREA.setEditable(false);
        DIALOGUEAREA.setStyle("-fx-focus-color: transparent; -fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ffff");
        
        //Initialization of the Input Area For the Users Input
        MAININPUTAREA.setPrefHeight(HEIGHTMAININPUTAREA);
        MAININPUTAREA.prefWidthProperty().bind(pane.widthProperty());
        MAININPUTAREA.setStyle(MAININPUTSTYLE);
        
        //Initialization of Main Text Area For User Chat System To Be Output
        CHATAREA.setMaxHeight(MAXHEIGHTCHATAREA);
        CHATAREA.prefWidthProperty().bind(pane.widthProperty());
        CHATAREA.prefHeightProperty().bind(pane.heightProperty());
        CHATAREA.setWrapText(true);
        CHATAREA.setEditable(false);
        CHATAREA.setStyle(CHATSTYLE);
        
        //Initialization of the Row Where Health Bar and Mana Bar are Located
        resourceSplit.getItems().addAll(HEALTHBAR, MANABAR);
        
        //Initialization of Entire Left Side of the Window
        upperLeft.getChildren().addAll(DIALOGUEAREA,skillHotbar);
        upperRight.getChildren().addAll(targetAreaPane,cooldownAreaPane);
        upperRight.prefWidthProperty().bind(gridInner.widthProperty());
        upperRight.prefHeightProperty().bind(gridInner.heightProperty());
        gridInner.addColumn(0, upperLeft);
        gridInner.addColumn(1, upperRight);
        leftSide.getChildren().addAll(gridInner, CHATAREA, resourceSplit, EXPBAR, MAININPUTAREA);
        rightSide.getChildren().addAll(upperRightSide, borderPane);
        rightSide.prefHeightProperty().bind(pane.heightProperty());
        rightSide.prefWidthProperty().bind(pane.widthProperty());
        rightSide.setMinWidth(MAXWIDTHBORDERPANE);
        
        //Initialization of Grid Where the Left and Right Side Come Together
        grid.addColumn(0, leftSide);
        grid.addColumn(1, rightSide);
        
        //Initialization of the scene
        pane.getChildren().add(grid);
        return new Scene(pane, GAMEINTERFACEWIDTH, GAMEINTERFACEHEIGHT);
    }
    
    private static final GridPane characterGrid(HBox character)
    {
        //Initialization of Character Information
        CHARACTERNAME.setText("Bob");
        CHARACTERNAME.setStyle(FONTSIZEGENERAL);
        CHARCTERLEVEL.setText("Level: 20/1/2");
        CHARCTERLEVEL.setStyle(FONTSIZEGENERAL);
        CHARCTERRACE.setText("Human");
        CHARCTERRACE.setStyle(FONTSIZEGENERAL);
        CHARCTERCLASS.setText("Mage/Fighter/Rogue");
        CHARCTERCLASS.setStyle(FONTSIZEGENERAL);
        
        //Initialization of Character Active Effects
        Text activeEffectsTitle = new Text("Active Effects");
        activeEffectsTitle.setStyle(FONTSIZEGENERAL);
        Button testButton = new Button();
        testButton.setText("25");
        testButton.setStyle(FONTSIZESMALL);
        testButton.setPrefWidth(25);
        BUFFS.getChildren().add(testButton);
        BUFFS.setPrefHeight(25);
        BUFFS.prefWidthProperty().bind(character.widthProperty());
        
        //Initialization of Character Stats
        Text statsTitle = new Text("Stats");
        statsTitle.setStyle(FONTSIZEGENERAL);
        
        //STRENGTH
            Text STR = new Text("STR:");
            STR.setStyle(FONTSIZEGENERAL);
            Text STRVALUE = new Text(" 22");
            STRVALUE.setStyle(FONTSIZEGENERAL);
        
        //DEXTERITY
            Text DEX = new Text("DEX:");
            DEX.setStyle(FONTSIZEGENERAL);
            Text DEXVALUE = new Text(" 22");
            DEXVALUE.setStyle(FONTSIZEGENERAL);
        
        //CONSTITUTION
            Text CON = new Text("CON:");
            CON.setStyle(FONTSIZEGENERAL);
            Text CONVALUE = new Text(" 22");
            CONVALUE.setStyle(FONTSIZEGENERAL);
        
        //INTELLECT
            Text INT = new Text("INT:");
            INT.setStyle(FONTSIZEGENERAL);
            Text INTVALUE = new Text(" 22");
            INTVALUE.setStyle(FONTSIZEGENERAL);
        
        //WISDOM
            Text WIS = new Text("WIS:");
            WIS.setStyle(FONTSIZEGENERAL);
            Text WISVALUE = new Text(" 22");
            WISVALUE.setStyle(FONTSIZEGENERAL);
        
        //CHARISMA
            Text CHA = new Text("CHA:");
            CHA.setStyle(FONTSIZEGENERAL);
            Text CHAVALUE = new Text(" 22");
            CHAVALUE.setStyle(FONTSIZEGENERAL);
        
        //Character Information Build
        HBox rowTwo = new HBox();
        rowTwo.getChildren().addAll(CHARCTERLEVEL, CHARCTERRACE);
        rowTwo.prefWidthProperty().bind(character.widthProperty());
        rowTwo.setSpacing(100);
        HBox statsRowOne = new HBox();
        statsRowOne.getChildren().addAll(STR, STRVALUE, DEX, DEXVALUE, CON, CONVALUE);
        statsRowOne.setSpacing(25);
        statsRowOne.prefWidthProperty().bind(character.widthProperty());
        HBox statsRowTwo =  new HBox();
        statsRowTwo.getChildren().addAll(INT, INTVALUE, WIS, WISVALUE, CHA, CHAVALUE);
        statsRowTwo.setSpacing(25);
        statsRowTwo.prefWidthProperty().bind(character.widthProperty());
        
        //Character Grid Build and Adjustment
        GridPane characterGrid = new GridPane();
        characterGrid.addRow(0, CHARACTERNAME);
        characterGrid.addRow(1, rowTwo);
        characterGrid.addRow(2, CHARCTERCLASS);
        characterGrid.addRow(3, activeEffectsTitle);
        characterGrid.addRow(4, BUFFS);
        characterGrid.addRow(5, statsTitle);
        characterGrid.addRow(6, statsRowOne);
        characterGrid.addRow(7, statsRowTwo);
        characterGrid.setPadding(new Insets(10, 20, 10, 20)); 
        
        //Return Newly Built Character Grid
        return characterGrid;
    }
    
   private static void eventHandlerKeyEventListenersGameInterface()
    {
        //Input text area on key press event handlers
        MAININPUTAREA.setOnKeyPressed(e->
        {
                switch(e.getCode())
                {
                    case ENTER:
                            String command = MAININPUTAREA.getText();
                            MAININPUTAREA.setText("");
                            if(!(command.equalsIgnoreCase("")))
                            {
                                MAININPUTAREA.requestFocus();
                                addToLastText(command);
                                currentlyIndexing = false;
                                CHATAREA.appendText(playerName + ":" + command + "\n");
                            }
                            else
                               CHATAREA.requestFocus();
                    break;
                    
                    case UP:
                            if(currentLastTextIndex >= 0 && lastText.length > 0)
                            {
                                MAININPUTAREA.setText(lastText[currentLastTextIndex]);
                                if(currentLastTextIndex > 0 && currentlyIndexing)
                                   currentLastTextIndex --;
                                currentlyIndexing = true; 
                            }
                    break;
                    
                    case DOWN:
                            if(currentLastTextIndex < lastText.length && lastText.length > 0 && currentlyIndexing)
                            {
                                MAININPUTAREA.setText(lastText[currentLastTextIndex]);
                                if(currentLastTextIndex < lastText.length - 1)
                                   currentLastTextIndex ++;
                            }
                    break;
                    
                    case BACK_SPACE:
                            currentlyIndexing = false;
                    break;
                    
                    case ESCAPE:
                            Settings settings = new Settings(current);
                    break;
                    
                }
            });
        
        //In game event text area on key press event handlers
        DIALOGUEAREA.setOnKeyPressed(globalHotkeys());
        
        //Global Key Press Event Handlers
        CHATAREA.setOnKeyPressed(globalHotkeys());
        TARGET.setOnKeyPressed(globalHotkeys());
        COOLDOWN.setOnKeyPressed(globalHotkeys());
        INVENTORY.setOnKeyPressed(globalHotkeys());
        FRIENDS.setOnKeyPressed(globalHotkeys());
        MASTERIES.setOnKeyPressed(globalHotkeys());
        QUEST.setOnKeyPressed(globalHotkeys());
        GUILD.setOnKeyPressed(globalHotkeys());
        HEALTHBAR.setOnKeyPressed(globalHotkeys());
        MANABAR.setOnKeyPressed(globalHotkeys());
        EXPBAR.setOnKeyPressed(globalHotkeys());
        TABPANE.setOnKeyPressed(globalHotkeys());
        BUTTON1.setOnKeyPressed(globalHotkeys());
        BUTTON2.setOnKeyPressed(globalHotkeys());
        BUTTON3.setOnKeyPressed(globalHotkeys());
        BUTTON4.setOnKeyPressed(globalHotkeys());
        BUTTON5.setOnKeyPressed(globalHotkeys());
        BUTTON6.setOnKeyPressed(globalHotkeys());
        BUTTON7.setOnKeyPressed(globalHotkeys());
        BUTTON8.setOnKeyPressed(globalHotkeys());
        BUTTON9.setOnKeyPressed(globalHotkeys());
        BUTTON10.setOnKeyPressed(globalHotkeys());
     
    }
    
    //This method add text into the array of past text if its not part of the current list
    private static void addToLastText(String command)
    {
        boolean existText = false;
        for(int indexLastText = 0; indexLastText < lastText.length; indexLastText++)
        {
            if(lastText[indexLastText].equalsIgnoreCase(command))
                existText = true;
        }
        if(!existText)
        {
            String []newLastText = new String[lastText.length + 1];
            for(int indexLastText = 0; indexLastText < lastText.length; indexLastText++)
                newLastText[indexLastText] = lastText[indexLastText];
            newLastText[lastText.length] = command;
            lastText = newLastText;
            currentLastTextIndex = lastText.length - 1;
        }
    }
      
      private static EventHandler<KeyEvent> globalHotkeys()
    {
        return (KeyEvent keyEvent) -> {
            switch(keyEvent.getCode()) 
            {
                case ENTER:
                    MAININPUTAREA.requestFocus();
                    MAININPUTAREA.selectAll();
                    break;
                    
                case C:
                    TABPANE.getSelectionModel().select(0);
                    break;
                    
                case I:
                    TABPANE.getSelectionModel().select(1);
                    break;
                    
                case Q:
                    TABPANE.getSelectionModel().select(2);
                    break;
                    
                case M:
                    TABPANE.getSelectionModel().select(3);
                    break;
                    
                case S:
                    TABPANE.getSelectionModel().select(4);
                    break;
                    
                case ESCAPE:
                    Settings settings = new Settings(current);
                    break;
            }
        };
    }    
}

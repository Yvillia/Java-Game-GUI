package clientv03;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Effect 
{
    //Initialization of the Effect button
    private final Button EFFECTICON = new Button();
    
    //Initialization of Effect's Starting Timestamp
    private final long STARTINGTIME;
    
    //Initialization of the Effect Duration
    private final long DURATION;
    
    //Initialization of the Time Remaining on the Effect
    private long secondsRemaining;
    
    //Initialization of What the Effect is
    private final String EFFECT;
    
    //Tell Whether the Effect is Removable
    private final boolean REMOVEABLE;
    
    Effect(final String ICONLOCATION, final long STARTINGTIME, final long DURATION,
            final String EFFECT, final boolean REMOVEABLE,  final HBox EFFECTSCONTAINER)
    {
        this.secondsRemaining = DURATION/1000;
        this.DURATION = DURATION;
        this.EFFECT = EFFECT;
        this.STARTINGTIME = STARTINGTIME;
        this.REMOVEABLE = REMOVEABLE;
        
        //Sets the Text on the Button to the Seconds Remaining on the Effect
        EFFECTICON.setText(Long.toString(secondsRemaining));
        
        //Sets the Size of the Text on the Button
        EFFECTICON.setStyle("-fx-font-size: 10;");
        
        //Sets the Width of the Button
        EFFECTICON.setPrefWidth(25);
        
        //Adds the Button to the Effects Container
        EFFECTSCONTAINER.getChildren().add(EFFECTICON);
        
        //Runs the Effect Timer
        effectTimer(EFFECTSCONTAINER);
    }
    
    //This Method Initializatizes the Effect Timer Which Updates Every 1000 Milliseconds (1 seconds)
    private void effectTimer(final HBox EFFECTSCONTAINER)
    {
        final Timer effectTimer  = new Timer();
                
        final TimerTask effect = new TimerTask(){
            @Override
            public void run() 
            {
                if((System.currentTimeMillis() - STARTINGTIME) < DURATION)
                {
                    //This updates the current seconds displayed on the effect
                    Platform.runLater(new Runnable() {                          
                        @Override public void run() {
                            secondsRemaining = (DURATION - (System.currentTimeMillis() -  STARTINGTIME))/1000;
                            
                            //Sets the Text on the Button to the Seconds Remaining on the Effect
                            EFFECTICON.setText(Long.toString(secondsRemaining + 1));
                        }
                    });
                }
                else
                {
                    //This Removes the Effect from the Buffcontainer as well as ends the EffectTimer When Duration Runs Out
                    Platform.runLater(new Runnable() 
                    {                          
                        @Override public void run() {
                            EFFECTSCONTAINER.getChildren().remove(EFFECTICON);
                            effectTimer.cancel();
                            effectTimer.purge();
                        }
                    });
                }     
            }
        };
        //Starts the Effect
        effectTimer.schedule(effect, 0, 1000);
    }
}
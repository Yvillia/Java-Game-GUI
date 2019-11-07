package clientv04;

import javafx.application.Application;
import javafx.stage.Stage;

public class ClientV04 extends Application {
    
    private static Stage currentStage = new Stage();

    @Override
    public void start(Stage primaryStage) {
        
        primaryStage = currentStage;       
        currentStage.setTitle("Main Text Area");
        Login login = new Login(currentStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

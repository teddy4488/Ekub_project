
package project_x;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
Parent root=FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("PROJECT EKUB");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}

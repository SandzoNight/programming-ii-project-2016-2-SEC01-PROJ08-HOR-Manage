package view.home;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.DBConnector;
import view.dialog.ExitConfirmBox;

public class HorProject extends Application {
    
    protected static Stage window;
    protected static Scene defaultScene;
    
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("HOR Manager Application");
        defaultScene = new MainMenu().open();
        
        //Call Exit Confirm Box when trying to close the program
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        
        window.setScene(defaultScene);
        window.show();
    }

    public void closeProgram(){
        boolean answer = ExitConfirmBox.display();
        if(answer){
            DBConnector.disconnect();
            window.close();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
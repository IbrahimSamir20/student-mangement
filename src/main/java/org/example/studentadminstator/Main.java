package org.example.studentadminstator;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import org.example.studentadminstator.components.CustomInput;
import org.example.studentadminstator.components.Test;
import org.example.studentadminstator.pages.Login;

public class Main extends Application {
    @Override
    public void start(Stage stage) {

        try {
           Login login = new Login(stage);
           Scene scene = new Scene(login.getGrid(),1024,900);
           stage.setScene(scene);
           stage.setTitle("Student Administrator");
           stage.show();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
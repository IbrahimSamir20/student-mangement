package org.example.studentadminstator;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import org.example.studentadminstator.pages.Login;
import org.example.studentadminstator.pages.Register;
import org.example.studentadminstator.pages.StudentPage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
           Login login = new Login(stage);
           Register register = new Register(stage);
           StudentPage studentPage = new StudentPage(stage);
           Scene scene = new Scene(studentPage.getGrid(),1024,900);
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
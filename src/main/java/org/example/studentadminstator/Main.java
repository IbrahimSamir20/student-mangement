package org.example.studentadminstator;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import org.example.studentadminstator.pages.Login;
// import org.example.studentadminstator.pages.Register;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Login login = new Login(stage);
        // Register register = new Register(stage);
        Scene scene = new Scene(login.getGrid(),1024,900);
        stage.setTitle("Student Administrator");
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch();
    }
}
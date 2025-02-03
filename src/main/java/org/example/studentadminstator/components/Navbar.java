package org.example.studentadminstator.components;

import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Navbar extends HBox {
        @Override
        public void start(Stage primaryStage) {
            Button button = new Button("Edit profille");
            Button button2 = new Button("Back");
            HBox hbox = new HBox(button,button2);
            hbox.setAlignment(Pos.TOP_RIGHT);
            hbox.setSpacing(10);
            hbox.setPadding(new Insets(20));
            Scene scene = new Scene(hbox, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        public static void main(String[] args) {
            launch();
        }
    }


}

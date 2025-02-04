package org.example.studentadminstator.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import org.example.studentadminstator.AppStyle;
import org.example.studentadminstator.pages.Login;

public class Navbar extends HBox {

    private String username ;
    Text text;
    CustomButton editButton;
    CustomButton backButton;

    public Navbar(String username, Stage stage) {

        this.username = username;
        this.text = new Text("Hello," + username + "!");
        text.setFont(AppStyle.font18);
        text.setFill(AppStyle.textColor);
        HBox hbox = new HBox();
        EventHandler<ActionEvent> onEdit = e -> {

        };
        EventHandler<ActionEvent> onBack = e -> {
            stage.setScene(new Scene(new Login(stage).getGrid()));
            stage.show();
        };
        editButton = new CustomButton(onEdit, "Edit");
        backButton = new CustomButton(onBack, "Back");
        hbox.setAlignment(Pos.TOP_RIGHT);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(20));
        hbox.getChildren().addAll(text, editButton, backButton);
        this.getChildren().addAll(hbox);
    }
   
    public String getUsername(){
        return username;
    }

// // public class Navbar extends HBox {

//         public void start(Stage primaryStage) {
//         //     Scene scene = new Scene(hbox, 400, 400);
//         //     primaryStage.setScene(scene);
//         //     primaryStage.show();
//         }
//         // public static void main(String[] args) {
//         //     launch();
//         // }
// //     }



}
package org.example.studentadminstator.components;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Navbar extends HBox {

        private String username ;
        Text text;
        Button button = new Button("Edit profille");
        Button button2 = new Button("Back");

    
    public Navbar(String username) {
        this.username = username;
        this.text= new Text("Hello,");
        HBox hbox = new HBox(button,button2);
        VBox vbox = new VBox();
        
        hbox.setAlignment(Pos.TOP_RIGHT);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(vbox,hbox);
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



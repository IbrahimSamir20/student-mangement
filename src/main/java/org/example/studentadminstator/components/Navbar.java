package org.example.studentadminstator.components;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import org.example.studentadminstator.AppStyle;
import org.example.studentadminstator.pages.Login;
/// Make sure that events and buttons and button labels are ordered and does not differ in size
public class Navbar extends BorderPane {

    private String username;
    Text hiText;
    Text nameText;

    public Navbar(String username, Stage stage, String[] buttonLabels,CustomButton[] buttons,EventHandler<ActionEvent>[] handlers) {

        hiText = new Text("Hi 👋");
        nameText = new Text(username);

        hiText.setFont(AppStyle.font18);
        nameText.setFont(AppStyle.font16Bold);

        hiText.setFill(AppStyle.textColor);
        nameText.setFill(AppStyle.textColor);

        VBox leftBox = new VBox(hiText, nameText);
        leftBox.setAlignment(Pos.CENTER_LEFT);
        leftBox.setSpacing(5);
        leftBox.setPadding(new Insets(10, 20, 10, 20));
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(20));
        for(int i = 0; i < buttons.length; i++) {
            buttons[i].setText(buttonLabels[i]);
            buttons[i].addEventHandler(ActionEvent.ACTION, handlers[i]);
            leftBox.getChildren().add(buttons[i]);
            hbox.getChildren().add(buttons[i]);

        }


        this.setLeft(leftBox);
        this.setRight(hbox);
    }
   
    public String getUsername(){
        return username;
    }
    public void updateName(String newName) {
        this.username = newName;
        this.nameText.setText("Hello, " + newName + "!");
    }


}
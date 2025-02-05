package org.example.studentadminstator.components;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
/// Make sure that events and buttons and button labels are ordered and does not differ in size
public class Navbar extends HBox {

    private String username ;
    Text text;

    public Navbar(String username, Stage stage, String[] buttonLabels,CustomButton[] buttons,EventHandler<ActionEvent>[] handlers) {

        this.username = username;
        this.text = new Text("Hello," + username + "!");
        text.setFont(AppStyle.font18);
        text.setFill(AppStyle.textColor);
        HBox hbox = new HBox();
        for(int i = 0; i < buttons.length; i++) {
            buttons[i].setText(buttonLabels[i]);
            buttons[i].addEventHandler(ActionEvent.ACTION, handlers[i]);
            hbox.getChildren().add(buttons[i]);
        }
        hbox.setAlignment(Pos.TOP_RIGHT);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(20));
        hbox.getChildren().add(text);
        this.getChildren().addAll(hbox);
    }
   
    public String getUsername(){
        return username;
    }
    public void updateStudentName(String newName) {
        this.username = newName;
        this.text.setText("Hello, " + newName + "!");
    }


}
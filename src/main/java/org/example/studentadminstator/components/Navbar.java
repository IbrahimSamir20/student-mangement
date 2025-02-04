package org.example.studentadminstator.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import org.example.studentadminstator.AppStyle;
import org.example.studentadminstator.pages.Login;

public class Navbar extends BorderPane {

    private String username;
    Text hiText;
    Text nameText;
    CustomButton editButton;
    CustomButton backButton;

    public Navbar(String username, Stage stage) {
        this.username = username;

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

        EventHandler<ActionEvent> onEdit = e -> {};
        EventHandler<ActionEvent> onBack = e -> {
            stage.setWidth(1024);
            stage.setHeight(900);
            stage.setScene(new Scene(new Login(stage).getGrid()));
            stage.show();
        };

        editButton = new CustomButton(onEdit, "Edit");
        backButton = new CustomButton(onBack, "Back");

        HBox hbox = new HBox(editButton, backButton);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(20));

        this.setLeft(leftBox);
        this.setRight(hbox);
    }

    public String getUsername() {
        return username;
    }
}

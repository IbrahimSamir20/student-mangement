package org.example.studentadminstator.components;

import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Navbar extends HBox {

    public Navbar() {
        CustomButton button = new  CustomButton(null,"Edit profile");
        CustomButton button2 = new CustomButton(null,"Back");
        HBox hbox = new HBox(button, button2);        hbox.setAlignment(Pos.TOP_RIGHT);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(20));
        getChildren().add(hbox);
    }
}



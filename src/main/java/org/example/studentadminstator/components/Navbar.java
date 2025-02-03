package org.example.studentadminstator.components;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Navbar extends HBox {

    private String uername ;
    Text text;

    public Navbar(String uername) {
        this.uername = uername;
        this.text= new Text("Hello,");
        VBox vbox = new VBox();
        vbox.getChildren().addAll(text);
    }

}

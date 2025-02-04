package org.example.studentadminstator.components;

import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.event.EventHandler;

import org.example.studentadminstator.AppStyle;

import javafx.event.ActionEvent;

public class Link extends HBox {
    Text text;
    Hyperlink link;

    public Link(String text, EventHandler<ActionEvent> handler, String buttonTitle) {
        this.text = new Text(text);
        this.link = new Hyperlink(buttonTitle);
        this.link.setOnAction(handler);
            //STYLE
        this.text.setFill(AppStyle.textColor);
        this.text.setFont(AppStyle.font14);
        this.link.setTextFill(AppStyle.textColor);
        this.link.setFont(AppStyle.font16Bold);
        this.getChildren().addAll(this.text, this.link);
    }
}

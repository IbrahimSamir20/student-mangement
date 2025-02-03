package org.example.studentadminstator.components;

import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import org.example.studentadminstator.AppStyle;


public class Sidebar extends VBox {
    private  Label label;
        public Sidebar (String label,CustomButton... buttons){
            this.label = new Label(label);
            this.label.setStyle("-fx-font-weight: bold; -fx-padding: 5;");

            this.getChildren().add(this.label);

            if (buttons != null) {
                for (CustomButton button : buttons) {
                    this.getChildren().add(button);
                    VBox.setMargin(button, new Insets(5, 10, 5, 10));
                }
            }

            this.setPadding(new Insets(10));
            this.setSpacing(5);
            this.setBackground(AppStyle.background);
        }
        }


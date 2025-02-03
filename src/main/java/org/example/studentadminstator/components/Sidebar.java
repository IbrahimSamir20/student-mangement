package org.example.studentadminstator.components;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import org.example.studentadminstator.AppStyle;

public class Sidebar extends VBox {
    private Label label;
    public Sidebar(String title, CustomButton handler) {
        label = new Label(title);
        label.setFont(AppStyle.font18Bold);
        label.setTextFill(AppStyle.textColor);
        VBox sideBox = new VBox(10);
        sideBox.setAlignment(Pos.CENTER_LEFT);

        sideBox.getChildren().add(label);

        CustomButton iButton = new CustomButton(handler[0], "Instructor");
        CustomButton sButton = new CustomButton(handler[1], "Student");
        CustomButton cButton = new CustomButton(handler[2], "Course");

        sideBox.getChildren().add(iButton);
        sideBox.getChildren().add(sButton);
        sideBox.getChildren().add(cButton);
        this.getChildren().add(sideBox);
    }
}

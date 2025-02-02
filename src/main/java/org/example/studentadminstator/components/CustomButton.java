package org.example.studentadminstator.components;
import org.example.studentadminstator.AppStyle;;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
// import javafx.scene.control.button;
// import javafx.scene.layout.VBox
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;

public class CustomButton extends VBox {
      private  Button button;

public CustomButton(EventHandler<ActionEvent> eventHandler, String label) {
        this.button = new Button(label);
        this.button.setOnAction(eventHandler);
        this.getChildren().add(this.button);
        
        button.setTextFill(AppStyle.textColor);
        button.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
        button.setPrefWidth(100);
        button.setFill(AppStyle.colorBlack );

      button.setOnMousePressed(e -> button.setScaleX(0.9));
      button.setOnMousePressed(e -> button.setScaleY(0.9));
      button.setOnMouseReleased(e -> button.setScaleX(1.0));
      button.setOnMouseReleased(e -> button.setScaleY(1.0));


}

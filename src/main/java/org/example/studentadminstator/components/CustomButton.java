package org.example.studentadminstator.components;
import org.example.studentadminstator.AppStyle;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
// import javafx.scene.control.button;
// import javafx.scene.layout.VBox
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;

public class CustomButton extends VBox {
      private  Button button;

public CustomButton(EventHandler<ActionEvent> eventHandler, String label) {
        this.button = new Button(label);
        this.button.setOnAction(eventHandler);
        this.getChildren().add(this.button);
        
        button.setTextFill(AppStyle.textColor);
        button.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
        button.setPrefWidth(100);
        button.setBackground(new Background(new BackgroundFill(AppStyle.colorLight, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(
            AppStyle.colorBlack,  
            BorderStrokeStyle.SOLID, 
            new CornerRadii(10), 
            new BorderWidths(2)  
        )));

      button.setOnMousePressed(e -> button.setScaleX(0.9));
      button.setOnMousePressed(e -> button.setScaleY(0.9));
      button.setOnMouseReleased(e -> button.setScaleX(1.0));
      button.setOnMouseReleased(e -> button.setScaleY(1.0));


      }
}


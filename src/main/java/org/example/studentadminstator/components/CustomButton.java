package org.example.studentadminstator.components;
import Javafx.event.EventHandler;
import javafx.scene.control.button;
import javafx.scene.layout.VBox

public class CustomButton extends VBox {

public CustomButtontom(EventHandler<ActionEvent> eventHandler,String lapel){

        this.button=new Button(label);

        this.button.setonAction(eventHandler);

        this.getchildren().add(this.button);
        


   Button button;

        button.setTextFill(AppStyle.textColor);
        button.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
        button.setPrefWidth(100);
        button.setFill(AppStyle.colorBlack );

      button.setOnMousePressed(e -> button.setScaleX(0.9));
      button.setOnMousePressed(e -> button.setScaleY(0.9));
      button.setOnMouseReleased(e -> button.setScaleX(1.0));
      button.setOnMouseReleased(e -> button.setScaleY(1.0));


}

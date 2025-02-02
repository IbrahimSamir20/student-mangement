package org.example.studentadminstator.components;
import Javafx.event.EventHandler;
import javafx.scene.control.button;
import javafx.scene.layout.VBox

public class CustomButton extends VBox {

public CustomButtontom(EventHandler<ActionEvent> eventHandler,String lapel){

        this.button=new Button(label);

        this.button.setonAction(eventHandler);

        this.getchildren().add(this.button);

        }


}

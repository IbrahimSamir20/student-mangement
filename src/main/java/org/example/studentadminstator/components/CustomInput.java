package org.example.studentadminstator.components;

import org.example.studentadminstator.AppStyle;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CustomInput extends VBox {
        private TextField input ;
        private Label label ;
        private Text errorMessage;

        public CustomInput(String placeholder, String labelText, String errorText, Boolean show){
              
                //declare var
                this.input = new TextField();
                this.input.setPromptText(placeholder);
                this.label = new Label(labelText);
                this.errorMessage = new Text(errorText);
        
                //style
                this.input.setPrefWidth(300);
                this.input.setFont(AppStyle.font18);
                this.label.setTextFill(AppStyle.textColor);
                this.label.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
                this.errorMessage.setFill(AppStyle.errorColor);
                this.errorMessage.setVisible(show);
                this.getChildren().addAll(label, input, errorMessage);
                this.setSpacing(5);
        
        }
}

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

        CustomInput(String placeholder,String labelText, String errorText){
              
                //declare var
                this.input = new TextField(placeholder);
                this.label = new Label(labelText);
                this.errorMessage = new Text(errorText);
        
                //style
                this.input.setPrefWidth(300);
                this.input.setFont(AppStyle.font18);
                this.label.setTextFill(AppStyle.textColor);
                this.label.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
                this.errorMessage.setFill(AppStyle.errorColor);
                this.input.textProperty().addListener((obs, oldValue , newValue)-> validate(newValue));
        
        }
        
        private void validate(String newValue) {
                if (newValue == null || newValue.trim().isEmpty()) {
                        errorMessage.setText("Input cannot be empty");
                        errorMessage.setVisible(true);
                } else {
                        errorMessage.setVisible(false);
                }
        }

        

}

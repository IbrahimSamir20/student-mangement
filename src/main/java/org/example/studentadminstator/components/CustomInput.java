package org.example.studentadminstator.components;

import org.example.studentadminstator.AppStyle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
        private Boolean isValid=false;

        public CustomInput(String placeholder, String labelText){
              
                //declare var
                this.input = new TextField();
                this.input.setPromptText(placeholder);
                this.label = new Label(labelText);
                this.errorMessage = new Text("");
                // this.labelText = labelText;
        
                //style
                this.input.setPrefWidth(300);
                this.input.setFont(AppStyle.font18);
                this.label.setTextFill(AppStyle.textColor);
                this.label.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
                this.errorMessage.setFill(AppStyle.errorColor);
                this.errorMessage.setVisible(false);
                this.getChildren().addAll(label, input, errorMessage);
                this.setSpacing(5);
        
                this.input.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                                System.out.println(newValue);
                                if (newValue.trim().isEmpty()) {
                                         setErrorMessage(labelText + " is required");
                                         isValid=false;
                                         if(labelText=="Password"){
                                                isValid=false;
                                                if(input.getText().length() < 6){

                                                        setErrorMessage(labelText + "must be at least 6 characters");
                                                        isValid=false;
                                                }
                                         }
                                      
                                } else {
                                        clearErrorMessage();
                                        isValid=true;
                                }
                        }
                });
        }

        
        public void setErrorMessage(String message){
                this.errorMessage.setText(message);
                this.errorMessage.setVisible(true);
        }
        
        public void clearErrorMessage(){
                this.errorMessage.setText("");
                this.errorMessage.setVisible(false);
        }
        public String getInputValue(){
                return input.getText().trim();
        }
        
        public boolean getIsValid(){
                return isValid;
        }
        
        
}

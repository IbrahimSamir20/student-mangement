package org.example.studentadminstator.pages;
import org.example.studentadminstator.AppStyle;
import org.example.studentadminstator.components.CustomInput;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Login extends VBox {
    private GridPane grid = new GridPane();
    
    String errorUsername = "";
    String errorPassword = "";
    Boolean isVisible = false;

    private CustomInput usernameInput = new CustomInput("Enter your username", "Username");
    private CustomInput passwordInput = new CustomInput("Enter Password","Password");
    private Button loginButton = new Button("submit");

    public Login(Stage primaryStage) {
        
        grid.setVgap(15);
        grid.setHgap(15);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Background background = new Background(AppStyle.backgroundImage);
        grid.setBackground(background);

        
        
        loginButton.setTextFill(AppStyle.textColor);
        loginButton.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
        loginButton.setPrefWidth(100);
        loginButton.setTextFill(AppStyle.textColor);

        grid.add(usernameInput, 0, 0, 1, 1);
        grid.add(passwordInput, 0, 1, 1, 1);
        grid.add(loginButton, 0, 2, 1, 1);


        EventHandler<ActionEvent> buttonEvent = e -> {
            Boolean usernameValid =  usernameInput.getIsValid();
            Boolean passwordValid =  passwordInput.getIsValid();
            System.out.println("Username valid: " + usernameValid.toString() + ", Password valid: " + passwordValid.toString());
                // System.out.println("logined");
                if(usernameValid && passwordValid){
                  System.out.println("submitted successful"+ usernameInput.getInputValue());
                }
        };

        loginButton.setOnAction(buttonEvent);
        
    }
    public GridPane getGrid(){
        return grid;
    }
}


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
import javafx.scene.text.Text;
// import javafx.scene.text.Text;
//use latter for controller
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.example.studentadminstator.components.CustomSelect;

public class Register extends VBox {
    // private String errorUsername = "";
    // private String errorPassword = "";
    // private String errorCourse = "";
    // private Boolean isVisible = false;
    Text header = new Text();
    private GridPane grid = new GridPane();
    private CustomInput usernameInput = new CustomInput("Enter your username", "Username");
    private CustomInput passwordInput = new CustomInput("Enter Password","Password");
    private CustomInput courseInput = new CustomInput("Enter Course","Course");
    private CustomSelect jobGroup = new CustomSelect("Job:", "Student", "Instructor");
    private CustomSelect genderGroup = new CustomSelect("Gender", "Male", "Female");
    private Button loginButton = new Button();
    
    public Register(Stage primaryStage) {
        
        grid.setVgap(15);
        grid.setHgap(15);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Background background = new Background(AppStyle.backgroundImage);
        grid.setBackground(background);

        header.setText("Register");
        header.setFont(AppStyle.font32);
        header.setFill(AppStyle.textColor);
        
        
        loginButton.setTextFill(AppStyle.textColor);
        loginButton.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
        loginButton.setPrefWidth(100);
        loginButton.setTextFill(AppStyle.textColor);
        
        EventHandler<ActionEvent> handelSubmit = e -> {
            Boolean usernameValid =  usernameInput.getIsValid();
            Boolean passwordValid =  passwordInput.getIsValid();
            Boolean courseValid =  courseInput.getIsValid();
            Boolean genderValid = genderGroup.isValid();
            Boolean jobValid = jobGroup.isValid();
            System.out.println("Username valid: " + usernameValid.toString() + ", Password valid: " + passwordValid.toString());
            //Register
            if(usernameValid && passwordValid && courseValid && genderValid && jobValid ) {
                System.out.println("submitted successful"+ usernameInput.getInputValue());
            }
        };
        
        loginButton.setOnAction(handelSubmit);
        grid.add(header, 0, 0, 1, 1);
        grid.add(usernameInput, 0, 1, 1, 1);
        grid.add(passwordInput, 0, 2, 1, 1);
        grid.add(courseInput, 0, 3, 1, 1);
        grid.add(jobGroup, 0, 4, 1, 1);
        grid.add(genderGroup, 0, 5, 1, 1);
        grid.add(loginButton, 0, 6, 1, 1);

    }
    public GridPane getGrid(){
        return grid;
    }
}


package org.example.studentadminstator.pages;

import org.example.studentadminstator.AppStyle;
import org.example.studentadminstator.components.CustomInput;

import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.Alert;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
//use latter for controller
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.example.studentadminstator.components.CustomSelect;

public class Register extends VBox {
    private String errorUsername = "";
    private String errorPassword = "";
    private String errorCourse = "";
    private GridPane grid = new GridPane();
    private CustomInput usernameInput = new CustomInput("Enter your username", "Username", errorUsername);
    private CustomInput passwordInput = new CustomInput("Enter Password","Password",errorPassword);
    private CustomInput courseInput = new CustomInput("Enter Course","Course",errorCourse);
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



        loginButton.setTextFill(AppStyle.textColor);
        loginButton.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
        loginButton.setPrefWidth(100);
        loginButton.setTextFill(AppStyle.textColor);
        grid.add(usernameInput, 0, 0, 1, 1);
        grid.add(passwordInput, 0, 1, 1, 1);
        grid.add(courseInput, 0, 2, 1, 1);
        grid.add(jobGroup, 0, 3, 1, 1);
        grid.add(genderGroup, 0, 4, 1, 1);
        grid.add(loginButton, 0, 5, 1, 1);

        EventHandler<ActionEvent> buttonEvent = e -> {
            if(usernameInput.isValid() && passwordInput.isValid() && courseInput.isValid()){
                //Should Go to the next page
            }else {
                errorUsername = "Username cannot be empty";
                errorPassword = "Password cannot be empty";
                errorCourse = "Course cannot be empty";
                //This is a replacement to error text TODO(IbrahimSamir): Check this
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Empty Field");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the fields correctly");
                alert.showAndWait();

            }
        };

        loginButton.setOnAction(buttonEvent);

    }
    public GridPane getGrid(){
        return grid;
    }
}


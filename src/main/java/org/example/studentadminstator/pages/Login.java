package org.example.studentadminstator.pages;

import org.example.studentadminstator.AppStyle;
import org.example.studentadminstator.components.CustomButton;
import org.example.studentadminstator.components.CustomInput;
import org.example.studentadminstator.data.User;
import org.example.studentadminstator.data.UsersDB;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Login extends VBox {
    private GridPane grid = new GridPane();
    Text header = new Text("Login");
    String errorUsername = "";
    String errorPassword = "";
    Boolean isVisible = false;
    StudentPage studentPage = new StudentPage();
    InstructorPage instructorPage = new InstructorPage();
    AdministerPage administerPage = new AdministerPage();
    UsersDB<User> userDb = new UsersDB<>();
    private CustomInput usernameInput = new CustomInput("Enter your username", "Username");
    private CustomInput passwordInput = new CustomInput("Enter Password","Password");
    private CustomButton button;
    
    public Login(Stage primaryStage) {
        
        grid.setVgap(15);
        grid.setHgap(15);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Background background = new Background(AppStyle.backgroundImage);
        grid.setBackground(background);
        header.setFont(AppStyle.font32);
        header.setFill(AppStyle.textColor);

        EventHandler<ActionEvent> onSubmit = e -> {
            Boolean usernameValid =  usernameInput.getIsValid();
            Boolean passwordValid =  passwordInput.getIsValid();
            System.out.println("Username valid: " + usernameValid.toString() + ", Password valid: " + passwordValid.toString());
            String username = usernameInput.getInputValue();
            String password = passwordInput.getInputValue();

            if(usernameValid && passwordValid){

                //Authorization
                    if(usernameInput.getInputValue().equals("IANEOP") && passwordInput.getInputValue().equals("IANEOP") ){
                        System.out.println("Login successfully");
                        primaryStage.setScene(new Scene(administerPage.getGrid()));
                    }else if(!userDb.searchUser(username, password)){
                        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
                        alert.setTitle("Login Error");
                        alert.setHeaderText("Invalid Credentials");
                        alert.setContentText("Username or password is incorrect.");
                        alert.showAndWait();
                    }else{
                        if(userDb.getType(username).equals("instructor")){
                            primaryStage.setScene(new Scene(instructorPage.getGrid()));
                            System.out.println("from instructorPage");
                        }else{
                            primaryStage.setScene(new Scene(studentPage.getGrid()));
                            System.out.println("from studentPage");
                        }
                    }
                    
                    
                   


                }
                
            };

            button = new CustomButton(onSubmit, "Login");
            grid.add(header, 0, 0, 1, 1);
            grid.add(usernameInput, 0, 2, 1, 1);
            grid.add(passwordInput, 0, 3, 1, 1);
            grid.add(button, 0, 4, 1, 1);
        
    }
    public GridPane getGrid(){
        return grid;
    }
}


package org.example.studentadminstator.pages;
// import java.lang.classfile.Label;

import org.example.studentadminstator.AppStyle;
import org.example.studentadminstator.components.CustomButton;
import org.example.studentadminstator.components.CustomInput;

import javafx.scene.layout.VBox;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
// import javafx.scene.text.Font;
// import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
// import io.github.cdimascio.dotenv.Dotenv;

public class Login extends VBox {
    private GridPane grid = new GridPane();
    Text header = new Text("Login");
    String errorUsername = "";
    String errorPassword = "";
    Boolean isVisible = false;
    Student student = new Student();
    private CustomInput usernameInput = new CustomInput("Enter your username", "Username");
    private CustomInput passwordInput = new CustomInput("Enter Password","Password");
    // private Button loginButton = new Button("submit");
    private CustomButton button;
    public Login(Stage primaryStage) {
        
        grid.setVgap(15);
        grid.setHgap(15);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Background background = new Background(AppStyle.backgroundImage);
        grid.setBackground(background);
        
        // header.setText("L");
        header.setFont(AppStyle.font32);
        header.setFill(AppStyle.textColor);
        
        
        // loginButton.setTextFill(AppStyle.textColor);
        // loginButton.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
        // loginButton.setPrefWidth(100);
        // loginButton.setTextFill(AppStyle.textColor);


        // grid.add(labelNav, 0, 3, 1, 1);
        

        EventHandler<ActionEvent> onSubmit = e -> {
            Boolean usernameValid =  usernameInput.getIsValid();
            Boolean passwordValid =  passwordInput.getIsValid();
            System.out.println("Username valid: " + usernameValid.toString() + ", Password valid: " + passwordValid.toString());
            //Login




            if(usernameValid && passwordValid){
                //   System.out.println("submitted successful"+ usernameInput.getInputValue());

                   //Authorization
                    if(usernameInput.getInputValue().equals("IANEOP") && passwordInput.getInputValue().equals("IANEOP") ){
                        System.out.println("Login successfully");
                        primaryStage.setScene(new Scene(student.getGrid(), 1024, 900));
                    }

                    // here logic for search about userName
                    // System.out.println(System.getenv());


                }
                
            };
            button = new CustomButton(onSubmit, "Login");
            
            grid.add(header, 0, 0, 1, 1);
            grid.add(usernameInput, 0, 2, 1, 1);
            grid.add(passwordInput, 0, 3, 1, 1);
            grid.add(button, 0, 4, 1, 1);
        // loginButton.setOnAction(buttonEvent);
        
    }
    public GridPane getGrid(){
        return grid;
    }
}


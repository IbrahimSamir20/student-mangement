package org.example.studentadminstator.pages;

import javafx.event.Event;
import javafx.scene.Scene;
import org.example.studentadminstator.AppData;
import org.example.studentadminstator.AppStyle;
import org.example.studentadminstator.components.CustomButton;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.example.studentadminstator.components.CustomSelect;
import org.example.studentadminstator.components.Link;
import org.example.studentadminstator.data.*;

import java.util.ArrayList;

public class Register extends VBox {
    Text header = new Text();
    private GridPane grid = new GridPane();
    private CustomInput usernameInput = new CustomInput("Enter your username", "Username");
    private CustomInput passwordInput = new CustomInput("Enter Password","Password");
    //private CustomInput courseInput = new CustomInput("Enter Course","Course");
    private CustomSelect jobGroup = new CustomSelect("Job:", "Student", "Instructor");
    private CustomSelect genderGroup = new CustomSelect("Gender", "Male", "Female");
    private CustomButton loginButton;
    AppData data = AppData.getInstance();
    UsersDB<User> usersDB = data.getUsersDB();
    InstructorDB<Instructor> instructorDB = data.getInstructorDB();
    StudentDB<Student> studentDB = data.getStudentDB();
    Text loginAlert = new Text();
    Stage primaryStage;
    Link link;

    public Register(Stage primaryStage) {

        grid.setVgap(15);
        grid.setHgap(15);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Background background = new Background(AppStyle.backgroundImage);
        grid.setBackground(background);
        this.primaryStage=primaryStage;
        header.setText("Register");
        header.setFont(AppStyle.font32);
        header.setFill(AppStyle.textColor);
        this.link= new Link("if you have an account", this::handleEvent, "Signin");

        EventHandler<ActionEvent> handelSubmit = e -> {
            Boolean usernameValid =  usernameInput.getIsValid();
            Boolean passwordValid =  passwordInput.getIsValid();
            //Boolean courseValid =  courseInput.getIsValid();
            Boolean genderValid = genderGroup.isValid();
            Boolean jobValid = jobGroup.isValid();
           
            System.out.println("Username valid: " + usernameValid.toString() + ", Password valid: " + passwordValid.toString());
            //Register
            if(usernameValid && passwordValid && genderValid && jobValid ) {
                if(usersDB.searchUser(usernameInput.getInputValue(), passwordInput.getInputValue())) {
                    loginAlert.setText("User already exists Click on Sign in");
                    loginAlert.setFont(AppStyle.font18Bold);
                    loginAlert.setFill(AppStyle.textColor);
                    System.out.println("Found user successful"+ usernameInput.getInputValue());
                }else{
                    usersDB.createUser(new User(usernameInput.getInputValue(), passwordInput.getInputValue(), jobGroup.getSelectedOption()));
                    System.out.println("Created successful"+ usernameInput.getInputValue() + "Created Type" + jobGroup.getSelectedOption());
                    if(jobGroup.getSelectedOption().equals("Instructor")) {
                        instructorDB.createInstructor(new Instructor(usernameInput.getInputValue(), passwordInput.getInputValue(), genderGroup.getSelectedOption()));
                        Instructor instructor = instructorDB.fetchOneInstructor(usernameInput.getInputValue());
                        primaryStage.setScene(new Scene(new InstructorPage(primaryStage,instructor).getPage()));

                    }else {
                        //Fixed Error
                        studentDB.createStudent(new Student(usernameInput.getInputValue(), passwordInput.getInputValue(), genderGroup.getSelectedOption()));
                        int indexOfStudent = studentDB.getStudentIndex(usernameInput.getInputValue());
                        Student student = studentDB.fetchOneStudent(indexOfStudent);
                        primaryStage.setScene(new Scene(new StudentPage(primaryStage,student).getPage()));
                    }
                }



            }
        };

        loginButton = new CustomButton(handelSubmit,"Submit");
        grid.add(header, 0, 0, 1, 1);
        grid.add(usernameInput, 0, 1, 1, 1);
        grid.add(passwordInput, 0, 2, 1, 1);
        //grid.add(courseInput, 0, 3, 1, 1);
        grid.add(jobGroup, 0, 4, 1, 1);
        grid.add(genderGroup, 0, 5, 1, 1);
        grid.add(loginAlert, 0, 6, 1, 1);
        grid.add(loginButton, 0, 7, 1, 1);
        grid.add(link, 0, 8, 1, 1);

    }
    public void handleEvent(Event e) {
        primaryStage.setScene(new Scene(new Login(primaryStage).getGrid()));
        primaryStage.setWidth(1024);
        primaryStage.setHeight(900);
    }
    public GridPane getGrid(){
        return grid;
    }
}


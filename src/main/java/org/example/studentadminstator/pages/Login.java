package org.example.studentadminstator.pages;

import org.example.studentadminstator.AppData;
import org.example.studentadminstator.AppStyle;
import org.example.studentadminstator.components.CustomButton;
import org.example.studentadminstator.components.CustomInput;
import org.example.studentadminstator.components.Link;
import org.example.studentadminstator.data.Course;
import org.example.studentadminstator.data.CoursesDB;
import org.example.studentadminstator.data.Instructor;
import org.example.studentadminstator.data.InstructorDB;
import org.example.studentadminstator.data.Student;
import org.example.studentadminstator.data.StudentDB;
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
import javafx.event.Event;
import javafx.event.EventHandler;

public class Login extends VBox {

    //UI
    private final GridPane grid = new GridPane();
    private final Stage primaryStage;
    private final CustomInput usernameInput = new CustomInput("Enter your username", "Username");
    private final CustomInput passwordInput = new CustomInput("Enter Password","Password");
    Link link ;
    Text header = new Text("Login");
    String errorUsername = "";
    String errorPassword = "";
    Boolean isVisible = false;

    //pages
    StudentPage studentPage ;
    InstructorPage instructorPage ;
    AdministerPage administerPage ;

    //DB
    AppData data = AppData.getInstance();
    CoursesDB<Course> coursesDB = data.getCoursesDB();
    UsersDB<User> userDb = data.getUsersDB();
    InstructorDB<Instructor> instructorDB = data.getInstructorDB();
    StudentDB<Student> studentDB = data.getStudentDB();
    
    // Start Logic
    public Login(Stage primaryStage) {
        this.primaryStage=primaryStage;
        
        
        grid.setVgap(15);
        grid.setHgap(15);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Background background = new Background(AppStyle.backgroundImage);
        grid.setBackground(background);
        header.setFont(AppStyle.font32);
        header.setFill(AppStyle.textColor);
        this.link= new Link("if you don't have account", this::handleEvent, "Signup");

    //Action
        EventHandler<ActionEvent> onSubmit = e -> {
            Boolean usernameValid =  usernameInput.getIsValid();
            Boolean passwordValid =  passwordInput.getIsValid();
            System.out.println("Username valid: " + usernameValid.toString() + ", Password valid: " + passwordValid.toString());
//            String username = usernameInput.getInputValue();
//            String password = passwordInput.getInputValue();

            if(usernameValid && passwordValid){

                //Authorization
                    if(usernameInput.getInputValue().equals("IANEOP") && passwordInput.getInputValue().equals("IANEOP") ){
                        System.out.println("Login successfully");
                        primaryStage.setScene(new Scene(new AdministerPage(primaryStage).getPage(),1024,900));
                    }else if(!userDb.searchUser(usernameInput.getInputValue(), passwordInput.getInputValue())){
                        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
                        alert.setTitle("Login Error");
                        alert.setHeaderText("Invalid Credentials");
                        alert.setContentText("Username or password is incorrect.");
                        alert.showAndWait();
                    }else{
                        if(userDb.getUserType(usernameInput.getInputValue()).equals("Instructor")){

                            Instructor instructor = instructorDB.fetchOneInstructor(usernameInput.getInputValue());
                            primaryStage.setScene(new Scene(new InstructorPage(primaryStage, instructor).getPage()));
                            System.out.println(instructor);

                        }else{

                            System.out.println(usernameInput.getInputValue());
                            Student student = studentDB.fetchOneStudentByName(usernameInput.getInputValue());
                            System.out.println(student.getName());
                            primaryStage.setScene(new Scene(new StudentPage(primaryStage, student).getPage()));
                            System.out.println("from studentPage");

                        }
                    }
                }
                
            };
        CustomButton button = new CustomButton(onSubmit, "Login");
            grid.add(header, 0, 0, 1, 1);
            grid.add(usernameInput, 0, 2, 1, 1);
            grid.add(passwordInput, 0, 3, 1, 1);
            grid.add(button, 0, 4, 1, 1);
            grid.add(link, 0, 5, 1, 1);
        
    }
    public void handleEvent(Event e) {
        primaryStage.setScene(new Scene(new Register(primaryStage).getGrid()));
        primaryStage.setWidth(1024);
        primaryStage.setHeight(900);
    }
    public GridPane getGrid(){
        return grid;
    }
}


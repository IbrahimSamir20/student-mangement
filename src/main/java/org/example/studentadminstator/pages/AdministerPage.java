package org.example.studentadminstator.pages;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
// import org.example.studentadminstator.components.CustomButton;
import org.example.studentadminstator.AppData;
import org.example.studentadminstator.AppStyle;
import org.example.studentadminstator.components.CustomButton;
import org.example.studentadminstator.components.CustomTable;
import org.example.studentadminstator.components.Navbar;
import org.example.studentadminstator.components.Sidebar;
import org.example.studentadminstator.data.Course;
import org.example.studentadminstator.data.User;
import org.example.studentadminstator.data.CoursesDB;
import org.example.studentadminstator.data.UsersDB;
import org.example.studentadminstator.data.InstructorDB;
import org.example.studentadminstator.data.StudentDB;
import org.example.studentadminstator.data.Instructor;
import org.example.studentadminstator.data.Student;

// import java.beans.EventHandler;
// import java.lang.reflect.Array;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class AdministerPage extends BorderPane {
        //TODO: Get Databases from AppData
        AppData data = AppData.getInstance();
        UsersDB<User> usersDB = data.getUsersDB();
        InstructorDB<Instructor> instructorDB = data.getInstructorDB();
        StudentDB<Student> studentDB = data.getStudentDB();
        CoursesDB<Course> coursesDB = data.getCoursesDB();
        private Stage primaryStage;

        private EventHandler[] handlers = new EventHandler[3];

        public AdministerPage(Stage primaryStage) {
                this.primaryStage = primaryStage;
                this.setBackground(AppStyle.background);
                EventHandler<ActionEvent> onEdit = event -> {};
                EventHandler<ActionEvent> onBack = event -> {
                        primaryStage.setScene(new Scene(new Login(primaryStage).getGrid()));
                        primaryStage.show();
                };
                String[] labels = {"Edit", "Back"};
                EventHandler[] navHandlers = {onEdit, onBack};
                CustomButton[] buttons = {new CustomButton(), new CustomButton()};
                Navbar navbar = new Navbar("Admin Dashboard",primaryStage, labels, buttons,navHandlers);
                this.setTop(navbar);

                Sidebar sidebar = new Sidebar("dashboard",handlers);
                this.setLeft(sidebar);

                CustomTable<Course> courseTable = new CustomTable<>();
                courseTable.addColumn("Course Name", "name", 400);

                VBox courseContainer = new VBox();
                courseContainer.setPadding(new Insets(10));
                courseContainer.setSpacing(10);

                Label courseLabel = new Label("Course");
                courseContainer.getChildren().addAll(courseLabel, courseTable);
                this.setCenter(courseContainer);
        }
        //TODO: Editable Table and Add Course Button

        public BorderPane getPage() {
                return this;
        }
}
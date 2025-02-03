package org.example.studentadminstator.pages;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
// import org.example.studentadminstator.components.CustomButton;
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
        
        private CoursesDB<Course> coursesDB;
        private UsersDB<User> userDb;
        private InstructorDB<Instructor> instructorDB;
        private StudentDB<Student> studentDB;
        private Stage primaryStage;
        
        @SuppressWarnings("unchecked") // Suppress unchecked conversion warning
        EventHandler<ActionEvent>[] handlers = new EventHandler[3]; 

        public AdministerPage(CoursesDB<Course> coursesDB, UsersDB<User> userDb, InstructorDB<Instructor> instructorDB, StudentDB<Student> studentDB, Stage primaryStage) {
                this.coursesDB = coursesDB;
                this.userDb = userDb;
                this.instructorDB = instructorDB;
                this.studentDB = studentDB;
                this.primaryStage = primaryStage;
                this.setStyle("-fx-background-color: black;");

                Navbar navbar = new Navbar("Admin Dashboard");
                this.setTop(navbar);

                Sidebar sidebar = new Sidebar("das",handlers);
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
        //Edit Table

        public BorderPane getPage() {
                return this;
        }
}
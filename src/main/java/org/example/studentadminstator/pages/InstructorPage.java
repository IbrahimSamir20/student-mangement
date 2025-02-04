package org.example.studentadminstator.pages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import org.example.studentadminstator.AppData;
import org.example.studentadminstator.components.CustomTable;
import org.example.studentadminstator.components.Navbar;
import org.example.studentadminstator.data.*;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class InstructorPage extends BorderPane {
        AppData appData = AppData.getInstance();
        CoursesDB<Course> coursesDB = appData.getCoursesDB();
        InstructorDB<Instructor> instructorDB = appData.getInstructorDB();
        StudentDB<Student> studentDB = appData.getStudentDB();

        public InstructorPage(Stage primaryStage,Instructor instructor){
                Navbar navbar = new Navbar("", primaryStage);
                this.setTop(navbar);
                this.setMinSize(1024,900);


                CustomTable<Instructor> instructorTable = new CustomTable<Instructor>();
                instructorTable.addColumn("Course", "Course", 350);
                instructorTable.addColumn("Student", "student", 350);
                instructorTable.addColumn("Attendance", "attendant", 350);
                instructorTable.addColumn("Grade", "grade", 350);
                ObservableList<Course> tableCourses = FXCollections.observableArrayList();
                ArrayList<Course> courses= coursesDB.fetch();
                //TODO: add the courses that this instructor teach
                for(Course c : courses){
                      final var get =  tableCourses.add(c);
                }

                VBox instructorContainer = new VBox();
                instructorContainer.setPadding(new Insets(10));
                instructorContainer.setSpacing(10);

                Label courseLabel = new Label("Course");
                instructorContainer.getChildren().addAll(courseLabel, instructorTable);
                this.setCenter(instructorContainer);
                
        }

        public BorderPane getPage() {
                return this;
        }
}

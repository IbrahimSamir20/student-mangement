package org.example.studentadminstator.pages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import org.example.studentadminstator.AppData;
import org.example.studentadminstator.components.CustomAttendanceBox;
import org.example.studentadminstator.components.CustomButton;
import org.example.studentadminstator.components.CustomTable;
import org.example.studentadminstator.components.Navbar;
import org.example.studentadminstator.data.*;

import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class InstructorPage extends BorderPane {
        AppData appData = AppData.getInstance();
        CoursesDB<Course> coursesDB = appData.getCoursesDB();
        InstructorDB<Instructor> instructorDB = appData.getInstructorDB();
        StudentDB<Student> studentDB = appData.getStudentDB();

        public InstructorPage(Stage primaryStage,Instructor instructor){
                EventHandler<ActionEvent> onEdit = event -> {};
                EventHandler<ActionEvent> onBack = event -> {
                        primaryStage.setScene(new Scene(new Login(primaryStage).getGrid()));
                        primaryStage.show();
                };
                String[] labels = {"Edit", "Back"};
                EventHandler[] navHandlers = {onEdit, onBack};
                CustomButton[] buttons = {new CustomButton(), new CustomButton()};
                Navbar navbar = new Navbar(instructor.getName(), primaryStage, labels, buttons, navHandlers);
                this.setTop(navbar);
                this.setMinSize(1024,900);


                CustomTable<Instructor> instructorTable = new CustomTable<Instructor>();
                instructorTable.addColumn("Course", "Course", 350);
                instructorTable.addColumn("Student", "student", 350);
                instructorTable.addColumn("Attendance", "attendant", 350);
                instructorTable.addColumn("Grade", "grade", 350);
                ObservableList<Course> tableCourses = FXCollections.observableArrayList();
                ArrayList<Course> courses= coursesDB.fetch();
                for (Course c : courses) {
                        if (c.getInstructor() == instructor) {
                                Student[] students = c.getStudents();
                                List<String> studentNames = new ArrayList<>();
                                if (students != null) {
                                        for (Student student : students) {
                                                studentNames.add(student.getName());
                                        }
                                }
                                //TODO: add student to view
                                tableCourses.add(c);
                        }
                }

                VBox instructorContainer = new VBox();
                instructorContainer.setPadding(new Insets(10));
                instructorContainer.setSpacing(10);

                Label courseLabel = new Label("Course");
                CustomAttendanceBox attendBox = new CustomAttendanceBox(30);
                instructorContainer.getChildren().addAll(courseLabel, instructorTable, attendBox);
                this.setCenter(instructorContainer);

                
        }

        public BorderPane getPage() {
                return this;
        }
}

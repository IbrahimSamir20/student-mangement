package org.example.studentadminstator.pages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.util.ArrayList;


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
                EventHandler<ActionEvent> onAdd = event -> {};
                EventHandler<ActionEvent> onEdit = event -> {};
                EventHandler<ActionEvent> onBack = event -> {
                        primaryStage.setScene(new Scene(new Login(primaryStage).getGrid()));
                        primaryStage.show();
                };
                String[] labels = {"Add","Edit", "Back"};
                EventHandler[] navHandlers = {onEdit, onBack};
                CustomButton[] buttons = {new CustomButton(),new CustomButton(), new CustomButton()};
                Navbar navbar = new Navbar("Admin Dashboard",primaryStage, labels, buttons,navHandlers);
                this.setTop(navbar);
                CustomTable<Course> courseTable = new CustomTable<>();

                VBox courseContainer = new VBox();
                courseContainer.setPadding(new Insets(10));
                courseContainer.setSpacing(10);

                Label courseLabel = new Label();
                courseContainer.getChildren().addAll(courseLabel, courseTable);
                this.setCenter(courseContainer);

                handlers[0] = e -> {
                        System.out.println("Instructor clicked");
                        courseTable.addColumn("Instructor Name", "instructor", 200);
                        courseTable.addColumn("Course", "name", 100);

                        ObservableList<Course> tableInstructor = FXCollections.observableArrayList();
                        ArrayList<Course> courses= coursesDB.fetch();
                        for(Course c : courses){
                                tableInstructor.add(c);
                        }
                        courseTable.setTableData(tableInstructor);


                };
                handlers[1] = e -> {
                        System.out.println("Student clicked");
                        courseTable.addColumn("Student", "students", 200);
                        courseTable.addColumn("Course", "name", 100);
                        courseTable.addColumn("Grade", "grade", 100);
                        courseTable.addColumn("Attendance", "attendant", 100);

                        ObservableList<Course> tableStudent = FXCollections.observableArrayList();
                        ArrayList<Course> courses= coursesDB.fetch();
                        for(Course c : courses){
                                tableStudent.add(c);
                        }
                        courseTable.setTableData(tableStudent);

                };
                handlers[2] = e -> {
                        System.out.println("Courses clicked");
                        courseTable.addColumn("Course", "name", 100);
                        courseTable.addColumn("Instructor", "instructor", 100);
                        courseTable.addColumn("Student", "students", 100);

                        ObservableList<Course> tableCourse = FXCollections.observableArrayList();
                        ArrayList<Course> courses= coursesDB.fetch();
                        for(Course c : courses){
                                tableCourse.add(c);
                        }
                        courseTable.setTableData(tableCourse);

                };

                Sidebar sidebar = new Sidebar("dashboard",handlers);
                this.setLeft(sidebar);


        }
        //TODO: Editable Table and Add Course Button

        public BorderPane getPage() {
                return this;
        }
}
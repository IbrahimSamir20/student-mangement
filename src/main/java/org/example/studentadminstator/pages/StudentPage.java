package org.example.studentadminstator.pages;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.studentadminstator.AppData;
import org.example.studentadminstator.components.CustomButton;
import org.example.studentadminstator.components.CustomTable;
import org.example.studentadminstator.components.Navbar;
import org.example.studentadminstator.data.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentPage extends BorderPane {
    AppData appData = AppData.getInstance();
    CoursesDB<Course> coursesDB = appData.getCoursesDB();
    InstructorDB<Instructor> instructorDB = appData.getInstructorDB();
       public StudentPage(Stage primaryStage,Student student){
           Navbar navbar = new Navbar(student.getName(), primaryStage);
           this.setTop(navbar);
           this.setMinSize(1024,900);

            CustomTable<Course> studentTable = new CustomTable<Course>();
            studentTable.addColumn("Course", "Course", 400);
            studentTable.addColumn("Attendance", "Attendance", 400);
            studentTable.addColumn("Grade", "Grade", 400);


           VBox studentContainer = new VBox();
            studentContainer.setPadding(new Insets(10));
            studentContainer.setSpacing(10);
            this.setCenter(studentContainer);
           studentContainer.getChildren().add(studentTable);

       }

    public BorderPane getPage() {
        return this;
    }

}

package org.example.studentadminstator.pages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.studentadminstator.AppData;
import org.example.studentadminstator.components.CustomTable;
import org.example.studentadminstator.components.Navbar;
import org.example.studentadminstator.data.*;
import java.util.ArrayList;

public class StudentPage extends BorderPane {
    AppData appData = AppData.getInstance();
    CoursesDB<Course> coursesDB = appData.getCoursesDB();
    InstructorDB<Instructor> instructorDB = appData.getInstructorDB();
       public StudentPage(Stage primaryStage,Student student){
           Navbar navbar = new Navbar(student.getName(), primaryStage);
           this.setTop(navbar);
           this.setMinSize(1024,900);

            CustomTable<Course> studentTable = new CustomTable<Course>();
            studentTable.addColumn("Name", "name", 250);
            studentTable.addColumn("Attendance", "attendant", 250);
            studentTable.addColumn("Grade", "grade", 250);

           ObservableList<Course> tableCourses = FXCollections.observableArrayList();
           ArrayList<Course> courses= coursesDB.fetch();
           for(Course c : courses){
               tableCourses.add(c);
           }
           studentTable.setTableData(tableCourses);
           VBox studentContainer = new VBox();
            studentContainer.setSpacing(10);
           studentContainer.setPadding(new Insets(10));
            this.setCenter(studentContainer);
           studentContainer.getChildren().add(studentTable);

       }

    public BorderPane getPage() {
        return this;
    }

}
